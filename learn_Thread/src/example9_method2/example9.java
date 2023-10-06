package example9_method2;
/*
常用方法：
1.yield 让出：线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以不一定礼让成功
2.join：线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有任务

案例：
创建一个子线程，每个1s输出hello，输出20次，主线程每个一秒输出hi，输出20次。
要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续


 */
public class example9 {
    public static void main(String[] args) throws InterruptedException {

        test t1 = new test();
        Thread o1 = new Thread(t1);
        o1.start();


        int count= 1;
        while(true){
            System.out.println("hi...主线程执行了"+ (count++) + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (count == 5){
                System.out.println("主线程停止...让子线程先执行完毕!");
                o1.join();//让o1线程先执行完毕，才继续执行main线程
                System.out.println("子线程执行完毕! 主线程继续执行...");//只有子线程执行完毕后，才会执行这句
            }

            if (count == 10){
                break;
            }
        }



    }
}

class test implements Runnable{

    @Override
    public void run() {
        int count= 1;
        while(true){
            System.out.println("hello...子线程执行了"+ (count++) + "次");
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


