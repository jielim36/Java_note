package UDP.example03_exercise01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
编写一个接收端和发送端，使用UDP
1.接收端在8888端口等待接收数据
2.发送端向接收端发送数据”四大名著有哪些“
4.接收端接收到发送端发送的问题后，返回"四大名著有 红楼梦 ..."
5.否则返回what？
5.双方退出
 */
public class Receiver {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte [] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf , buf.length);

        System.out.println("等待接收...");
        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte [] data = datagramPacket.getData();
        String s = new String(data, 0, length);

        if (s.equals("四大名著有哪些")){
            byte [] msg = "1.红楼梦\n2.xxx\n3.xxxx\n4.xxxxx".getBytes();
            datagramPacket = new DatagramPacket(msg , msg.length , InetAddress.getByName("jielim36") , 9999);
            datagramSocket.send(datagramPacket);
        }else {
            byte [] msg = "what?".getBytes();
            datagramPacket = new DatagramPacket(msg , msg.length , InetAddress.getByName("jielim36") , 9999);
            datagramSocket.send(datagramPacket);

        }

        datagramSocket.close();

    }
}
