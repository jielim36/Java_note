package exercise04;

public class Employee {

    private String name;
    private double daily_salary;
    private int numDay;

    public Employee(String name, double daily_salary, int numDay) {
        this.name = name;
        this.daily_salary = daily_salary;
        this.numDay = numDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaily_salary() {
        return daily_salary;
    }

    public void setDaily_salary(double daily_salary) {
        this.daily_salary = daily_salary;
    }

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }

    public double totalSalary(){
        return daily_salary * numDay;
    }

    public void showInfo(){
        System.out.println("Name : " + name + "\tSalary of Month : " + totalSalary());//这里调用的total salary方法会优先回去子类调用
    }

}
