package Server.service;

import Common.Message;
import Common.MessageType;
import Common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 该类的作用：
 * 持续监听9999端口，等待客户端的连接，并保持通信
 * 客户端将会连接该类，然后传入用户信息进行核实，验证登录信息是否正确
 * 如果正确，就创建一个线程与该客户端连接
 *
 */
public class softwareServer {

    private ServerSocket serverSocket = null;

    //创建一个集合存放多个用户，如果是这些用户登录，就认为是合法的
    private static ConcurrentHashMap<String,User> validUser = new ConcurrentHashMap<>();//注意：hashmap不是线程安全，如果需要的的可以使用ConcurrentHashMap

    public static ConcurrentHashMap<String , ArrayList<Message>> OfflineUserMessage = new ConcurrentHashMap<>();

    static{ //当启动服务器时，该静态代码块就会被加载
        validUser.put("100",new User("100","000000")); //HashMap的key就是userID，但是value也是一个user对象
        validUser.put("101",new User("101","111111"));
        validUser.put("102",new User("102","222222"));
        validUser.put("103",new User("103","333333"));
        validUser.put("104",new User("104","444444"));
        validUser.put("105",new User("105","555555"));

        Set<String> userID = validUser.keySet();//得到全部用户的ID
        for (String UID : userID){
            OfflineUserMessage.put(UID , new ArrayList<>()); //给每个用户初始化一个可以存放离线消息的“库存”
        }

    }

    public boolean checkUser(String userID , String userPassword){//验证登录是否成功
        User user = validUser.get(userID); //通过key返回一个user对象，然后赋给这里的局部user对象
        if (user == null){//如果该user对象为null，表示没有这个用户被注册过，代表登录失败
            return false;
        }
        if (!(user.getPassword().equals(userPassword))){ //如果上面的user对象不是null，就到这里验证密码是否正确(然后如果密码正确就不会进入此语句因为感叹号取反了)
            return false;
        }
        return true;//如果user
    }

    /**
     * 该构造器主要处理了客户端传输过来的用户信息
     * 对用户的信息核实是否合法（ID和密码正确）
     * 如果用户的信息是正确的表示登录成功
     * 工作：
     * 1.主要需要接收客户端的用户信息
     * 2.验证用户信息
     * 3.通过Messsage对象传输结果给回客户端
     * 4.客户端再读取服务端的Message对象
     */
    public softwareServer(){
        //注意：端口可以写在一个配置文件中
        System.out.println("服务器在9999端口监听...");
        new Thread(new SendNews()).start();//开启推送新闻线程
        try {
            serverSocket = new ServerSocket(9999);

            while (true){ //因为我们不只监听一个客户端，所以需要使用while无限循环持续监听
                Socket acceptSocket = serverSocket.accept();//等待客户端连接

                //如果客户端成功连接了，就开始处理客户端发送过来的信息，客户端发送的数据是对象流，所以这里也使用对象流
                ObjectInputStream ois = new ObjectInputStream(acceptSocket.getInputStream());
                //提前创建一个ObjectOutputStream，当从客户端那里得到了用户信息并且验证结果后，通过这个对象oos对象写入Message对象返回给客户端
                ObjectOutputStream oos = new ObjectOutputStream(acceptSocket.getOutputStream());

                User user = (User) ois.readObject();//读取客户端发送过来的User对象（ID和密码）

                //接下来需要验证用户是否登录成功，然后会返回一个Message对象通知使用客户端的用户登录的结果
                Message message = new Message();

                //验证用户是否登录成功，由于还没有学到数据库，无法实现正常的验证用户功能，这里仅使用一个固定的HashMap集合做替代
                if (checkUser(user.getUserID(), user.getPassword())){
                    //登录成功
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCESS);//把message类的MessageType属性设置为MessageType接口的MESSAGE_LOGIN_SUCCESS常量表示登录成功
                    oos.writeObject(message);//通过oos写入message对象
                    //创建一个线程，该线程将会和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(acceptSocket, user.getUserID());
                    //启动线程
                    serverConnectClientThread.start();

                    //把该线程对象放入一个集合中进行管理
                    ManageClientThread.addServerThreadHashMap(user.getUserID() , serverConnectClientThread);

                    //当该用户登录时，检查是否有其他用户发送离线消息给该用户
                    new Thread(new OffLineMessage(user.getUserID())).start();

                }else { //登录失败
                    System.out.println("用户("+user.getUserID()+")登录失败...");
                    //如果登录失败，将message对象的messageType属性更改成MessageType接口的MESSAGE_LOGIN_FAIL表示登录失败
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);//通过oos对象流返回message对象给客户端

                    //如果登录失败，代表该客户端没有必要和服务器继续保持通信，所以关闭acceptSocket (由于服务器还需要服务其他客户端，所以serverSocket不能关闭)
                    acceptSocket.close();

                }


            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //如果上面的while无限循环退出了，代表服务器不再对每个客户端提供服务，表示关闭服务器，所以就关闭serverSocket。
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ConcurrentHashMap<String, User> getValidUser() {
        return validUser;
    }

    public static void setValidUser(ConcurrentHashMap<String, User> validUser) {
        softwareServer.validUser = validUser;
    }



}
