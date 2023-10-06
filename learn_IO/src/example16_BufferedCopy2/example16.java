package example16_BufferedCopy2;

import java.io.*;

//用BufferedOutputStream和BufferedInputStream来做拷贝
//BufferedOutputStream和BufferedInputStream是用于处理二进制文件的，所以可以处理图片，视频，音频，文本都可以，只是不支持汉字
public class example16 {
    public static void main(String[] args) {

        String srcFilePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\win.png";//拷贝目标图片
        String destFilePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\winCopy.png";//拷贝图片到哪个目的地

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));

            byte [] data = new byte[1024];
            int readLen;
            while ((readLen = bufferedInputStream.read(data)) != -1){
                bufferedOutputStream.write(data,0,readLen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            try{
                if (bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            }catch (Exception e){
                throw new RuntimeException();
            }

        }


    }
}
