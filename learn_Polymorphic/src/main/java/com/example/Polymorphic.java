package com.example;

/*
Polymorphic 多态
多态指的是 方法或对象具有多种形态, 多态是面向对象OOP(Object-Oriented Programming)的三大特征之一
面向对象的三大特征: Encapsulation封装 + Extends继承 + Polymorphic多态

多态是建立在封装和继承基础之上
多态是 对象的多态和方法的多态

以下体现的是方法的多态 -> 方法: 重载overload 和 重写override
*/



public class Polymorphic {

    public static void main(String[] args) {
        //方法重载 overload 体现的多态
        System.out.println("Overload重载 体现的多态");
        B b = new B();
        System.out.println(b.sum(3,5));
        System.out.println(b.sum(3,4,5));


        System.out.println("Override重写 体现的多态");
        A a = new A();
        a.say();
        b.say();
    }

}

class A{ //父类

    public void say(){
        System.out.println("A方法被调用");
    }

}

class B extends A { //子类

    public void say(){
        System.out.println("B方法被调用");
    }

    public int sum(int n1,int n2){
        return n1 + n2;
    }
    public int sum(int n1, int n2 , int n3){
        return n1 + n2 + n3;
    }

}