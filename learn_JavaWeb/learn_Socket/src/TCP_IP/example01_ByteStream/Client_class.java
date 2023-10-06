package TCP_IP.example01_ByteStream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client_class {
    public static void main(String[] args) throws IOException {
        //1.连接服务端（连接本机的9999端口，如果连接成功，返回Socket对象）,需要提前允许着服务器端才允许这里的客户端，否则会报错
        Socket socket = new Socket( "192.168.0.119" , 9999); //这里的第一个参数是jielim36/192.168.100.28 , 如果你连接的是远程服务器端，需要写那个服务器的IP
        System.out.println("客户端Socket返回:" + socket.getClass());

        //2.连接上后，生成Socket，通过socket.getOutputStream()该输出流写入数据到数据通道
        OutputStream outputStream = socket.getOutputStream();

        //通过输出流，写入数据到数据通道
        outputStream.write("Hiii , my name is Lim Yee Jie".getBytes());

        //关闭流对象和socket,否则造成资源浪费
        outputStream.close();
        socket.close();
        System.out.println("写入完成，客户端退出...");



    }
}
