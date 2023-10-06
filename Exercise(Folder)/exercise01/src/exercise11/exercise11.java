package exercise11;

import java.util.Scanner;

/*
模拟上课出勤情况。
定义学生类：

属性：姓名，出勤。
提供基本的构造方法和get方法，set方法。
定义讲师类：

属性：姓名。
提供基本的构造方法和get方法，set方法
成员方法：点名方法，设置每一位的学生出勤情况。假设，小明今日未出勤。
定义课程类：

属性：课程名称，讲师，学生集合。
提供基本的构造方法和get方法，set方法
成员方法：show方法，打印课程信息，老师姓名，学生是否上课情况。

作者：辽A丶孙悟空
链接：https://www.jianshu.com/p/baa60ea9d925
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class exercise11 {
    public static void main(String[] args) {
        Student student1 = new Student("小红");
        Student student2 = new Student("大壮");
        Student student3 = new Student("丽丽");

        Student [] studentsList = {student1,student2,student3};

        Teacher teacher1 = new Teacher("韩老师");
        teacher1.takeAttendance(studentsList);

        Course course1 = new Course("Programming Concept Class",teacher1,studentsList);

        course1.showInfo();
    }
}

class Student{
    private String name;
    private char attendance;// y = 出席 , n = 缺席

    public Student(String name) {//attendance由老师决定
        this.name = name;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getAttendance() {
        return attendance;
    }

    public void setAttendance(char attendance) {
        this.attendance = attendance;
    }
}

class Teacher{
    private String name;
    Scanner input = new Scanner(System.in);


    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeAttendance(Student [] studentsList){
        for (int i = 0; i < studentsList.length; i++) {
            System.out.println(studentsList[i].getName() + "今天出席了吗?( y / n ) ");
            char att = input.next().charAt(0);
            studentsList[i].setAttendance(att);
        }
    }


}

class Course{
    private String courseName;
    private Teacher Lecturer;
    private Student [] studentsList;

    public Course(String courseName, Teacher lecturer, Student[] studentsList) {
        this.courseName = courseName;
        this.Lecturer = lecturer;
        this.studentsList = studentsList;
    }

    public void showAttendance(){ //显示学生上课情况
        System.out.print("出席：");
        for (int i = 0; i < studentsList.length ; i++){
            if (studentsList[i].getAttendance() == 'y'){
                System.out.print(studentsList[i].getName()+"\t");
            }
        }
        System.out.print("\n缺席：");
        for (int i = 0; i < studentsList.length ; i++){
            if (studentsList[i].getAttendance() == 'n'){
                System.out.print(studentsList[i].getName() + "\t");
            }
        }
        System.out.println("");
    }

    public void showInfo(){
        System.out.println("==================================");
        System.out.println("Course Name: " + courseName);
        System.out.println("Lecturer Name: " + Lecturer.getName());
        showAttendance();
        System.out.println("==================================");
    }

}