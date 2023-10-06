package com.myCompany.ProjectName.things;

public class Aclass {

    //modifier
    public int num1 = 100;
    protected  int num2 = 200;
    int num3 = 300;
    private int num4 = 400;

    //modifier for method
    public void testPublic(){ }
    protected void testProtected(){ }
    void testDefault(){ }
    private void testPrivate(){ }



    public void print(){
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("num3 : " + num3);
        System.out.println("num4 : " + num4);
    }
    private void printPrivate(){ //private modifier method
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("num3 : " + num3);
        System.out.println("num4 : " + num4);
    }

}

class test_defaultClass{ //modifier for class only allow using public and default

    public void haha(){
        System.out.println("lim");
    }

}
