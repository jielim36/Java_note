package TCP_IP.example01_ByteStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_class {
    public static void main(String[] args) throws IOException {
        //在本机的9999端口监听，等待连接(注意：在本机中没有其他服务在监听/占用9999)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端在9999端口监听，等待连接...");

        //如果有客户端连接9999端口时，程序会返回一个对象（如果没有客户端连接时，会阻塞在这里）
        Socket socket = serverSocket.accept();
        //当有客户端连接时才会继续执行下面的代码...(类似于Scanner，需要等我们输入数据后才会继续执行，一样的道理)

        System.out.println("Socket : " + socket.getClass());

        //通过socket.getInputStream()接收数据
        InputStream inputStream = socket.getInputStream();

        //读取客户端传过来的数据
        byte [] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1 ){
            System.out.println(new String(buf , 0 ,readLen));
        }

        //5.关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
