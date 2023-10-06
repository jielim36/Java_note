package exercise04;

public class Admin extends Employee {

    public Admin(String name, double daily_salary, int numDay) {
        super(name, daily_salary, numDay);
    }

    @Override
    public double totalSalary() {
        return (super.totalSalary()+1000)*1.2;
    }



    @Override
    public void showInfo() {
        super.showInfo();
    }
}
