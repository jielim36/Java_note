package Lambda;

import org.junit.jupiter.api.Test;

/**
 函数式编程 Functional Programming

 概念：
 面向对象思想需要关注用什么对象完成什么事情。
 而函数式编程思想就类似于我们数学中的函数，它主要关注的是对数据进行了什么操作。

 优点：
 1.代码简洁（尤其可以让很多if else嵌套的代码进行优化简化）
 2.接近自然语言，可读性好，好理解
 3.易于 并发编程
 4.开发快速

 */

/**
 函数式接口 Functional Interface：
 说明：
 如果接口中只声明了一个抽象方法，此接口就被称为函数式接口。

 比如：Comparator,Runnable 接口，每个系统的Functional Interface都会有@FunctionalInterface的注解
 自己写的话当然就不会自动有注解，当然我们也可以自己添加注解。

 api中Functional Interface所在的包：在 java.util.function 下

 */


/**
 什么是Lambda表达式？
 概述：
 Lambda是JDK8中的一个语法糖。它可以对某些匿名内部类的写法进行简化。它是函数式编程的一个重要体现。
 让我们不在关注是什么对象，而是关注我们对数据进行什么操作

 基本格式：
 (参数列表)->{代码}

 特征：
 -> 符号：这个箭头符号被称为 Lambda操作符 / 箭头操作符
 -> 符号的左边：抽象方法的形参列表
 -> 符号的右边：实现抽象方法时的方法体内的代码

 使用前提：
 必须是接口，且接口内只有一个抽象方法

 Lambda的本质：
 1.lambda表达式其实就是实现接口的抽象方法的对象，和使用匿名内部类比起来lambda会更加简洁。
 2.lambda表达式是一个匿名函数。

 写Lambda表达式的思维：
 想象匿名内部类怎么写，写出来之后把实现的抽象方法的参数列表的方法内的代码复制下来转换成Lambda格式就完成了

 */
public class ex01_Introduction {

    @Test
    public void example01(){
        //传统方法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("爱情不是你想买，想买就能买");
//            }
//        }).start();

        //Lambda 表达式
        new Thread( ()->{System.out.println("Hi,my friend");} ).start();
        /*
        使用Lambda表达式的前提是：必须有接口，且改接口只有一个抽象方法
        这里省略了 new Runnable

        Runnable接口的全部源代码

        public interface Runnable {
        void run();
        }

        可以发现Runnable 是一个接口，且接口里只有一个run方法
         */


    }

}
