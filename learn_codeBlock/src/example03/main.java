package example03;

public class main {
    public static void main(String[] args) {
        System.out.println("A类对象：");
        A a = new A();
        System.out.println("\n\nB类对象：");
        B b = new B();
        System.out.println("\n\nC类对象：");
        C c = new C();

    }
}

class A{

    private static int number = getNumber();//静态属性（写在静态代码块之前，所以静态属性先加载）

    static{
        System.out.println("static代码块被执行...");//静态代码块，（写在静态属性后面，所以代码块会在静态属性执行后才会执行）
    }

    public static int getNumber() {
        System.out.println("getNumber Method被执行...");
        return number;
    }

    /*
    上面的代码执行顺序为：
    1)先加载静态属性然后调用getNumber方法并且输出语句和返回值给静态属性
    2）加载静态代码块并输出语句


    关于静态代码块和静态属性：
    1.静态代码块和静态属性的加载优先级一样，想要决定谁先加载就把它放到代码的最前面（最上面）
    2.如果先写静态代码块就先执行静态代码块

     */

}

class B{

    {
        System.out.println("B类的第一个普通代码块被执行");
    }
    private int number2 = getNumber2();//普通属性/非静态属性

    {
        System.out.println("B类的第二个普通代码块被执行");
    }
    static {
        System.out.println("B类静态代码块被执行");
    }

    public int getNumber2() {//普通方法
        System.out.println("B类的getNumber2普通方法被执行");
        return number2;
    }
/*
总结：
1. 创建实例对象时静态代码块和普通代码块都会执行
2. 先执行静态属性和代码块再执行普通属性和代码块
3. 普通属性和普通代码块的优先级一样，也是看谁先写就谁先执行
 */

}

class C{
    private String name = getName();

    {
        System.out.println("C类普通代码块被调用");
    }
    public C() {
        System.out.println("C类构造器被调用");
    }

    public String getName() {
        System.out.println("C类getName被调用");
        return name;
    }

    static {
        System.out.println("C类静态代码块被调用");
    }
    /*
    总结：
    加载静态，普通，构造器的顺序是:
    1. 优先加载静态属性和静态代码块（两者优先级一样，谁先写就谁先执行）
    2. 普通静态属性和普通代码块（两者优先级一样，谁先写就谁先执行）
    3. 最后才执行构造器
     */
}