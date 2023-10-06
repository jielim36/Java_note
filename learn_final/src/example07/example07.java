package example07;

public class example07 {
    public static void main(String[] args) {
        System.out.println(A.number2);//如果是没有final的修饰直接调用static属性时static代码块也会被执行
        System.out.println(B.number);//number是final static 属性，当外部调用时不会让类加载
    }
}

class A{
//  final和static往往搭配使用，效率更高。因为不会导致类的加载，底层编译器组偶了优化处理
    public static int number2 = 200;
    static {
        System.out.println("A类静态代码块被执行");
    }
}

class B{
    //  final和static往往搭配使用，效率更高。因为不会导致类的加载，底层编译器组偶了优化处理
    public final static int number = 100;
    static {
        System.out.println("B类静态代码块被执行");
    }
}
