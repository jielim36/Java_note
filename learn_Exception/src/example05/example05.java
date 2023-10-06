package example05;
/*
异常处理机制：
基本介绍：异常处理机制就是当异常发生时，对异常处理的方式。
异常处理的方式有两种，通常遇到一个异常代码时，对异常处理的方式是二选一，而不是两种方式都同时使用。

异常处理的方式：
1. try-catch-finally（不一定要有finally）
-程序员在代码中捕获发生的异常，自行处理

2.throws
-将发生的异常输出，交给调用者（方法）来处理，最顶级的处理者是JVM
-程序的顺序,例子：
 JVM调用main方法，main方法调用f1方法，f1方法调用f2方法( JVM -> main -> f1 -> f2)
 这时f2有捕获到异常，它选择的处理方式是throws，这时异常会传递给f1方法，然后f1才选择使用什么处理方式，
 t-c-f的话就当场处理，throws的话又传给main方法。如果main方法到最后传给了JVM（顶级处理者），
 JVM就会1.处理异常,2.输出异常信息,3.退出程序

换句话说，其实如果我们平时没有使用try-catch的话，是默认使用throws的
（当我们没有try-catch的时候，如果有异常就会一直回到JVM然后由JVM帮我们处理并且输出异常信息然后结束程序）


try-catch-finally语法：（不一定要有finally）

try{
 有可能发生异常的代码
}catch(Exception e){ //当异常发生时，系统将异常封装成Exception对象e，然后传递给catch的参数
 1.捕获到的异常
 2.得到异常对象后，程序员可以自己处理
 3.如果没有异常，catch这里不会执行

}finally{
  //不管try代码块是否有异常发生，始终要执行finally
  //所以通常将释放资源的代码放在finally
}

throws语法:
try{

}catch(Exception e){

}
 */
public class example05 {
    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 0;
        int result = n1/n2;



    }
}
