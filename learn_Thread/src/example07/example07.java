package example07;
/*
通知线程退出：
1.当线程完成任务后，会自动退出
2.还可以通过使用 变量 来控制run方法退出的方式停止线程，即 通知方式

 */
public class example07 {
    public static void main(String[] args) throws InterruptedException {

        test t1 = new test();
        Thread thread = new Thread(t1);
        thread.start();

        //目前的线程是无限循环且没有设置终止条件
        //然后由我们main方法控制该线程的关闭

        //先让main主线程休眠十秒，然后再通知t1的线程关闭
        Thread.sleep(1000 * 5); //睡眠10秒：1000毫秒=1秒 乘 10
        System.out.println("主线程睡醒啦，准备关闭t1类的线程");
        t1.setLoop(false);


    }
}

class test implements Runnable{
    int count = 0;
    private boolean loop = true;//默认为true
    @Override
    public void run() {
        while(loop) {
            System.out.println("线程:" + Thread.currentThread().getName() + "正在运行第"+(++count)+"次..." );
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
