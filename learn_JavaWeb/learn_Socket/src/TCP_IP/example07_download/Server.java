package TCP_IP.example07_download;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        //1. 监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);

        //2.等待客户端连接
        System.out.println("等待连接");
        Socket accept = serverSocket.accept();

        //3.读取 客户端发送的下载的文件名
        InputStream inputStream = accept.getInputStream();

        //4.把读取的数据进行处理
        byte [] b = new byte[1024];
        int len;
        String downloadFileName = null;
        while ((len = inputStream.read(b)) != -1){
            downloadFileName = new String(b, 0, len);
        }
        System.out.println("接收到客户端的文件名:" + downloadFileName);


        //如果客户端想要下载的音乐是music2 , 我们就返回给他这个，如果不是的话返回Kill_sound.wav
        String resFileName;
        if ("music2".equals(downloadFileName)){
            resFileName = "src\\music2.wav";
        }else{
            resFileName = "src\\Kill_sound.wav";
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));

        //使用工具类读取文件到一个byte数组
        byte [] data = StreamUtils.streamToByteArray(bufferedInputStream);

        //得到Socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(accept.getOutputStream());

        //写入到数据通道
        bos.write(data);
        accept.shutdownOutput();

        inputStream.close();
        bufferedInputStream.close();
        bos.close();
        serverSocket.close();
        accept.close();
        System.out.println("服务端退出");
    }
}
