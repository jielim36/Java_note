package com.company.projectName.student;

public class main {

    public static void main(String[] args) {

        Pupil pupil = new Pupil();
        pupil.setName("Xiao");
        pupil.setAge(8);
        pupil.setScore(90);
        pupil.Exam();
        pupil.showInfo();
        System.out.println("\n======================================\n");
        Graduate graduate = new Graduate();
        graduate.setName("Lim Yee Jie");
        graduate.setAge(18);
        graduate.setScore(100);
        graduate.Exam();
        graduate.showInfo();

        graduate.callPrivatePassword();

    }

}
