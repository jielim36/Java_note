package example13_BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class example13 {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\bw.txt";//没有这个文件的话会自动创建
        //创建BufferWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));//有true = 追加模式

        bufferedWriter.write("hello,world");
        bufferedWriter.newLine();//插入一个和系统相关的换行符
        bufferedWriter.write("hello2,world");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3,world");

        bufferedWriter.close();//只需关闭bufferedWriter

    }




}
