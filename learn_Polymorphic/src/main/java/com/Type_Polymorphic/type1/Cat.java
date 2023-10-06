package com.Type_Polymorphic.type1;

public class Cat extends Animal{

    int num4;

        public Cat(String name) {
            super(name);
        }

        public void say() {
            System.out.println("Class Cat() say...");
        }

        public void onlyCat(){
            System.out.println("Here is method only cat have");
        }
}
