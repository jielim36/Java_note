package Exercise;

public class Student extends Person{

    private int id;
    private double score;

    public Student(String name, int age,int id,double score) {
        super(name,age);
        this.id = id;
        this.score = score;
    }


//    public void say() {
//        System.out.println("Name : " + getName() + "\nAge : " + getAge() + "\nID : "+ id + "\nScore : " + score);
//    }
    public String say(){
        return super.say() + "\nID : " + id + "\nScore : " + score;
    }


}
