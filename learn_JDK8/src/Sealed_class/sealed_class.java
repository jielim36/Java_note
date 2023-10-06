package Sealed_class;

/**
 在Java中如果想让一个类不能被继承或者修改，这时我们本该使用final修饰该类。
 不过final会使该类不够灵活（不能被继承和可以被随意继承的两个极端）

 这就引出了 sealed关键字的作用：
 有时候我们只想要该类可以被具体的某些类继承，其他类不能随意继承。
 作用：
 1.被sealed修饰的类可以使用permits指定其子类。达到了不能被随意继承，也能达到只有被允许的几个类可以继承该类。
 */
public sealed class sealed_class permits Student,Teacher,People{
    //permits关键字：指定哪些类可以继承该类（也就是说使用permits的sealed类都是父类，且限制只有哪些类可以当作它的子类）
}

// sealed类的子类必须是 final，sealed，non-sealed修饰的类
sealed class Student extends sealed_class{} //sealed子类使用extend继承sealed父类,但也需要其他类继承它才能不报错

final class kid extends Student{};

final class Teacher extends sealed_class{}

non-sealed class People extends sealed_class{}
