package exercise05;

public class Teacher extends Employee {
    private double daily_salary;
    private int numDay;

    public Teacher(String name, double salary, double daily_salary, int numDay) {
        super(name, salary);
        this.daily_salary = daily_salary;
        this.numDay = numDay;
    }

    public double getSalary() {
        return super.getSalary() + (daily_salary*numDay);
    }

}
