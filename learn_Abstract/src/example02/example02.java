package example02;

public class example02 {
/*
注意事项：
1.抽象类不能被实例化
2.类中包含抽象方法，那么这个类必须要修饰成抽象类
3.抽象类不一定需要包含abstract方法，也就是说，abstract类可以没有abstract方法，但是abstract方法一定要有abstract类
4.抽象修饰符只能用于修饰类和方法。其他所有都不支持。
5.抽象类可以有任意成员，几乎和普通的类没有太大差别。成员例子：非抽象方法，构造器，静态属性等等
6.如果一个子类继承了一个父类（抽象父类），则它必须实现父类中的所有抽象方法，除非它自己也声明为abstract类
7.抽象方法不能使用private，final和static进行修饰，因为这些关键字都是和重写相违背的。
 */
public static void main(String[] args) {
//    new A();报错，因为抽象类不能被实例化
}

}

abstract class A{
    //抽象类里可以写任意成员，几乎和普通的类无太大差别（说”几乎“是因为可能有我不知道的例子）
    private int age = 19;
    private static String name="dog";

    public A() {
        System.out.println("constructor");
    }

    public void say(){
        System.out.println("say something");
    }

    public static int n1(){
        return 10;
    }

    public abstract int n2();//抽象类
    public abstract void n3();//抽象类

//    private abstract void n3(); 抽象方法不能用private
//    public final abstract void n3(); 抽象方法不能final
//    public static abstract void n3(); 抽象方法不能static

}

class B extends A{ //当子类继承了抽象父类后，必须实现"所有"父类中的抽象类，除非子类也是抽象类，
                    // 如果父类有两个抽象类而子类只是实现了其中一个，则会报错
                    //实现抽象方法的条件是有方法体（有{}符号就算是有方法体）
    @Override
    public int n2() {
        return 10;
    }

    @Override
    public void n3() { //实现是条件是有方法体（有{}符号就算是有方法体）
        //即使方法体内部没有代码也算实现
    }
}