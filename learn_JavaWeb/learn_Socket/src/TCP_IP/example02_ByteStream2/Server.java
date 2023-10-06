package TCP_IP.example02_ByteStream2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功!");

        InputStream inputStream = socket.getInputStream();

        byte [] buf = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf , 0 , readLen));
        }

        //读取Client传输的数据后，再回复Client

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hiii, my name is hoho , Im come from Server example02".getBytes());

        //传送数据完毕后使用shutdownOutput表示说完话了
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
