package example21_PrintStream_and_PrintWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
PrintStream和PrintWriter都是输出流

PrintStream介绍：
1. 它的直接父类是FilterOutputStream
2. 它是字节流
3. 它可以打印在显示器上，还可以打印在：OutputStream,String,File
4.

PrintWriter介绍：
1.它是字符流
2.它的父类是Writer
4. 打印的功能和PrintStream差不多
 */
public class example21 {
    public static void main(String[] args) throws IOException {
        PrintStream01();
        PrintWriter01();
    }

    public static void PrintStream01() throws IOException {
        PrintStream out_ = System.out;
        //在默认情况下，PrintStream输出数据的位置是标准输出（显示器）
        out_.print("john,hello");
        //因为print的底层使用的是write方法，所以我们可以直接调用write进行打印/输出
        out_.write("哈喽哈喽你好!".getBytes());
        out_.close();

        //我们可以去修改打印输出的位置
        //修改到文本中
        System.setOut(new PrintStream("C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\nihao.txt"));
        System.out.println("——————各位好，这里在测试更改打印位置");//上面修改了输出的位置，这里直接用最普通的sout输出就会在设置好的地方输出
    }

    public static void PrintWriter01() throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print("hi,你好啊~");

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\yy.txt"));
        pw.print("测试测试测试上车刷卡三零附近的路上风景");
        pw.close();

    }
}
