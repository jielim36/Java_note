package example06;
/*
变成模拟三个售票窗口售票同时出售”同一个票(static)“100张，分别使用继承Thread和实现Runnable接口的方式，并且分析有什么问题？



 */
public class example06 {
    public static void main(String[] args) {
        soldTicket t1 = new soldTicket();
        soldTicket t2 = new soldTicket();
        soldTicket t3 = new soldTicket();

        Thread o1 = new Thread(t1);
        Thread o2 = new Thread(t2);
        Thread o3 = new Thread(t3);

        o1.start();
        o2.start();
        o3.start();
        /*
        部分输出结果：
        已出售一张票...剩余5张票	线程名:Thread-1
已出售一张票...剩余5张票	线程名:Thread-0
已出售一张票...剩余5张票	线程名:Thread-2
已出售一张票...剩余3张票	线程名:Thread-0
已出售一张票...剩余4张票	线程名:Thread-1
已出售一张票...剩余4张票	线程名:Thread-2
已出售一张票...剩余2张票	线程名:Thread-1
已出售一张票...剩余2张票	线程名:Thread-2
已出售一张票...剩余2张票	线程名:Thread-0
已出售一张票...剩余0张票	线程名:Thread-2
已出售一张票...剩余1张票	线程名:Thread-1
已出售一张票...剩余1张票	线程名:Thread-0
票卖完了...
票卖完了...
票卖完了...

      问题：
        可以发现剩余的票完全乱了，同时三个线程在使用同一个属性时会有冲突。体现了线程安全的问题...
        之后会学到上锁

         */
    }
}

class soldTicket implements Runnable{
    static int numberTicket = 100;
    @Override
    public void run() {
        while (true) {
            if (numberTicket == 0){
                System.out.println("票卖完了...");
                break;
            }
            System.out.println("已出售一张票...剩余" + (--numberTicket) + "张票\t线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

