package exercise10;

public class different {
    /*
    问题：说出 == 和 equals的区别

    答：
    1. 概念： 首先，==是一个比较运算符，而equals是一个写在Object类的一个方法method


    2. 用于基本数据类型 Primitive data Type
        ==用于基本数据类型时，是可以用于对比两个数据的值是否相同
        equals方法不能用于基本数据类型，只能用于引用类型reference type

    3. 用于引用类型Reference Type
        == 用于引用类型时，是对比双方的地址，通常用于判断两个对象的地址是否相同（也就是判断双方是否是同一个人）
        equals用于引用类型时，如果是String类型时，可以对比双方的字符串（相当于判断内容是否一样），原理是Object类的子类String类里面有重写equlas方法
                            如果是我们自定义的对象时，对比的是双方的地址，原理是Object类里的equals method是判断双方的地址，
                                但是如果我们在自定义对象的类里重写一个equals方法时，可以根据需求达到对比两个对象的内容一样时返回true
                                而不是只能对比双方的地址

     */
}
