package com.learnOverride;

public class Animal {

    private String name;
    private int age;
    private double weight;

    public void test(){
        System.out.println("here is Class animal, test method");
    }

    public Object test2(){
        return null;
    }

    public AAA test3(){
        return null;
    }

    public String testX(){
        return null;
    }
    private void test5(){ // parent class is private and child class is public is allowed
        System.out.println("Modifier");
    }
    public void test6(){ // parent class is public but child class is private is WRONG
        System.out.println("Modifier");
    }



}
