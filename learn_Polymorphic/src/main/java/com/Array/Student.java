package com.Array;

public class Student extends Person{

    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String say() {
        return "Student Name : " + super.say() + "\tScore: " + score;
    }
    public void study(){
        System.out.println("Student "+getName() + " say Student need to study everytime");
    }

    public void setScore(double score) {
        this.score = score;
    }
}
