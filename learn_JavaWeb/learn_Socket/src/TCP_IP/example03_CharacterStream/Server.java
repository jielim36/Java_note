package TCP_IP.example03_CharacterStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("等待连接...");
        Socket Socketaccept = serverSocket.accept();

        InputStream inputStream = Socketaccept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf8"));

        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }

        OutputStream outputStream = Socketaccept.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("Hello, Client <3 !!!");
        bw.newLine();//换行，表示回复内容结束
        bw.flush();//刷新，代表正式写入

        Socketaccept.shutdownOutput();//停止output

        br.close();
        serverSocket.close();
        Socketaccept.close();

    }
}