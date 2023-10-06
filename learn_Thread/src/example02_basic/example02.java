package example02_basic;

public class example02 {
    public static void main(String[] args) {
        //1.编写一个程序，线程每一秒都输出一次“喵喵”
        Cat cat = new Cat();
        cat.start();//注意：这个不是我们自己写的方法 ，作用：启动线程，当调用start方法时会调用run方法
//      cat.run(); 如果在main方法这样调用run方法的话，其实并不是真正的启动一个线程，它会先执行完run方法才会继续执行下面的代码，也就不能够同时执行，而且直接调用run方法，那么run方法就是一个普通的方法而已，输出的线程名也是name而不是Thread-0
        for (int i = 1; i < 60; i++) { //主线程

            System.out.println("主线程执行中..."+i +   ", 线程名字：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        可以在下面的Terminal中输入jconsole进入一个监视器观看具体线程
        注意：如果main方法的线程结束了，cat还没运行完毕时，程序还是会照常运行，直到所有线程结束
         */

    }
}
/*
1.当继承了一个Thread类，该类就可以当作线程使用
2.我们会重写run方法，写上自己的业务代码
3.run Thread类实现了Runnable接口的run方法
 */
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
