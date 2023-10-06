package TCP_IP.example04_uploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("等待连接...");
        Socket acceptSocket = serverSocket.accept();

        //接收图片
        BufferedInputStream bis = new BufferedInputStream(acceptSocket.getInputStream());
        byte [] data = StreamUtils.streamtoByteArray(bis);
        int readLen;

        String path = "src\\imageCopy.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(data);
        bos.flush();

        //检查目录下是否有该文件，有的话回复收到图片
        BufferedWriter bw;
        if (new File(path).exists()){

            bw = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
            bw.write("收到图片!");

        }else {
            bw = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
            bw.write("收到图片!");
        }

        bw.close();
        bos.close();
        bis.close();
        acceptSocket.close();
        serverSocket.close();

    }
}
