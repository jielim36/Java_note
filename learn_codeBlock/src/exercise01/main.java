package exercise01;

public class main {
    public static void main(String[] args) {
        System.out.println("total = " + exercise01.total);
        System.out.println("total = " + exercise01.total);
        /*
        这里值得注意的是：
        -进入静态代码块时先输出了in static code block 才输出 total = 100
        -而不是先total=100 才 in static code block
         */
    }
}
class exercise01{

    public static int total;
    static{
        total = 100;
        System.out.println("in static code block!");
    }

}