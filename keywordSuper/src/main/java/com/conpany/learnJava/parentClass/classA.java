package com.conpany.learnJava.parentClass;

public class classA {

    public int a= 100;
    protected  int b;
    int c;
    private int d;

    public classA() { //no-parameter constructor

        this.a = 100;
        this.b = 200;
        this.c = 300;
        this.d = 400;

    }

    public classA(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public classA(int a, int b) {
        this.test(); //if the object is create by class B, this.test() will find in class B first
                    // even this code in classA
    }

    public void print(){
        System.out.println("here is classA method");
    }

    public void test(){ //if class A and B have same variable name method
        System.out.println("here is classA method   (testing same name method but different class)");
    }




}
