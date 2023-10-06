package example05;

/*
final注意事项
1.final修饰符的属性又叫“常量”，一般用XX_XX_XX来命名( TAX_RATE , NUMBER )
2.final修饰的属性在定义时，必须赋值（比如: final int number = 100;  , 不能不赋值： final int number; ）
-赋值可以在构造器和代码块之中定义
 */

public class example05 {
    public static void main(String[] args) {

    }
}

//赋值的方法有三种： 1.直接赋值
//                2.构造器
//                3.代码块
class A{
    final int number1 = 100;
    final int number2;
    final int number3;
//    final int number4; 没有进行任何赋值会报错
    static final int number5;
//    static final int number6; static属性不能放在构造器

    public A(){
        number2 = 200; // 第二种方法：全局变量定义number2，但是在构造器赋值
//        number6 = 100; 构造器里不能赋值static final属性，因为构造器是当创建对象时才会加载，
//                       而static属性时类加载时就会执行，所以static属性在类加载时必须要有值，所以会报错
    }

    {
        number3 = 300;//第三种方法：全局变量定义number3，但是在代码块中赋值
                      //static代码块想要赋值需要该属性也是static
    }

    static{
        number5 = 100;
    }

}
