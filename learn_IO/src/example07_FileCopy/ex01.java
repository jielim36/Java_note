package example07_FileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex01 {
    public static void main(String[] args) {
        //完成文件拷贝，将C:\Users\jieli\Desktop\Java\learn_IO\TestingFile\a.txt 复制到 桌面
        /*
        思路分析：
        1. 创建文件的输入流，将文件读取到程序
        2.创建文件的输出流，将读取到的文件数据，写入到指定的文件。
         */
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\a.txt";
        String toFilePath = "C:\\Users\\jieli\\Desktop\\b.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(toFilePath);

            byte [] array = new byte[8];//如果要复制文件大小比较大的比如图片，数组的大小可以写成1024（1KB）之类的
            int readLen = 0;
            while ((readLen = fileInputStream.read(array)) != -1){
                fileOutputStream.write(array,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {//用比较广的IOException
            throw new RuntimeException(e);
        }finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
