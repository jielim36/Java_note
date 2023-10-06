package TCP_IP.example07_download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("music2".getBytes());
        socket.shutdownOutput();


        //读取服务端返回的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String downloadFilePath = "src\\musicDownload.wav";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(downloadFilePath));
        bos.write(bytes);

        bos.close();
        bis.close();
        socket.close();
        outputStream.close();
    }
}
