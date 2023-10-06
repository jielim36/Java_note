package com.company.projectName.student;

import com.company.projectName.studentExtend.extendStudent;

public class Pupil extends extendStudent {
    //Pupil : 小学生
    //In Java , one class only can extend one class , can't class a extend class b and class c at the same time(means one son can't have 2 father)
    // But if programmer need class a extend and use field class b and class c at the same time, you should make class a extend class b , and class b extend class c (means son, father and grandfather)
    //when programmer write the extends, please make sure your code have logically , ( logic of "is-a"  )
    //means you must write Cat is a Animal ( Cat extends Animal  )
    //can't write like Person is a Music ( Person extends Music  ) , it is not logically and another programmer hard to understand your code
    public Pupil() {
        super("name");
        //if the child class constructor have write the code : this(xxx) to call another constructor,
        // so, super(); that code will generate with the next constructor because the first constructor already have this(x),
        // this() and super() cant use in one constructor because both need to write in the first line
    }

    public void Exam(){
        System.out.println("Pupil " + getName() + " is exam now...");
    }

    public void showInfo(){
        System.out.println("Pupil Name: "  + getName() + "\nAge : " + getAge() + "\nScore : " + getScore());
    }
}
