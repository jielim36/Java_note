package example13;
/*
自定义异常：
基本概念：
当程序中出现了某些”错误“，但是该错误并没有在Throwable子类中描述处理，这个时候可以自己设计异常类，用于描述该错误信息

创建自定义异常类的步骤：
1.定义类：自定义异常类名（自己写）继承Exception或RuntimeException
2.如果继承Exception，属于编译异常
3.如果继承RuntimeException，属于运行时异常（一般都是继承RuntimeException）
 */
public class example13 {
    public static void main(String[] args) {
        int age = 80;
    }

}


