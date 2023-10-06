package com.Array;

public class main {
    public static void main(String[] args) {

        Person []personArray = new Person[4];
        personArray[0] = new Student("Lim Yee Jie",19,100);
        personArray[1] = new Student("HoHoHo",20,30);
        personArray[2] = new Teacher("Suhailah" , 29,15000);
        personArray[3] = new Teacher("Tee" , 33 , 27000);

        for (int i = 0; i < personArray.length; i++) {
            System.out.println(personArray[i].say());

            if(personArray[i] instanceof Student){ //比如i 是 0 和 1 时就是true，
                // 因为那个时候personArray[i]的编译类型是Person而且指向的是Student( personArray[0] = new Student(); )
                // ,然后这里就判断personArray是否是Student的父类，
                // 也就是当Person的子类是Student时就是true

                //方法1：
                Student students = (Student)personArray[i];
                students.study();

            }

            if(personArray[i] instanceof Teacher){
                //方法2 ：
                ((Teacher)personArray[i]).teach();
            }

            System.out.println("\n================\n");
        }

//        Student [] students = new Student[2];
//        students[0] = (Student)personArray[0];
//        students[1] = (Student)personArray[1];
//
//        for (int i = 0; i < students.length; i++) {
//            students[i].study();
//        }
//
//        Teacher [] teachers = new Teacher[2];
//        teachers[0] = (Teacher) personArray[2];
//        teachers[1] = (Teacher) personArray[3];
//        for (int i = 0; i < teachers.length; i++) {
//            teachers[i].teach();
//        }

    }
}
