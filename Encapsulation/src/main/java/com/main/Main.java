package com.main;

public class Main {

//    public static void main(String[] args) {
//
//        //Encapsulation : 封装
//
//        Person person1 = new Person();
//        person1.setName("Lim Yee Jie");
//        person1.setAge(1121);
//        person1.setSalary(1800);
//        person1.setJob("Student");
//        person1.showInfo();
//
//    }

}

class Person{
    //field / attributes
    private String name; //first step of encapsulation is make the field to private modifier
    private int age;
    private double salary;
    private String job;

    //constructor
    public Person(String name , int age , double salary , String job ) {
//        this.name = "No Name";
//        this.age = 0;
//        this.salary = 0;
//        this.job = "No Job";
        // you can put the setter method in the constructor
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setJob(job);
    }

    //setter
    public void setName(String name){
        if(name.length() > 15){
            System.out.println("character name is too long");
            this.name = "null";
            return;
        }


        this.name = name;
    }
    public void setAge(int age){
        if(age < 0 || age > 120){
            System.out.println("!!! Age is not valid  !!!");
            this.age = -1;
            return;
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if(salary < 0){
            System.out.println("Salary is not valid");
        }
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    //getter
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    public double getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

    public void showInfo(){
        System.out.println("Name : " + getName() + "\nAge : " + getAge() + "\nSalary : " + getSalary() + "\nJob : " + getJob());
    }
}
