package example04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
编译异常：
编译时异常指在编译期间就必须处理的异常，否则代码不能通过编译。

常见的编译异常：
1.SQLException 操作数据库时，查询表可能发生异常
2.IQEException 操作文件时，发生的异常
3.FileNotFoundException 当操作一个不存在的文件时，发生异常
4.ClassNotFoundException 加载类，而该类不存在时发生异常
5.EOFException 操作文件，到文件末尾，发生异常
6.IllegalArgumentException 参数异常

由于有许多案例目前还没学（比如数据库），所以无法给予例子
 */
public class example04 {
    public static void main(String[] args) {
//        FileInputStream fis;
//        fis = new FileInputStream("dlfa");
        //编译器直接红标表示报错：Unhandled exception: java.io.FileNotFoundException

        //这时候使用try-catch就不会报错
        try {
            FileInputStream fis;
            fis = new FileInputStream("dlfa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
