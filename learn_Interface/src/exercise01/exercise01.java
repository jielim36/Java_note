package exercise01;

public class exercise01 {
    public static void main(String[] args) {
        B b = new B();
        //全部都能输出
        System.out.println(b.a);
        System.out.println(B.a);
        System.out.println(A.a);
    }
}

interface A{
    int a = 23;//public static final int a = 23;
}

class B implements A{

}