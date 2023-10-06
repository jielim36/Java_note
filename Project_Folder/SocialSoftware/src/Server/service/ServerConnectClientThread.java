package Server.service;

import Common.Message;
import Common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 该类的作用：用于和某个客户端保持连接通信
 *
 * 创建一个线程，该线程里含有一个socket对象
 * 每个客户端连接服务器后服务器端都会产生一个新的该类的线程对象与每一个客户端保持通信
 * 所以需要使用userID来辨别哪个线程是对应哪个客户端的
 * 这个userID和对应的线程之后会放到HashMap集合中进行管理
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userID;



    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ServerConnectClientThread(Socket socket , String userID){
        this.socket = socket;
        this.userID = userID;

    }

    @Override
    public void run() { //这里线程处于一个运行的状态
        while (true){ //因为需要和客户端不断的保持通信，所以需要while无限循环

            try {
                System.out.println("服务器端和客户端("+userID+")保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //判断这个message类型，然后做出相应的业务处理
                if (message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){//如果用户发送的message类型是MESSSAGE RETURN ONLINE FRIEND,就做出相应的处理

                    System.out.println(message.getSender() + "要获取在线用户列表...");
                    String onlineUserList = ManageClientThread.getOnlineUserList(message.getSender());

                    //需要返回一个Message对象
                    Message messageReturn = new Message();
                    messageReturn.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);//设置message类型
                    messageReturn.setContent(onlineUserList);//设置message内容
                    messageReturn.setReceiver(message.getSender());//sender=之前是客户端send过来的，所以现在要收这个消息的人也是那个客户端

                    //然后通过ObjectOutputStream返回

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//现在这个类本身就是一个线程，所以直接用这里的socket就好
                    oos.writeObject(messageReturn);


                } else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){//客户端通知服务器要退出系统了

                    System.out.println(message.getSender()+"要退出系统了...");

                    //将这个客户端对应的线程从集合中移除
                    ManageClientThread.removeServerThreadHashMap(message.getSender());//Sender是在客户端发送消息时设置了自己的用户名，来到这里就可以使用该userID找到他对应的服务器端的线程进行移除
                    socket.close(); //关闭与该客户端保持通信的socket
                    break;//退出这个while无限循环

                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {//这个是接收客户端A的message对象转换成实际内容再传给客户端B

                    String Text = "\n"+message.getSender() + " 对你说：" + message.getContent();
                    Message messageReturn = new Message();
                    messageReturn.setMessageType(MessageType.MESSAGE_COMM_MES);
                    messageReturn.setContent(Text);

                        ObjectOutputStream oos = new ObjectOutputStream(ManageClientThread.getServerConnectClientThread(message.getReceiver()).socket.getOutputStream());
                        oos.writeObject(messageReturn);


                } else if (message.getMessageType().equals(MessageType.MESSAGE_GROUP_MES)) {

                    String Text = "\n"+message.getSender() + " 对全部人说：" + message.getContent();
                    Set<String> clientName = ManageClientThread.getServerThreadHashMap().keySet();//得到hashmap的所有key：key表示每个用户的id

                    for (String name : clientName){
                        if (!(clientName.equals(message.getSender()) )){ //发消息给除了自己以外的用户
                            ObjectOutputStream oos = new ObjectOutputStream(ManageClientThread.getServerConnectClientThread(name).socket.getOutputStream());//根据此时遍历的name传送过去给对应的客户端
                            Message messageReturn = new Message();
                            messageReturn.setMessageType(MessageType.MESSAGE_COMM_MES);
                            messageReturn.setContent(Text);
                            oos.writeObject(messageReturn);
                        }
                    }

                }else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {//A客户端要给B客户端发文件

                    ServerConnectClientThread sccTread = ManageClientThread.getServerConnectClientThread(message.getReceiver());//得到B客户端的线程
                    ObjectOutputStream oos = new ObjectOutputStream(sccTread.socket.getOutputStream());//对象输出流发送文件给B客户端
                    oos.writeObject(message);


                }else if (message.getMessageType().equals(MessageType.MESSAGE_NEWS_MES)) {//(已弃用...现在的新闻推送在SendNews类)服务器给所有人推送新闻（和群发消息的代码一样，只是这个消息去掉了（发消息给除了自己以外的用户这个功能））

                    String Text = "\n"+message.getSender() + " 推送新闻：" + message.getContent();
                    Set<String> clientName = ManageClientThread.getServerThreadHashMap().keySet();//得到hashmap的所有key：key表示每个用户的id

                    for (String name : clientName){
                            ObjectOutputStream oos = new ObjectOutputStream(ManageClientThread.getServerConnectClientThread(name).socket.getOutputStream());//根据此时遍历的name传送过去给对应的客户端
                            Message messageReturn = new Message();
                            messageReturn.setMessageType(MessageType.MESSAGE_COMM_MES);
                            messageReturn.setContent(Text);
                            oos.writeObject(messageReturn);
                    }


                }else if (message.getMessageType().equals(MessageType.MESSAGE_OFFLINE_MES)){//A客户端发送给B客户端离线消息
                    String Text = "\n"+message.getSender() + " 对你说：" + message.getContent();
                    Message messageReturn = new Message();
                    messageReturn.setMessageType(MessageType.MESSAGE_COMM_MES);//发送过来的即使是离线消息类型，但是返回给B客户端时还是普通消息类型
                    messageReturn.setContent(Text);
                    softwareServer.OfflineUserMessage.get(message.getReceiver()).add(messageReturn);//通过收件人（B客户端）的userID当作key找到对应的ArrayList然后添加message对象进去

                }else {
                    System.out.println("是其他类型的message，暂不处理...");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
