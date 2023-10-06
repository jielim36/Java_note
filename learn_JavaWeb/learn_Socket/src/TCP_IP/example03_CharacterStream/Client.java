package TCP_IP.example03_CharacterStream;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
使用字符流：
1.编写一个服务端和一个客户端
2.服务端在9999端口监听
3.客户端连接到服务端，发送"hello,server"，并且接收服务端回复的”hello,client“，再退出
4.服务端接收客户端发送的信息，接收并输出，并且回复”hello.client“再退出

 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost() , 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("Hello, server!!!");
        bw.newLine();//换行,表示回复内容结束
        bw.flush();//刷新，代表正式写入

        socket.shutdownOutput();//停止output

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf8"));

        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }


        socket.close();
        outputStream.close();
        bw.close();
        br.close();

    }
}
