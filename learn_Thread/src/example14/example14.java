package example14;
/*
线程的死锁：

比如A线程占用了B线程的锁资源，B线程也占用了A线程的锁资源。
而且A线程必须要拿到那个资源交给B才能继续执行，B也一样。
此时双方就会卡着，形成了“死锁”。

案例：
妈妈：你先完成作业才玩手机
儿子：你先让我玩手机我才做作业


 */

/*
释放锁

释放锁的情况
1.当前线程的同步方法，同步代码块执行结束
2.当前线程在同步代码块，同步方法中遇到break，return
3.当前线程在同步代码块，同步方法中出现了未处理的Error或Exception，道义异常结束
4.但钱线程在同步代码块，同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁。

不会释放锁的情况
1.线程执行同步代码块或方法时，程序调用了Tread.sleep()，Thread.yield方法暂停当前线程的执行，不会释放锁（占着茅坑不拉屎）
2.线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁（提示：尽量避免使用suspend和resume来控制线程，方法不再推荐使用）

 */
public class example14 {
    public static void main(String[] args) {
        test A = new test(true);
        test B = new test(false);
        Thread t1 = new Thread(A);
        Thread t2 = new Thread(B);
        t1.setName("A线程");
        t2.setName("B线程");
        t1.start();
        t2.start();
        /*
        注意：并不是100%会发生死锁
        输出结果：
        Thread-0进入1
        Thread-1进入3

        可以发现两个线程确实都被卡住了。
         */

    }
}

class test implements Runnable{
    static Object o1 = new Object();//让全部不同对象的线程用同一个object对象，就能完成线程安全（同步）
    static Object o2 = new Object();
    boolean flag;
    public test(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        /*
        分析：
        1.如果flag为True，线程A就会先得到o1的锁，尝试去获取o2对象的锁
        2.如果线程A得到了o1对象的锁进入却得不到o2对象的锁，就会Blocked（状态）
        3.此时线程B进入了else语句：如果flag为false，线程B就会先得到o2的对象锁，然后尝试去获取o1对象的锁
        4.如果线程B得不到o1对象的锁，就会Blocked（状态）

        结果：
        1.此时线程A卡在if语句的得到了o1进入后卡住了，得不到o2，因为在else语句里被线程B先拿到了
        2.但是线程B虽然拿到了o2对象的锁，却也卡住了，因为它得不到o1对象的锁，o1已经被线程A抢走了
        3.这种情况形成了死锁
         */
        if (flag){
            synchronized (o1){ //对象互斥锁
                System.out.println(Thread.currentThread().getName() + "进入1");//线程A可能会输出这句后就卡住
                synchronized (o2){//进不去
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }else {
            synchronized (o2){//线程B进入了
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1){//进不去，因为线程A已经先得到了o1对象的锁
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }

        }

    }
}