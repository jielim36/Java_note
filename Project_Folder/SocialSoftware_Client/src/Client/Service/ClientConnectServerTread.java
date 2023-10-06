package Client.Service;

import Client.Utils.Utility;
import Common.Message;
import Common.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 该类是一个客户端和服务器端相互通信的一个线程
 * 该线程持有Socket
 */
public class ClientConnectServerTread extends Thread{
    private Socket socket;//该线程需要一个Socket

    /**
     * 该构造器将会接收一个socket对象，从UserClientService核实用户成功登入后，就会创建该类对象，
     * 创建时传入UserClientService的socket对象
     * @param socket 从UserClientService类的checkUser方法中如果登入成功获取的socket对象
     */
    public ClientConnectServerTread(Socket socket){
        this.socket = socket;
    }

    /**
     * 该线程是保持和服务器端连接，保持通信的一个线程
     * 该线程使用while无限循环保持和服务器端的通信
     * 一直等待服务器端发送过来的消息
     *
     */
    @Override
    public void run() { //该线程是保持和服务器端连接，保持通信的一个线程
       //由于Thread需要在后台一直和服务器端通信，所以使用while无限循环
        while (true){

            try {
                Thread.sleep(10);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); //如果服务器端没有发送Message对象，线程会阻塞在这里

                //判断这个message类型，然后做出相应的业务处理
                if (message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){//如果用户发送的message类型是MESSSAGE RETURN ONLINE FRIEND,就做出相应的处理

                    //取出在线列表信息，并显示
                    String[] onelineUsers = message.getContent().split(" ");
                    System.out.println("\n\n========当前在线用户列表========");
                    for (int i = 0; i < onelineUsers.length ; i++) {
                        System.out.println("用户:" + onelineUsers[i]);
                    }

                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {//如果有其他人发送消息给该客户端
                    System.out.println("hhh");
                    System.out.println(message.getContent());

                }else if (message.getMessageType().equals(MessageType.MESSAGE_GROUP_MES)) {//如果有其他人群发消息，该客户端会收到，除了自己群发消息以外
                    System.out.println(message.getContent());

                }else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {//如果有其他客户端给该客户端发文件
                    System.out.println("\n\n");//空行（美观）
                    System.out.println(message.getSender() + " 发给你一个文件...");
                    System.out.println("默认安装路径为："+message.getDest());


                    //取出message的文件byte数组，通过文件输出流写到磁盘
                    FileOutputStream fos = new FileOutputStream(message.getDest());//设置下载路径
                    fos.write(message.getFileByte());

                    fos.close();
                    System.out.println("下载完成!!");


                }else if (message.getMessageType().equals(MessageType.MESSAGE_NEWS_MES)) {//如果有其他人群发消息，该客户端会收到，除了自己群发消息以外
                    System.out.println("服务器推送新闻："+message.getContent());

                } else {
                    System.out.println("是其他类型的message，暂不处理...");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
