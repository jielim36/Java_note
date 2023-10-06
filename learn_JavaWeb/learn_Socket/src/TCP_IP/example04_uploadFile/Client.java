package TCP_IP.example04_uploadFile;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost() , 9999);
        String filePath = "src\\win.png";

//        OutputStream outputStream = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

//        byte [] buf = new byte[1024];
//        int readLen;
//        while ((readLen = bis.read(buf)) != -1 ){
//            outputStream.write(buf);
//        }
        //上面的代码直接省略成这个
        byte [] buf =StreamUtils.streamtoByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(buf);//将文件对应的字节数组写入数据通道
        bos.flush();

        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf8"));
//        String str;
//        while ((str = br.readLine()) != null){
//            System.out.println(str);
//        }
        String data = StreamUtils.streamToString(inputStream);
        System.out.println(data);

        socket.close();
        bis.close();
        bos.close();
    }
}
