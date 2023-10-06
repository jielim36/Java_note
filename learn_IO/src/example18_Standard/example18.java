package example18_Standard;

import java.util.Scanner;

/*
标准输入输出流             类型          默认设备
System.in  标准输入     InputStream     键盘
System.out 标准输出     PrintStream     显示器

1. .in 是System类中的一个属性： public final static InputStream in = null;
   它的编译类型是InputStream , 运行类型是BufferedInputStream

2. .out 是System类中的一个属性：public final static PrintStream out = null;
    编译类型是PrintStream , 运行类型是PrintStream


 */
public class example18 {
    public static void main(String[] args) {
        //.in 是System类中的一个属性： public final static InputStream in = null;
        //它的编译类型是InputStream , 运行类型是BufferedInputStream
        System.out.println("in 的运行类型："+System.in.getClass());//in运行类型：class java.io.BufferedInputStream

        System.out.println("out的运行类型："+System.out.getClass()); //out的运行类型:lass java.io.PrintStream


        System.out.println("xxx"); //这个是使用out对象将数据输出到显示器

        Scanner scanner = new Scanner(System.in);//这个是使用in对象将键盘输入的数据传输到程序
        System.out.print("输入内容：");
        String str = scanner.nextLine();
        System.out.println(str);


    }
}
