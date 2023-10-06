package example08_method;
/*
线程常用方法：
1.setName //设置线程的名称，使之于参数name相同
2.getName //返回该线程的名称
3.start //使该线程开始运行；Java虚拟机底层调用该线程的start0方法
4.run //调用线程对象run方法
5.setPriority  //更改线程的优先级
6.getPriority //获取线程的优先级
7.sleep  //再指定的毫秒数内让当前正在执行的线程休眠(暂停)
8.interrupt //中断线程（中断，并不是终止）

底层细节：
1.start 底层会创建新的线程，调用run，run就是一个简单的方法调用，不会启动新的线程
2.线程优先级的范围 (MAX_PRIORITY = 10 , MIN_PRIORITY=1 ; NORM_PRIORITY=5),源码：属性public final static int MIN_PRIORITY = 1;
3. interrupt 中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠的线程
4.sleep：线程的静态方法，使当前线程休眠
 */
public class example08 {
    public static void main(String[] args) throws InterruptedException {

        test t1 = new test();
        Thread o1 = new Thread(t1);
        o1.setPriority(Thread.MIN_PRIORITY);//设置优先级
        o1.start();

        for (int i = 0 ; i < 4 ; i++){
            Thread.sleep(500);
            System.out.println("主线程的for循环第"+i+"次...");
        }

        o1.interrupt(); //main方法的for循环结束后，就会中断o1的线程，所以原本线程正在休眠却被中断，然后继续执行


    }
}

class test implements Runnable{
    int sec = 0;

    @Override
    public void run() {

        while(true){
            System.out.println("线程执行了" + ++sec +"秒...");

            if (sec == 10){
                try {
                    System.out.println("线程已休眠..");
                    sec = 0;
                    Thread.sleep(5000);
                } catch (InterruptedException e) { //注意这里，如果捕获Interrupted异常，就会中断try的代码也就是中断睡眠然后执行某些步骤
                    System.out.println("线程已被interrupted");
                }
            }

        }
    }
}