package com.learnOverride;

public class main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.test();
        dog.testX();
    }

    /*
    * if we want to make method override, make sure :
    *   1.same variable name of method
    *   2.same parameter(data type and how many parameter must same, variable name can different)
    *   3.same return type(void, Object , boolean , String , int , etc...) ,
    *      !!parent class use Object type and child class use String type return type is allowed
    *       意思是子类(返回的类型是父类的子类) 或 返回和(父类一样的类型)都可以
    *   4.子类override method不可以缩小父类method的访问权限modifier, 比如: 父类public , 子类 private, 这种情况子类就影响了父类的访问权限
    *     子类的访问权限可以比父类更大                               比如: 父类private, 子类 public : 扩大访问权限是可以接受的
    *   访问权限排名: public > protected > default > private
    *
    *
    * */

}
