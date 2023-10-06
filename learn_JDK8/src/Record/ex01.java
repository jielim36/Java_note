package Record;

/**
 Record:
 实现一个简单的数据载体类，为了避免编写：构造器，访问器，equals(),hashCode(),toString()等, JDK14推出的。

 Record是一个新的类，它本质上是一个final类，同时所有的属性都是final修饰，
 它会自动编译出public get,hashCode,equals,toString，构造器等结构，减少了代码编写量。

 具体来说：当你编写一个record类时，该类将自动拥有以下功能：
 1.获取成员变量的简单方法，比如例题中的name()和partner(); 注意区别于我们平常getter()的写法。
 2.一个equals方法的实现，执行时会比较该类的所有成员属性。
 3.重写hashCode方法
 4.一个可以打印该类中所有属性的toString方法
 5.只有一个构造器

 例子：Record包中的Original类和record_class类的对比

 此外，还可以在record类中的类定义静态字段，静态方法，构造器和实例方法。

 注意：
 1. record类不能继承其他类声明显式的父类（默认父类是 Record类）
 */
public class ex01 {

}
