package exercise03;

public class Teacher {

    private String name;
    private int age;
    private String position;
    private double salary;

    public Teacher(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void introduce(){
        System.out.println("Name : " + name + "\nAge : " + age + "\nPosition : " + position + "\nSalary : " + salary);
    }
    public void introduce(double percent){
        System.out.println("Name : " + name + "\nAge : " + age + "\nPosition : " + position + "\nSalary : " + salary*percent+"\n\n");
    }
}
