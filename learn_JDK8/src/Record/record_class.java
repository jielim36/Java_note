package Record;

/**
 该类和Record Package中的Original类的所有代码完全一致
 但该类却只需要在类名的右边写入成员变量就完成了和Original一摸一样的功能
 */
public record record_class(int id, String name) { //实例变量必须写在类名右边的括号 ， record类不能继承

    //即使在record_class类里不写代码也和Original类的功能一样，因为内部已经自动编写了

    //下面做其他测试：
    static String info = "hi"; //可以额外编写static变量 （普通实例变量如：int a = 10; 必须写在类名右边的括号内）

    public static void test01(){ //也可以写static方法
        System.out.println("static method");
    }

    public record_class(){ //无参构造器 （内部自动编写的是依照我们的成员变量创建的有参构造器）
        this(0,null);//如果没有写代码时该构造器会报错
    }
}
