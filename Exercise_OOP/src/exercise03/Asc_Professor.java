package exercise03;

public class Asc_Professor extends Teacher{

    public Asc_Professor(String name, int age, String position, double salary) {
        super(name, age, position, salary);
    }

    public void introduce() {
        super.introduce(1.2);
    }

}
