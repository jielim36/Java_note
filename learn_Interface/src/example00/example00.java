package example00;
/*
接口就是给出一些没有实现的方法封装到一起，到某个类需要使用的时候，再根据具体情况把这些方法写出来
语法：
interface 接口名{
    //属性
    //方法
}

class 类名 implements 接口{
    自己的属性；
    自己的方法；
    必须实现的接口的抽象方法
}

接口里可以有：
1.静态方法
2.抽象方法：等其他类实现
3.普通方法：已经实现的方法
4.属性
 */
public class example00 {
    public static void main(String[] args) {
        A interfaceObj = new A();
    }
}
/*
如果一个类 implement 了某个接口就必须将该接口的所有抽象方法都实现
 */
class A implements example_Interface{

    @Override
    public void aaa() {
        System.out.println("接口aaa抽象方法");
    }

    @Override
    public void AAA() {
        System.out.println("接口AAA抽象方法");
    }
}
