package example04_Runnable_Interface;
/*
说明：
1.java是单继承的，在某些情况下一个类可能已经继承了某个父类，这时在用继承Thread类方法来创建线程显然不可能了。
2.java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程

如何使用：
1.一个Runnable的实现类
2.在main方法对该实现类实例化对象
3.在main方法使用Thread类实例化对象，然后构造器里放入实现类的实例化对象
3.然后用Thread类对象调用start方法

为什么要创建Thread类对象的原理：
1.Thread类采用了一种设计模式：代理模式
2.下面有模拟
 */
public class example04 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable{
    int count=0;
    @Override
    public void run() {
        while(true){
            System.out.println("汪汪..." + ++count +"\t 进程名称："+ Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count >50){
                break;
            }
        }
    }
}

class ThreadProxy implements Runnable{ //这里是简单模拟了一个Thread类中的设计模式：代理模式
    /*
    执行详情：
    1.首先，外部创建了该类的对象，在构造器中丢入一个Runnable类对象 -> ThreadProxy threadProxy = new ThreadProxy(Runnable对象);
    2.然后在main方法创建ThreadProxy的对象然后调用start方法 -> threadProxy.start();
    3.start方法里经过一系列处理就调用了真正最重要的start0方法
    4.start0方法里面就会真正的使用run方法（该run方法就是我们丢入的runnable对象重写的run方法,动态绑定机制）
     */
    private Runnable target = null;
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();
    }
    public void start0(){
        run();
    }

}
