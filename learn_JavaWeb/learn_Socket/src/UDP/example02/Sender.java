package UDP.example02;

import java.io.IOException;
import java.net.*;

public class Sender {
    public static void main(String[] args) throws IOException {

        //创建DatagramSocket对象准备发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);//双方的端口建议是不一样的，因为该datagramSocket对象的端口其实是为了接收，和发送去哪个端无关(发送到哪个端口是在Packet对象决定的)
                                                                     //其实双方一样端口也可以，但是目前我们的双方都在同一个主机上，双方的端口会重叠，如果是两台主机，他们各自有各自的9999端口，某方的9999端口不会影响另一方的9999端口

        //创建DatagramPacket,将需要发送的数据封装到该对象
        byte[] bytes = "hello, 明天要吃火锅吗?".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes , bytes.length , InetAddress.getByName("jielim36") , 9999 );//参数1：发送的数据byte数组 ， 参数2：数据的长度  ， 参数3：发送的目的地的IP地址 ， 参数4：发送的目的地的端口

        //通过socket发送packet数据
        datagramSocket.send(datagramPacket);

        //轮到Sender接收Receiver回复的信息
        byte [] buf = new byte[1024];
        datagramPacket = new DatagramPacket(buf,buf.length);//先给packet创建好数组准备接收数据

        System.out.println("等待回复...");
        datagramSocket.receive(datagramPacket);//等待数据的接收

        byte [] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        String s = new String(data, 0, length);
        System.out.println("Receiver方的回复："+s);


        //关闭资源
        datagramSocket.close();
        System.out.println("Sender关闭...");

    }
}
