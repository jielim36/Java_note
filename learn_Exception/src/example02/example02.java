package example02;
/*
Exception异常的基本概念：
Java语言中，将程序”执行中“发生的不正常情况称为“异常”，（开发过程中的语法错误和逻辑错误不是异常（类似直接红色字的bug））

执行过程中所发生的异常时间可分为两大类
1. Error : Java虚拟机无法解决的严重问题。如：JVM系统内部错误，资源耗尽等严重情况。
   比如：StackOverflowError[栈溢出]和OOM(out of memory), Error是严重错误，程序会崩溃。

2.Exception:其它因变成错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。
  比如空指针访问，试图读取不存在的文件，网络连接中断等等。
  Exception分为两大类：运行时异常（程序运行时，发生的异常）和编译时异常（编程时，编译器检查出的的异常）


  异常体系图：example02里的Exception_Diagram.jpg 或者 java文件中的Exception_Diagram.jpg

  异常体系图解析：
  1.异常体系图里的除了Serializable以外的所有格子都是class（类）
  2.Throwable类似于所有异常的根类
  3.Serializable是一个接口，Throwable类实现了该接口，并且也继承了Object类
  4.该体系图并不是包含所有的异常，而是一些常见的
  4.RunTimeException类就是我们平时运行时遇到的异常（比如：NullPointerException类（空指针异常），ArrayIndexOutOfBoundException类（数组超出范围/越界））



  小结：
  1.异常分为两大类，运行时异常和编译时异常
  2.运行时异常，编译器不会强制处置的异常。一般是指变成时的逻辑错误，是程序员应该避免其出现的异常。
    java.lang.RuntimeException类和它的子类都是运行时异常
  3.对于运行时异常，可以不做处理，因为这类异常很普遍，若处理可能会导致程序的可读性和运行效率产生影响
  4.编译时异常，是编译器要求必须处理的异常

  运行时异常的例子：
  int n1 = 10;
  int n2 = 0;
  int result = n1/n2;
  出现算术异常ArithmeticException,因为数学里不能除于0;

  另外example03有常见的五种运行时异常例子

  编译时异常的例子：
  example02的main方法有例子
  example04有常见例子
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class example02 {
    public static void main(String[] args) {
//        FileInputStream fis;
//        fis = new FileInputStream("dlfa");
        //编译器直接红标表示报错：Unhandled exception: java.io.FileNotFoundException

        //这时候使用try-catch就不会报错
        try {
            FileInputStream fis;
            fis = new FileInputStream("dlfa");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
