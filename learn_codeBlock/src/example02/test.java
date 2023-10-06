package example02;

public class test {

    static {
        System.out.println("test类静态代码块被调用");
    }
    {
        System.out.println("test类普通代码块被调用");
    }
    /*
        static静态代码块：
        1.作用就是对类进行初始化，而且它随着类的加载而执行，并且只会执行一次
        2.如果是普通代码块，每创建一个对象就会执行一次
        3.创建子类实例时，父类也会被加载（创建子类实例对象时，会先调用子类的代码块再调用父类的代码块）
        4.类什么时候被加载？ 当我们new 类的时候就是加载了
        5.即使没有创建该类的对象，在调用该类的静态属性或方法时，也会执行静态代码块
        6.创建子类实例对象时，会先调用子类的代码块再调用父类的代码块，（但是如果父类有静态代码块会先被执行）
        7.如果调用属性时，会先调用父类的代码块（无论静态或否），因为寻找属性时会从父类开始找（有继承关系加载子类必定会先加载父类）
        8.而且如果只是调用静态属性或方法且没有创建实例对象时，是不会加载普通代码块的

     */

}

class test2 extends test{

    static{
        System.out.println("子类test2的静态代码块被调用...");
    }

}
class animal{
    static {
        System.out.println("Animal类的静态代码块被执行");
    }
}
class cat extends animal{

    public static int number = 999;//静态属性

    static {
        System.out.println("Cat类的静态代码块被执行...");
    }

    {
        System.out.println("Cat类的代码块被执行...");
    }

    public static void testMethod(){
        System.out.println("cat类的testMethod静态方法被调用");
    }

}

class main{
    public static void main(String[] args) {
        System.out.println("\ntest类的第一个对象:");
        test2 c = new test2();//创建子类实例对象时，会先调用子类的代码块再调用父类的代码块，（但是如果父类有静态代码块会先被执行）


        System.out.println("\ntest类的第二个对象:");
        test a = new test();//当静态代码块被执行过了之后创建的第二个实例对象便不会再执行了，除非是普通代码块

        System.out.println("\ntest类的第三个对象:");
        test b = new test();

        System.out.println("\n调用cat类的静态属性:");
        System.out.println(cat.number);//即使没有创建cat类的对象，在调用cat类的静态属性或方法时，也会执行静态代码块
                                       //如果调用属性时，会先调用父类的代码块（无论静态或否），因为寻找属性时会从父类开始找（有继承关系加载子类必定会先加载父类）
                                       //而且如果只是调用静态属性或方法且没有创建实例对象时，是不会加载普通代码块的
    }
}
