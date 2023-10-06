package exercise03;

public class Lecturer extends Teacher{

    public Lecturer(String name, int age, String position, double salary) {
        super(name, age, position, salary);
    }

    public void introduce() {
        super.introduce(1.1);
    }
}
