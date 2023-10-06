package com.exercise2;

public class main {
    public static void main(String[] args) {

        //Question 1
        sub test = new sub();//sub compile type
        System.out.println(test.number);//20 look the conpile type(sub)
        test.display(); // 20  look the run type运行类型

        //Question 2
        base test2 = test;//base compile type
        System.out.println(test2 == test); //true
        System.out.println(test2.number);//10 ,look the compile type(base)
        test2.display();//20    look the run type 运行类型 还是sub


    }
}

class base{
    int number = 10;

    public void display() {
        System.out.println(this.number);
    }
}

class sub extends base{
    int number = 20;

    @Override
    public void display() {
        System.out.println(this.number);
    }
}
