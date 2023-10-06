package com.company.projectName.student;

import com.company.projectName.studentExtend.extendStudent;//different package must write import location of parent class and package this child class also change

public class Graduate extends extendStudent {
 //Graduate 大学生 / 毕业


    public Graduate() {
        //super(x); this function must put it in the first line in constructor
        //super() and this() cant use in the same constructor because those must put in the first line
        super("name");//this function means call the parameter constructor from parent class
//        For Example: parent class constructor is public extendStudent(String name) { ... } , so you need to write super(name) in child class constructor


//        super(); if parent class have no-parameter constructor,
//        then child class constructor will automatically generate code/function super();
//        and the programmer can't see it but the programmer also can write it themselves
        System.out.println("Here is Graduate Constructor(child class), this code will run after parent constructor because have super");
    }


    public void Exam(){
        System.out.println("Graduate " + getName() + " is exam now...");
    }

    public void showInfo(){
        System.out.println("Graduate Name: "  + getName() + "\nAge : " + getAge() + "\nScore : " + getScore());
    }

}
