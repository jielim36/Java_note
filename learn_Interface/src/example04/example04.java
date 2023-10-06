package example04;
/*
注意事项：
1.接口不能实例化
2.接口中的所有方法都是默认public访问修饰符，所以接口中的方法可以不写public，但是实现该接口方法的类方法还是需要写public
3.接口中的抽象方法可以不用写abstract修饰符
4. 一个类如果implement了某个接口，就必须将该接口的所有抽象方法都实现，但是抽象方法以外的方法不一定需要实现
5. 抽象类可以不用实现接口的抽象方法
6.一个类可以同时实现多个接口
7.接口中的属性只能是final，而且是public static final 修饰符，比如: int a = 1; 实际上是public static final int a = 1;
 */
public class example04 {
    public static void main(String[] args) {
//        new example04_interface(); 接口不能被实例化
    }
}

interface example04_interface{

    public void bbb();//public方法
    void BBB();//public方法， 接口里的所有方法的访问修饰符都默认是public，所以写不写都无所谓，但是实现该接口中的方法的类还是需要写public

    public void aaa();//接口中的方法都是public访问修饰符 ， 抽象方法不一定要abstract修饰符
    public abstract void AAA();//和上面一样都是抽象方法，接口里的抽象方法不需要abstract修饰符

    public default void ccc(){
        System.out.println("Interface ddd method");
    }
    public static void ddd(){
        System.out.println("Static method");
    }

}

class hi implements example04_interface{
//必须将所有抽象方法都实现，抽象方法以外的方法不一定要实现
    @Override
    public void aaa() {//虽然接口的方法没有public，但是在类里实现接口的方法时需要写public访问修饰符

    }

    @Override
    public void AAA() {

    }

    @Override
    public void bbb() {

    }

    @Override
    public void BBB() {

    }

}

class bye implements example04_interface{ //快捷键：当我们刚创建类并且implement接口且还没有实现抽象方法时
                                         // 使用alt+enter可以直接一键创建所有抽象方法
    @Override
    public void bbb() {

    }

    @Override
    public void BBB() {

    }

    @Override
    public void aaa() {

    }

    @Override
    public void AAA() {

    }

    @Override
    public void ccc() {
        example04_interface.super.ccc();
    }
}

abstract class xxx implements example04_interface{
    //抽象方法可以不实现接口的抽象方法
}