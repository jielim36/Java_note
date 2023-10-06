package example05;

public class main {
    public static void main(String[] args) {

    }
}

class test{
    private int number1 = 100;
    private static int number2 = 200;

    private void method1(){
        System.out.println("普通方法被调用");
    }
    private static void method2(){
        System.out.println("静态方法被调用");
    }

    static {

        //System.out.println(number1);//普通属性
        System.out.println(number2);//静态属性
        //method1();//普通方法
        method2();//静态方法

        //总结: 静态代码块只能调用静态方法和属性
    }
    //普通代码块
    {
        System.out.println(number1);//普通属性
        System.out.println(number2);//静态属性
        method1();//普通方法
        method2();//静态方法

        //总结： 普通代码块可以调用普通和静态的所有方法和属性
    }

}
