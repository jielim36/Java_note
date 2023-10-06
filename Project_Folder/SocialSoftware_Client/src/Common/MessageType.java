package Common;

/**
 * 该类用于对消息的类型进行分类
 */
public interface MessageType {
    /*
    1.在接口中定义一些常量(接口的属性默认public static final)
    2.不同的常量值表示不同的消息类型
     */
    String MESSAGE_LOGIN_SUCCESS = "1"; //表示登录成功
    String MESSAGE_LOGIN_FAIL = "2"; //表示登录失败
    String MESSAGE_COMM_MES = "3"; //普通的信息包（发文字消息）
    String MESSAGE_GET_ONLINE_FRIEND = "4";//显示在线用户列表
    String MESSAGE_RETURN_ONLINE_FRIEND = "4";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出

    String MESSAGE_GROUP_MES = "7";//群聊消息类型
    String MESSAGE_FILE_MES = "8";//文件类型
    String MESSAGE_NEWS_MES = "9";//服务器推送新闻
    String MESSAGE_OFFLINE_MES = "10";



}
