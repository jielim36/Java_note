package com.example3;

public class main {

    public static void main(String[] args) {
        //多态的细节： 属性没有重写之说， 属性的值看"编译类型"
        //判断当父类和子类的属性都一样时，程序会读取谁的值

        base test = new sub();
        System.out.println(test.number);//output : 10
        //In polymorphic, program look the compile type first(base class), so the value is look for class base value
        //在多态里，当父类和子类都有同一个属性时，程序会看编译类型来寻找该属性的值

        sub test2 = new sub();
        System.out.println(test2.number);//output : 20
        //在正常的情况下（没有多态）， 程序是优先从父类开始寻找（找到10），然后在继续往子类寻找（变20）所以最后是20
        //另外一种解释是，照样看编译类型， sub test2 = new sub90();的编译类型是sub，所以属性的值就是sub的值

        //第三种情况
        //instanceof 代码用于判断该对象是否是XX类型或者XX类型的子类型
        base test3 = new base();
        System.out.println(test3 instanceof base); //true , 因为true就是base类型
        System.out.println(test3 instanceof sub);//false ， 因为test3是base类型， 而sub是base的子类型，所以test3是sub的父类
        sub test4 = new sub();
        System.out.println( test4 instanceof base );//true , 因为test4是sub类型，而sub是base类型的子类型

        String name = "LimYeeJie";
        System.out.println(name instanceof Object);//true, 因为name是String 类型， 而String类型是Object的子类型


        base test5 = new sub();


    }
}

class base{

    int number = 10;

}

class sub extends base{
    int number = 20;
}
