package TCP_IP.example07_download;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {

    public static byte[] streamToByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] buf = new byte[1024];
        int length;

        while ((length = is.read(buf)) != -1){
            bos.write(buf,0,length);
        }

        byte [] array = bos.toByteArray();
        bos.close();
        return array;
    }

    public static String streamToString(InputStream is) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            sb.append(line + "\r\n");
        }
        br.close();
        return sb.toString();
    }

}
