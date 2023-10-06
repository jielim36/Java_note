package example01;

public class example01 {
    public static void main(String[] args) {

        A a = new A();//虽然final不能被继承，但是还是可以创建对象的
    }
}
//当我们能不希望某个类被继承时可以用final修饰该类

//如果我们希望A类不能被其他类继承
//可以使用final修饰 A类
final class A{

}

//class B extends A{ 当A类是final时其他类就不能成为A类的子类
//
//}

//String，Integer等等的类都是final修饰的，不能被继承
//class C extends String{
//
//}