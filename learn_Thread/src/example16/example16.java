package example16;
/*
练习题：
1.有两个用户分别从同一个卡上取钱（总额一万）
2.每次都取以前，当余额不足时就不能取款了
3.不能出现取钱取到超过的情况（余额负数）
 */
public class example16 {
    public static void main(String[] args) {

        Bank person1 = new Bank();
        Bank person2 = new Bank();
        Thread t1 = new Thread(person1);
        Thread t2 = new Thread(person2);

        t1.start();
        t2.start();
    }
}

class Bank implements Runnable{
    private static Object obj1 = new Object();
    private static double Balance = 10000;//余额
    private static boolean loop = true;//default
    @Override
    public void run() {
        while (loop){
                ATM();
        }

    }

    public synchronized void ATM(){
        synchronized (obj1) {
            if (Balance <= 0) {
                System.out.println("余额不足...剩余："+Balance);
                loop = false;
                return;
            }
            Balance -= 1000;
            System.out.println(Thread.currentThread().getName() + "取出了1000块，余额：" + Balance);

        }

        try { //如果把这个sleep放在互斥锁的外部,可以实现比较均匀轮流取钱
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
