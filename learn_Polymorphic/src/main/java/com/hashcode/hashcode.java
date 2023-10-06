package com.hashcode;

public class hashcode {

    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new A();

        System.out.println("a1 hashcode : " + a1.hashCode());
        System.out.println("a2 hashcode : " + a2.hashCode());
        //两个引用如果指向的是不同的对象，哈希值是不一样的

        A a3 = a2;
        System.out.println("a3 hashcode : " + a3.hashCode());//hashcode same with a2
        //两个引用如果指向的是同一个对象，哈希值肯定是一样的

        //哈希值主要根据地址号来的， 但是不能完全将哈希值等价于地址
        //后面在集合中hashcode有用到

    }

}

class A{

}
class B{

}
