package exercise11;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, String gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println(getName()+"承诺，我会认真教学");
    }

    @Override
    public String toString() {
        return "Teacher:\n"+ super.toString() + "\nWork Age : " + work_age+"\n=================";
    }

    @Override
    public void play(String ply) {
        super.play("象棋");
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }
}
