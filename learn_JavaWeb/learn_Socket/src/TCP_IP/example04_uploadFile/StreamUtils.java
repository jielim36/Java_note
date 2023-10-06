package TCP_IP.example04_uploadFile;

import java.io.*;

public class StreamUtils {

    public static byte[] streamtoByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流
        byte [] b = new byte[1024];
        int len;

        while ((len = is.read(b)) != -1 ){
            bos.write(b , 0 , len);
        }
        byte[] array = bos.toByteArray(); //将bos读取出来的文件内容转成byte字节数组然后返回
        bos.close();
        return array;
    }

    public static String streamToString(InputStream is) throws Exception{
        //把socket.getInputStream字节流转成字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            builder.append(line + "\r\n");
        }
        reader.close();
        return builder.toString();
    }
}
