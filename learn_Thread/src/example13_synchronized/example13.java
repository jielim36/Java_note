package example13_synchronized;
/*
线程同步机制：synchronized

1.在多线程变成里，一些敏感数据不允许被多个线程同时访问，
  此时就使用同步访问技术，保证数据在任何同一时刻，最多由一个线程访问，以保证数据的完整性。
2.也可以理解成：线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，
  直到该线程完成操作，其他线程才能对该内存地址进行操作
 */

//提供案例：该案例是在example06中出现的练习题，该练习题体现了一个问题就是同时有多个线程在调用同一个run方法，
// 导致里面的属性出问题，比如买票时全部线程同时买一张票，剩下一张票时所有线程同时买剩下的一张票，甚至买到负数
//解决方案：对run方法使用synchronized修饰
//synchronized方法会有一把”互斥锁“，该锁是跟随对象的，每个线程都有几率抢到该锁，有锁的线程就可以进入该方法，退出synchronized方法时又会归还锁然后下一次循环又重新抢夺锁

/*
互斥锁说明：
1.Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
2.每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象
3.关键字synchronized 来于对象的互斥锁联系。当某个对象用synchronized修饰时，
  表明该对象在任一时刻只能由一个线程访问
4.同步的局限性：导致程序的执行效率降低
5.同步方法（非静态方法）的锁可以是this，也可以是其他对象（要求是同一个对象）
6.同步方法（静态的）的锁为当前类本身

注意事项与细节：
1.同步方法如果没有static修饰：默认锁的对象为this
2.如果方法使用static修饰，默认锁对象：当前类.class
3.实现的落地步骤：
-需要先分析上锁的代码
-选择同步代码块或同步方法
-要求多个线程的锁对象为同一个即可，比如这个案例的对象只有soldTicket类的t1对象，只是分成三个线程执行罢了（所以使用Runnable会优于继承Thread，因为Runnable比较自由 ）

4.使用同步代码块的效率会高一点，因为同步的代码的范围越小，效率就越高

5.可以在类中创建一个Object对象，然后代码块中用synchronized(Object对象)，那么全部线程也是在用着同一个对象
 */
public class example13 {
    public static void main(String[] args) {
        soldTicket t1 = new soldTicket();


        Thread o1 = new Thread(t1);
        Thread o2 = new Thread(t1);
        Thread o3 = new Thread(t1);

        o1.start();
        o2.start();
        o3.start();

    }
}

class soldTicket implements Runnable{
    static int numberTicket = 100;
    private boolean loop = true;
    Object object = new Object();//可以创建一个Object对象，然后在代码块的括号里放入该对象，也能“一个对象形成的多线程“用着同一个对象object
                                    //如果是”不同的对象形成的多线程“就使用static object对象

//静态方法的锁是加在soldTicket.class的
    public /*synchronized*/ static void method(){
        synchronized (soldTicket.class){ //如果要在静态方法放入synchronized代码块的话括号放类名.class

        }
    }
    //普通方法的锁是加在this上的
    public /*synchronized*/ void sold(){//synchronized同步方法，作用：同一个时刻只能有一个线程来执行run方法，这样numberTicket就不会出问题
        synchronized (this) { //也可以在代码块加入
            if (numberTicket <= 0) {
                System.out.println("票卖完了...");
                loop = false;
            }
            System.out.println("已出售一张票...剩余" + (--numberTicket) + "张票\t线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {  //一开始全部线程进入该方法
        while (loop) {
            
            sold(); //然后轮流进入这个synchronized方法，synchronized方法会有一把”锁“，该锁是跟随对象的，每个线程都有几率抢到该锁，有锁的线程就可以进入该方法

        }
    }
}
