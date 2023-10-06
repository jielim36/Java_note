package com.example2;

//对象的多态， 核心，困难和重点
//一个对象的编译类型和运行类型可以不一致，
//编译类型在定义对象时，就确定了不能改变
//运行类型是可以变化的
// = 的左边是 编译类型， = 的右边是运行类型
//Animal animal = new Dog();  -->  animal的比那一类型是Animal ， 运行类型是Dog
//animal = new Cat()  -->  animal的运行类型变成了Cat， 但是编译类型还是Animal

public class Object_Polymorphic {

    public static void main(String[] args) {
        Animal animal = new Dog("大黄");
        animal.say(); //判断对象执行的say是Dog还是Animal的say的方法是看运行类型， 所以对象执行的say是Dog的say


        System.out.println("\nTest :");

        animal = new Cat("花花");//本来是dog，现在替换成cat，也就是说运行类型可以更改
        Bone bone = new Bone("Bone~~");

        Master person = new Master("Lim Yee Jie");
        person.feed(animal,bone);
    }


}
