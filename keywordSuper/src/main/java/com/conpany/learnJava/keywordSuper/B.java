package com.conpany.learnJava.keywordSuper;

import com.conpany.learnJava.parentClass.classA;

public class B extends classA {

    private int test;
    public int a = 1;
    public B() {
        super.print();//super use in constructor to call parent class method /
                        // but i think !! this !! also can use in constructor and no different
    }


    public B(int test) {
        test();
        this.a = 1;
        this.b = 2;
//        this.c = 3; different package can't access default and private modifier
//        this.d = 4;
    }

    public B(String test) {

        System.out.println(super.a);
    }

    public B(int a, int test) {
        super.test();

    }

    public B(int a, int b, int test) {
        super(a, b);

    }

    public void call(){
        System.out.print("here is using B to call classA : ");
        this.print();//this use in method to call parent class method
    }

    public void test(){
        System.out.println("Here is B   (testing same name method but different class)");
    }

    public void testField(){
        System.out.println(a);
    }


}
