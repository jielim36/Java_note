package exercise03;

public class Professor extends Teacher{

    public Professor(String name, int age, String position, double salary) {
        super(name, age, position, salary);
    }

    @Override
    public void introduce() {
        super.introduce(1.3);
    }
}
