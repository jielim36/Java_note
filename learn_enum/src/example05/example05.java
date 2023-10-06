package example05;

public class example05 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println("toString方法："+boy);//本质是调用toString方法，但是该案例的枚举类没有重写所以调用父类的toString方法，但是枚举类的父类不是Object类而是enum类，所以调用的是enum类的toString方法
        /*
        Enum父类的toString源码：
        public String toString() {
            return name;
        }

        所以这里会直接输出toString的话会输出BOY,也就是我们枚举类中创建的对象名称
         */
        System.out.print("boy == boy2 : ");
        System.out.println(boy==boy2);//true，因为静态对象是共享的


        test a = new test();//创建一个对象用于调用不是static方法的getInstanceTest方法来创建其他对象
        test b = a.getInstanceTest();
        test c = a.getInstanceTest();
        System.out.print("test, b == c :");
        System.out.println(b == c);//false ， 因为即使是

        test d = a;
        test e = a;
        System.out.print("test, d == e :");
        System.out.println(d == e);//true，因为他们两个都指向了a的地址

        test f = test.getTest();
        test g = test.getTest();
        System.out.print("test, f==g :");
        System.out.println(f == g);
    }
}

enum Gender{
    BOY,GIRL;
}

class test{

    public test getInstanceTest(){
        return new test();
    }

    public static test getTest(){
        return new test();
    }

}
