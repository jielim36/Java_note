package com.example2;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Animal animal , Food food){
        System.out.println(getName() + " 喂了 " + animal.getName() + " 吃 " + food.getName());
    }

}
