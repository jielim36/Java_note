package com.company.projectName.studentExtend;

// Parent Class of pupil (child class) and Graduate(child class)
//actually all class have a parent class that is !! Object !!(system thing, it is not write by programmer) , you can use Ctrl + h to view the extends relationship of all class
public class extendStudent extends topBase {

    public String name;
    public int age;
    private double score;

//    public extendStudent() {
////        super();  this thing is default in the !!child!! class constructor if you have no-parameter constructor in parent class, even you didn't write it in child class
////        but this thing is only in the no-parameter constructor (Maybe)
//        System.out.println("Here is extendStudent no-parameter constructor(Parent Class) , parent class must first run in program because in the constructor have super");
//    }

    public extendStudent(String name) { // if your program there are write the parameter constructor, then will no automatic generate a no-parameter constructor
        this.name = name;               // if your parent class didn't write no-parameter constructor, your child class must write super in the child constructor
        System.out.println("Here is extendStudent name-parameter constructor, super is not here because it is not no-parameter constructor");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    private void getPassword(){
        System.out.println("call private password example from private method");
    }
    public void callPrivatePassword(){
        getPassword();
    }

}
