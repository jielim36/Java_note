package exercise04;

public class normalEmployee extends Employee{

    public normalEmployee(String name, double daily_salary, int numDay) {
        super(name, daily_salary, numDay);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary()*1.0;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
