package exercise11;

public class Student extends Person{

    private int stu_id;

    public Student(String name, String gender, int age,int stu_id) {
        super(name, gender, age);
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println(getName()+"承诺，我会认真学习");
    }

    @Override
    public void play(String ply) {
        super.play("足球");
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "Student:\n"+ super.toString() + "\nStudent ID : " + stu_id+"\n=================";
    }
}
