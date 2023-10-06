package Server.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

/**
 * 该类用于管理服务器端的线程
 * 该线程是用于和客户端保持通信的
 *
 */
public class ManageClientThread {

    private static HashMap<String , ServerConnectClientThread> serverThreadHashMap = new HashMap<>();

    /**
     * 该方法的作用：
     * 外部调用该方法时会传入userID和一个服务器的线程（该线程用于和客户端保持通信）
     * 然后添加进HashMap集合中
     * 所以一个用户ID会对应一个服务器线程（代表服务器的每一个线程都只服务对应的用户）
     *
     * @param userID 用户ID对应HashMap的key值
     * @param sccTread  sccThread是ServerConnectThread类的一个线程，该线程用于和客户端保持通信，将会放入HashMap的value值
     */
    public static void addServerThreadHashMap(String userID , ServerConnectClientThread sccTread){
        serverThreadHashMap.put(userID , sccTread);
    }

    public static HashMap<String, ServerConnectClientThread> getServerThreadHashMap(){
        return serverThreadHashMap;
    }
    public static void removeServerThreadHashMap(String userID){
        serverThreadHashMap.remove(userID);
    }
    /**
     * 该方法作用：
     * 当外部想要得到某个userID对应的线程时，调用该方法
     * 原理：HashMap的key是userID，value是对应的线程
     *      所以通过hashmap的get方法传入userID就可以获得对应的线程
     * @param userID
     * @return 返回userID对应的一个线程
     */
    public static ServerConnectClientThread getServerConnectClientThread(String userID){
        return serverThreadHashMap.get(userID);
    }

    /**
     * 该方法用于返回一个在线用户列表
     * @return
     */
    public static String getOnlineUserList(String own){
        Set<String> userNameSet = serverThreadHashMap.keySet();
        String userNameList = "";
        for (String o : userNameSet){
            if (!(o.equals(own))){ //客户端获取在线用户列表时不包括自己
                userNameList += o + " ";

            }
        }
        System.out.println(userNameList);
        return userNameList;
    }

    public static String getOfflineUserList(String own){
        String [] onlineUser = getOnlineUserList(own).split(" ");
        Set<String> allUserSet = softwareServer.getValidUser().keySet();
        String offlineUser = "";
        int i = 0;
        for (String userName : allUserSet){
            if (! (userName.equals(onlineUser[i]))){ //把在线用户和全部用户遍历后找出不一样的（表示不在线用户）
                offlineUser += userName + " ";
            }
        }
        return offlineUser;
    }

}
