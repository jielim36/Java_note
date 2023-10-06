package example03_SourceCode_start;

public class example02 {
    public static void main(String[] args) {
        //1.编写一个程序，线程每一秒都输出一次“喵喵”
        Cat cat = new Cat();
        cat.start();
        /*
        关于start方法的源码：

        1。start方法
        public void start() {
            synchronized (this) {
                // zero status corresponds to state "NEW".
                if (holder.threadStatus != 0)
                    throw new IllegalThreadStateException();
                start0(); //该方法非常重要
            }
        }

        2. start0方法，该方法是真正实现了多线程的效果，是start0而不是run方法

        3.注意：如果要真正的了解多线程，必须了解操作系统
        private native void start0();  //native修饰的一个方法,也就是本地方法，这个方式是由JVM调用的，底层是c/c++实现的
         */



        for (int i = 1; i < 60; i++) { //主线程
            System.out.println("主线程执行中..."+i +   ", 线程名字：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Cat extends Thread{
    int times=0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑
        while(true) { //死循环
            System.out.println("喵喵..." + ++times + "  cat类的线程名：" + Thread.currentThread().getName());//线程名：Thread-0
            try {
                Thread.sleep(1000); //单位：毫秒，1000毫秒等于1秒
            } catch (InterruptedException e) { //这里try-catch是保证该线程在sleep时还是能感知响应，能够响应中断，不会”睡死“
                e.printStackTrace();
            }
            if (times == 80){ //
                break;
            }
        }
    }
}
