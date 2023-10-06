package example10_exercise;
/*
练习题：
主线程执行5次后再让子线程执行10次，然后回到主线程继续执行
 */
public class example10 {
    public static void main(String[] args) throws InterruptedException {


        int count=0;
        while(true){

            System.out.println("hi..."+(++count));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5){
                System.out.println("让给子线程执行");
                test t1 = new test();
                Thread o1 = new Thread(t1);
                o1.start();
                o1.join();
                System.out.println("子线程执行完毕！回到main线程");
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
        int count=0;
        while(true){

            System.out.println("hello..."+count++);

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
