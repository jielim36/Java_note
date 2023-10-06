package example04;

public class main {
    /*
    1.构造器的最前面其实隐含了super（）和调用普通代码块
    2.静态相关的代码块，属性初始化在类加载时就执行完毕，由此是优先于构造器和普通代码块执行的
     */
    public static void main(String[] args) {
        System.out.println("B类（有继承关系）： ");
        new B();//匿名对象（和现在要讲的东西没有关系，只是方便）

        /*
        总结：
        如果有继承关系时，比如A类和B类（A类是父类，B是子类）
        两个类都用代码块和构造器
        当我们创建B类的实例对象时的执行顺序是：
        -先执行静态代码块
        1.执行A类的静态代码块和属性
        2.执行B类的静态代码块和属性
        -然后才开始执行普通的
        -从B类直接去到A类（因为有super() ）
        -从A类开始执行（依照平时的执行顺序规则）
        3.执行A类的代码块和属性
        4.执行A类的构造器
        -回到B类...
        5.执行B类的代码块和属性
        6.执行B类的构造器

        总结：
        1.会先执行父类的静态代码块和属性（先执行父类才执行子类）
        2.执行子类的静态代码块和属性
        3.执行父类的普通代码块和属性
        4.执行父类的构造器
        -回到B类
        5.执行子类的普通代码块和属性（静态代码块和属性前面就执行了）
        6.执行子类构造器

        问题 1：为什么会先执行父类和子类的静态代码块和属性？
        答案： 因为静态代码块和属性是在加载类时就执行了（即使没有创建实例对象，只要new (类名)就算加载了）
              我们加载子类是( new B(); )，也会先加载B的父类再加载B这个类，所以一定是优先加载父类的静态代码块和属性

        问题2：
         */
    }
}

class A{
    private static int number = getNumber();

    public static int getNumber() {
        System.out.println("A类的静态属性被调用");
        return number;
    }

    static{
        System.out.println("A类的静态代码块被执行");
    }
    {
        System.out.println("A类的普通代码块被执行");
    }

    public A() {
        //这里隐含了两个代码
        //第一个是：
        //super(); 记住super的最上面是Object，所以A的super是调用到Object

        //第二个是调用普通代码块
        System.out.println("A类的构造器被调用");
    }
}

class B extends A{
    private static int number2 = getNumber2();

    public static int getNumber2() {
        System.out.println("B类的静态属性被调用");
        return number2;
    }

    {
        System.out.println("B类普通代码块被执行");
    }
    public B() {
        //super()   B类的super会调用到A，因为继承关系
        System.out.println("B类构造器被调用");
    }

    static{
        System.out.println("B类的静态代码块被执行");
    }


}
