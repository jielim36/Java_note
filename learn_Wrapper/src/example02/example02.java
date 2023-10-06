package example02;
/*
包装类和基本数据的转换

演示 包装类和基本数据类型的相互转换，这里以int和Integer演示
1.jdk5 前的手动装箱和拆箱方式，装箱：基本类型-> 包装类型 ，反之就是拆箱
2.jdk5和之后的版本以后的自动装箱和拆箱方式
3.自动装箱底层调用的是valueOf方法，比如Integer.valueOf()
 */
public class example02 {
    public static void main(String[] args) {
        //演示手动装箱int -> Integer（没有必要学，旧版本的东西）
        int n1 = 100;
//        Integer number1 = new Integer(n1); 第一种方式  已过时
        Integer number1 = Integer.valueOf(n1);//第二种方式，利用valueOf

        //手动拆箱 Integer -> int
        int i = number1.intValue();

//        jdk5以后，可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱:int -> Integer
        //把基本数据类型变成一个包装类的对象
        Integer number2 = n2;//底层使用的一样是 Integer.valueOf(n2),可以用断点调试查证
        //自动拆箱: Integer -> int
        int n3 = number2;//直接把number2这个Integer对象赋给n3基本数据类型

    }
}

/*
f
t


2.0


2.0
 */
