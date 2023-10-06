package example09_FileWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter常用方法：
1.new FileWriter(File/String):覆盖模式，相当于流的指针在首端
2.new FileWriter(File/String类型 , true) 有true代表追加模式，相当于流的指针在尾端（重复执行会把内容叠加，没有true的相当于覆盖原本的内容）
3.write(int):写入单个字符
4.write(char[])：写入指定数组
5.write(char[],off,len)：写入指定数组并且指定截取数组的范围
6.write(String) 写入整个字符串
7.write(String , off ,len) 写入字符串并且指定字符串的截取范围

相关API
FileWriter使用后，必须要关闭(close方法)或者刷新(flush方法)，否则写入不到指定文件


 */
public class example09 {
    public static void main(String[] args) {

    }
    @Test
    public void Filewriter01() {
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\writerSomething.txt";
        //创建对象
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            //write(int) 写入单个字符
            fileWriter.write('H');
            //write（char[] ）
            char [] data = {'a','d','b'};
            fileWriter.write(data);
            fileWriter.write(data,0,2);//指定范围

            //write(String)
            String str = "----jdsflkajldf";
            fileWriter.write(str);
            fileWriter.write(str,0,3);//指定范围

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //对于FileWriter必须要关闭close 或者 刷新flush 才能真正的把数据写入到文件
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
