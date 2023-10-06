package example05;
/*
匿名内部类的细节：

1. 匿名内部类的语法比较奇特，因为匿名内部类既是一个类的定义，同时它也是一个对象，
   因此从语法上看，它既有定义类的特征，也有创建对象的特征。
2. 有一种特别的调用方法方式，当我们确定我们只会调用该类的其中一个功能时可以使用，( new 类名(){...}.成员; )
3.可以直接调用外部类的所有成员，但是外部类不能调用内部类
4.不能使用访问修饰符
5.作用域：仅仅在定义它的方法或代码块中
6.如果外部和内部类的成员重名时，匿名内部类想要访问需要遵循就近原则，想要访问外部类的成员使用（外部类名.this.成员）
 */
public class example05 {
    public static void main(String[] args) {

        new Person().say();//普通对象直接匿名调用某个方法时

        //匿名内部类直接调用某个方法：
        new Person(){
            @Override
            public void say() {
                System.out.println("Anonymous Inner Class say() method");
            }
        }.say();//可以直接调用   , 类似于  new Person().say();

/////////////////////////////////////////////////////////////////////////////////////////////////

        //抽象类进行匿名内部类
        new Animal("HuaHua") {//抽象类必须实现全部抽象方法
            @Override
            public void say(String something) {
                System.out.println("Animal name : " + getName());
            }

            @Override
            public void say2() {

            }
        }.say("没用的参数，测试用的");
    }
}

class Person{
    public void say(){
        System.out.println("class Person say() method");
    }
    public void say2(){
        System.out.println("class Person say2() method");
    }
}

abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void say(String something);
    public abstract void say2();
}