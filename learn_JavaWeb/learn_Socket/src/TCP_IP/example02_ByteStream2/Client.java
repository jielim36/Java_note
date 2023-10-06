package TCP_IP.example02_ByteStream2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
目的：
客户端和服务器端都能互相传输数据
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost() , 9999);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("Hello, my name is lala , Im come from Client example02 !!".getBytes());
        //传送完毕后设置一个结束标记表示说完话了，这样的话之后的代码可以继续正常运行
        socket.shutdownOutput();

        //传给服务器端数据后，也要获取服务器端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        byte [] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf , 0 ,readLen));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
