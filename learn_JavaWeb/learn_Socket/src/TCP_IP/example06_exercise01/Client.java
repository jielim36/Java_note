package TCP_IP.example06_exercise01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/*
题目：
1.使用字符流的方式，编写一个客户端成俗和服务端程序
-行为
2.客户端发送“name”，服务端接收到后，返回”我是nova“ ， nova是你自己的名字
3.客户端发送”hobby“,服务端接收到后，返回”编写java程序“
4.如果不是这两个问题，回复”你说啥呢“
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getByName("jielim36") , 9999);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//字符流
        bw.write("hdhaf");
        bw.newLine();
        bw.flush();

        //接收Server的回复
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        String str;
        while ((str = br.readLine()) != null){
            System.out.println("Server回复："+str);
        }

        //关闭
        bw.close();
        br.close();
        socket.close();


    }
}
