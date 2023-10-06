package UDP.example02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
题目：
1.编写一个接收端和发送端
2.接收端在9999端口等待接收数据
3.发送端向接收端发送数据“hello,明天吃火锅”
4.接收端收到数据后，回复“好的，明天见”再退出
5.发送端接收到后再退出
 */
public class Receiver {
    public static void main(String[] args) throws IOException {

        //1。创建DatagramSocket对象准备接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //2.创建一个DatagramPacket对象准备接收数据
        byte [] buf = new byte[1024];//数据报的最大大小限制在64KB内(64 * 1024)是最大容量
        DatagramPacket datagramPacket = new DatagramPacket(buf , buf.length);

        //3.准备接收，调用接收方法
        System.out.println("等待接收...");
        datagramSocket.receive(datagramPacket);//DatagramSocket对象调用receive方法传入dataPacket对象（接收到对方发送过来的数据会填充到packet对象）
                                               //当有数据包发送到本机的9999端口时，就会接收数据到Packet对象
                                                //如果没有数据报发送到本机的9999端口时，那么接收端这里就会阻塞/等待

        //4.拆包，需要对datagramPacket对象进行拆包，取出数据并显示
        int length = datagramPacket.getLength();//length属性就是实际接收到的数据长度（datagramPacket里的byte数组最大长度1024，但是接收的数据不一定有那么长，所以需要得到byte的数组的实际长度）
        byte [] data = datagramPacket.getData();//接收到的数据赋给data数组

        String s = new String(data, 0, length);//然后把data数组赋给s字符串变成内容
        System.out.println("Sender方的信息："+s);//输出内容


        //轮到Receiver回复信息给Sender
        byte[] bytes = "好啊好啊，明天见!".getBytes();
        datagramPacket = new DatagramPacket(bytes , bytes.length , InetAddress.getByName("jielim36") , 9998);
        datagramSocket.send(datagramPacket);



        //5.关闭资源
        datagramSocket.close();
        System.out.println("Receiver端退出...");
    }
}
