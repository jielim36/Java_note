package example12_thread_state;
//线程的七大状态
/*
1.NEW 尚未启动的线程处于此状态 （刚new出来）
2.RUNNABLE 可运行状态：在Java虚拟机中执行的线程处于此状态（比如调用了start方法后就会进入此状态）,Runnable状态里由细分两个状态，也就是第七大状态之一，官方文档说的是6个状态
    -Running
    -Ready(yield)

3.BLOCKED   被阻塞等待监视器锁定的线程处于此状态
4.WAITING   正在等待另一个线程执行特定动作的线程处于此状态(join,waita...)
5.TIMED_WAITING 正在等待另一个线程执行动作达到指定等待时间的线程处于此状态 （sleep,join,...）
6.TERMINATED    已退出的线程处于此状态
 */
public class example12 {
    public static void main(String[] args) throws InterruptedException {
        test o1 = new test();
        System.out.println("1.."+o1.getName() + "状态："+ o1.getState());
        o1.start();

        while (Thread.State.TERMINATED != o1.getState()){
            System.out.println("2.."+o1.getName() + "状态："+ o1.getState());
            Thread.sleep(500);
        }

        System.out.println("3.."+o1.getName() + "状态："+ o1.getState());

    }
}

class test extends Thread{

    @Override
    public void run() {
        int count = 0;
        for (;;){
            count++;
            System.out.println("线程正在运行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10){
                break;
            }
        }

    }
}
