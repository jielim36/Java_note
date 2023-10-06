package example03;


//抽象模板模式


public class example03 {
    //要求计算每个任务并且记录时间（不要在意里面的代码是否错误，只是做例子）
    //1+ ... + 10000
    //可以发现下面的两个方法其实除了+和*其他都没有任何变化，如果有许多重复性的工作，这种实现方式会很麻烦（代码复用性差）
    public static void main(String[] args) {
        job();
        System.out.println("\n\n");
        job2();
    }
    public static void job(){

        long start = System.currentTimeMillis();

        int num = 0;
        for (int i = 1 ; i <= 1000000; i++) {
            num += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间 ： " + (end - start) + "\nnum : "+num);
    }

    public static void job2(){

        long start = System.currentTimeMillis();

        int num = 1;
        for (int i = 1 ; i <= 100000; i++) {
            num *= i;
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间 ： " + (end - start) + "\nnum : "+num);
    }

}
