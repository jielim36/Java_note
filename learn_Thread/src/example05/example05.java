package example05;
//多个子线程案例
public class example05 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread o1 = new Thread(t1);
        Thread o2 = new Thread(t2);
        o1.start();
        o2.start();

        ///如果用jconsole监视线程时，会发现有时候有其他的线程在但是main线程不在，
        // 那是因为main方法如果做完它的任务后它可以先“下岗”，剩下这两个线程在干活


    }
}

class T1 implements Runnable{

    @Override
    public void run() {
        int count=0;
        while(true) {
            count++;
            System.out.println("hi... 线程名称：" + Thread.currentThread().getName() + "   count="+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 50 ){
                break;
            }
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        int count=0;
        while(true) {
            count++;
            System.out.println("bye... 线程名称：" + Thread.currentThread().getName() + "  count:"+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 30 ){
                break;
            }
        }
    }
}
