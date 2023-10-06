package example15;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/*
练习题：
1.在main方法中启动两个线程
2.第一个线程循环随机打印100以内的整数
3.直到第二个线程从键盘读取了Q命令
 */
public class example15 {
    public static void main(String[] args) {

       A a = new A();
       B b = new B(a); //B构造器接收main方法创建的a对象，之后可以用于控制a对象的setLoop（通知方式）用于关闭a类的循环
       Thread t1 = new Thread(a);
       Thread t2 = new Thread(b);
//       t1.setDaemon(true); 用守护线程也可以，但是现在试试第二种方式，用通知方式
       t1.start();
       t2.start();


    }
}

class A implements Runnable{
    private boolean loop = true;

//    public static void setLoop(boolean loop) {
//        A.loop = loop;
//    }


    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){

            int random = (int)(Math.random() * (100+1));
            System.out.println(random);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
class B implements Runnable {
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        while(true){
                char option = input.next().charAt(0);
                if (option == 'Q') {
                    a.setLoop(false);
                    System.out.println("B线程停止");
                    break;
                }
        }
    }


}