package exercise05;

public class Scientist extends Employee{

    private double bonus;

    public Scientist(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
