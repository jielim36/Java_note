package softwareFrame;

import Server.service.softwareServer;

/**
 * 该类的作用：
 * 服务器端的总开关
 * 在main方法中调用了softwareServer
 * 然后softwareServer就会开始运行，持续监听9999端口等待客户端的连接
 *
 */
public class softwareFrame {
    public static void main(String[] args) {

        new softwareServer();//

    }
}
