package Client.Service;

import java.util.HashMap;

/**
 *
 * 该类用于管理客户端连接到服务器端的线程
 *
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入一个HashMap，key就是用户id，value就是线程
    private static HashMap<String,ClientConnectServerTread> clientThreadHashMap = new HashMap<>();

    /**
     * 该方法的调用来源：UserClientService确认用户登入成功后，将会开启该用户端的线程，
     * 然后调用该方法将开启的线程传入该方法用于添加进HashMao集合中方便管理
     *
     * 该方法的作用：将某个线程加入到集合中
     * @param userID  该属性将会在添加进HashMap时当作key使用（也就是说，HashMap的key是用户ID）
     * @param ccsThread  该属性将会在添加进HashMap时当作value使用（也就是说HashMap的value是该线程）
     */
    public static void addClientConnectServerServerThread(String userID , ClientConnectServerTread ccsThread){
        clientThreadHashMap.put(userID,ccsThread);//添加线程进入HashMap集合中
    }

    /**
     * 该方法的作用：通过一个用户userID获取属于该用户的线程
     * @param userID  通过用户ID找到对应的线程
     * @return 为调用该方法的外部返回一个线程
     */
    public static ClientConnectServerTread getClientConnectServerThread(String userID){
        return clientThreadHashMap.get(userID);
    }
}
