package TCP_IP.example06_exercise01;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("等待连接...");
        Socket accept = serverSocket.accept();


        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String data = br.readLine();
        BufferedWriter bw = bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

            if (data.equals("name")){
                bw.write("My name is Lim Yee Jie");
            }else if (data.equals("hobby")){

                bw.write("My hobby is coding");
            }else {
                bw.write("你说啥呢?");
            }

        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        serverSocket.close();
        accept.close();


    }
}
