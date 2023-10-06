package example11;
/*
1.用户线程：也叫工作线程，当线程的任务执行完毕或通知方式结束
2.守护线程 Daemon ：一般是为了工作线程服务的，当所有的用户线程结束，守护线程自动结束
3.常见的守护线程例子：垃圾回收机制
 */
public class example11 {
    public static void main(String[] args) {
        MyDaemon t1 = new MyDaemon();
        t1.setDaemon(true); //把MyDaemon类的t1对象设置成 守护线程
        t1.start(); //当其他线程结束后，该线程才会结束，因为被设置成守护线程

        int count = 0;
        for (;;){
            System.out.println("主线程正在运行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10){
                System.out.println("主线程执行完毕");
                break;
            }
            count++;
        }

    }
}

class MyDaemon extends Thread{

    @Override
    public void run() {
        for (;;){
            System.out.println("守护线程正在运行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
