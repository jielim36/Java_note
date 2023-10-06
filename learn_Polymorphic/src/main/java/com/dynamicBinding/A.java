package com.dynamicBinding;

public class A {

    int number = 10;

    public int sum(){
        return getNumber() + 10;
    }
    public int sum1(){
        return number + 10;
    }

    public int getNumber() {
        return number;
    }

    public int sum2(){
        return getNumber() + 20;
    }


}
