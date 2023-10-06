package UDP.example03_exercise01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] bytes = "四大名著有哪些".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes , bytes.length , InetAddress.getByName("jielim36"), 8888);
        datagramSocket.send(packet);


        //接收回复
        System.out.println("等待回复...");
        datagramSocket.receive(packet);

        byte [] data = packet.getData();
        int length = packet.getLength();
        String s = new String(data , 0 , length);
        System.out.println("接收端的回复：\n" + s);


        datagramSocket.close();


    }
}
