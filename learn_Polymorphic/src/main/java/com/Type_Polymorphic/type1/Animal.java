package com.Type_Polymorphic.type1;

public class Animal {
    String name;
    int num1;
    int num2;
    int num3;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("class Animal say()...");
    }

    public void onlyAnimal(){
        System.out.println("Here is method only Animal have");
    }

}
