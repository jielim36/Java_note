package example05;
/*
注意事项：
6.一个类可以同时实现多个接口
7.接口中的属性只能是final，而且是public static final 修饰符，比如: int a = 1; 实际上是public static final int a = 1;
8.接口中的属性访问形式是 接口名.属性名
9.接口不能继承其他类，但是可以同时继承多个别的接口（），使用extend，而不是implement
 */
public class example05 {
    public static void main(String[] args) {
        //接口中的属性默认是public static final 修饰符
        System.out.println(interFace01.A);//输出1 ：可以直接调用该接口的属性，证明了该属性是static修饰
//        interFace01.A = 2; 直接报错，编译器说 该属性是final属性，不能改变该属性的值：证明了接口属性是final修饰

    }
}

class A implements interFace01 , interFace02{//想要一个类同时实现两个接口时，通过逗号隔开两个接口

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodC() {

    }

    @Override
    public void methodD() {

    }
}

interface interFace01{

    public final static int a = 1;
    int A = 1;//A和a这两个属性是差不多一样的，只是写的方式不同
    // 因为接口中的属性只能是final，而且是public static final 修饰符，比如: int a = 1; 实际上是public static final int a = 1;

    void methodA();
    void methodB();

}

interface interFace02{

    void methodC();
    void methodD();

}

interface interFace03 extends interFace04,interFace05{ //一个接口可以同时继承多个接口，注意：继承用extend，不是用implement实现
    void methodE();
}
interface interFace04{
    void methodF();
}
interface interFace05{
    void methodG();
}