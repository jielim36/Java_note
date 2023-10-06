package Client.Service;

import Client.Utils.Utility;
import Common.Message;
import Common.MessageType;
import Common.User;
import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 该类的工作：
 * 完成用户的大部分服务：
 * 1.登入/注册
 * 2.显示在线用户列表
 */
public class UserClientService {

    private User user = new User();//因为其他敌方可能需要用到user信息，比如可以提供get方法方便外部调用user信息
    private Socket socket;

    /**
     * 从View class中的mainMenu方法里调用该方法用于确认用户的信息是否正确
     * 该方法会与服务器对接以核实用户信息
     * @param userID 在View class中的main方法里，用户输入的用户ID
     * @param userPassword 在View class中的main方法里，用户输入的用户ID
     * @return  从服务器那里获得的核实用户信息的结果后返回true or false,
     *          之后mainMenu会依照这个来判断是否进入HomePage方法还是让用户重试登录
     */
    public boolean checkUser(String userID , String userPassword){

        boolean loginResult = false; //先默认登入结果为false

        //创建User对象，并且对user对象设置ID和密码
        user.setUserID(userID);
        user.setPassword(userPassword);

        //设置user的信息后，将该user对象传输到服务器
        //连接服务器...
        try {
            socket = new Socket(InetAddress.getByName("jielim36") , 9999);//服务器的端口是9999

            //得到对象流ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);//让oos发送user对象给服务器

            //读取从服务器核实user对象信息后返回的数据
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();//向下转型成Message类实例对象，方便调用该类的方法

            if (ms.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)){ //通过对象的MessageType属性确认是否和MessageType接口的MESSAGE_LOGIN_SUCCESS常量一致,如果一致表示登入成功
                //登入成功的话，我们需要创建一个和服务器保存通信的线程 -> 创建一个类ClientConnectServerThread
                ClientConnectServerTread ccsThread = new ClientConnectServerTread(socket);//传入socket
                //启动客户端线程
                ccsThread.start();

                //为了以后客户端的扩展，我们需要将线程放入到集合进行管理
                ManageClientConnectServerThread.addClientConnectServerServerThread(userID,ccsThread);//这里传入的线程是ClientConnectServerThread类的线程，里面含有socket

                loginResult = true;//把登入结果改为true，因为if语句判定了登入成功
            }else{ //登入失败
                //如果登录失败，我们就不能启动和服务器通信的线程，所以我们需要关闭socket
                socket.close();//登录失败就禁止继续和服务器通信
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginResult;//返回结果给View class 的mainMenu方法...判断是否登入成功
    }

    /**
     * 该方法的作用：
     * 当用户在客户端View class中的HomePage方法中输入1准备获取显示在线用户列表时就会调用该方法
     * 该方法会对服务器发送一个Message对象，Message类型使用MESSAGE_RETURN_ONLINE_FRIEND
     */
    public void onlineFriendList(){

        //发送一个Message，Message类型是MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
        message.setSender(user.getUserID());


        //发送给服务器
        try {
            //调用管理线程的类中的集合，通过userID当作Hashmap集合的key获得对应的线程
            ClientConnectServerTread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID());
            Socket socket1 = clientConnectServerThread.getSocket();//然后将获得的线程使用.getSocket方法赋给局部socket1对象
            ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());//然后通过socket1对象的.getOutputStream获得输出流赋给对象流oos
            oos.writeObject(message);//把message对象发送给服务器


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 由于关闭了main方法时，客户端的线程还在运作（while无限循环），无法正常关闭，所以需要个方法
     * 该方法的作用：
     * 退出客户端，并给服务器端发送一个退出系统的message对象通知服务器那里连接该客户端的线程也同时关闭
     */
    public void logOut(){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserID());//一定要指定该客户端是哪个用户，否则服务器端有许多客户端的线程，不知道要关闭哪个线程

        //发送message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(user.getUserID()+"退出了系统...");
            Thread.sleep(100);
            System.exit(0);//结束进程
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void PM(){
            onlineFriendList();//私聊前...显示有谁在线
            try {
                Thread.sleep(100); //为了防止在线用户列表太慢出来导致下面的信息先运行，这里睡眠一下
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Message message = new Message();
            message.setMessageType(MessageType.MESSAGE_COMM_MES);//设置成普通信息
            message.setSender(user.getUserID());//sender是自己
            System.out.println();
            System.out.print("请输入对方ID进行私聊:");
            message.setReceiver(Utility.readString(10));//写入要给哪个用户私聊...
        while (true) { //输入了对方的ID后就可以一直发消息给他

            System.out.print("输入内容:");
            message.setContent(Utility.readString(100));//输入想要说的话
            if (message.getContent().equals("!stop")){ //如果使用!stop指令，就会退出聊天室
                break;
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID()).getSocket().getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(700); //防止用户输入信息过快，和防止下一次输出“输入内容”时过快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void GroupChat(){ //群聊和私聊的分别就是：群里直接发消息，私聊需要询问给谁发消息
        onlineFriendList();//私聊前...显示有谁在线
        try {
            Thread.sleep(100); //为了防止在线用户列表太慢出来导致下面的信息先运行，这里睡眠一下
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GROUP_MES);//设置成普通信息
        message.setSender(user.getUserID());//sender是自己

        while (true) { //可以重复发消息，除非输入!stop

            System.out.print("输入内容:");
            message.setContent(Utility.readString(100));//输入想要说的话
            if (message.getContent().equals("!stop")){ //如果使用!stop指令，就会退出聊天室
                break;
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID()).getSocket().getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(700); //防止用户输入信息过快，和防止下一次输出“输入内容”时过快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void sendFile(){
        onlineFriendList();//获取在线用户列表
        try {
            Thread.sleep(150); //防止获取在线列表加载过慢导致后面的代码先输出
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.print("请输入对方的用户名:");
        String sendTo = Utility.readString(15);
        System.out.print("输入文件路径: ");
        String src = Utility.readString(100);
        System.out.print("输入对方的默认下载路径：");
        String dest = Utility.readString(100);

        clientFileService cfs = new clientFileService();//为了调用该对象的方法
        cfs.sendFileToOne(src,dest, user.getUserID(), sendTo);//调用发送文件的方法

    }

    public void offlineMessage() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_OFFLINE_MES);//设置成离线消息
        message.setSender(user.getUserID());//sender是自己
        System.out.println();
        System.out.print("请输入对方ID发送离线消息:");
        message.setReceiver(Utility.readString(10));//写入要给哪个用户私聊...
        System.out.print("输入内容:");
        message.setContent(Utility.readString(100));//输入想要说的话

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(700); //防止用户输入信息过快，和防止下一次输出“输入内容”时过快
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
