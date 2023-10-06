package exercise01;

public class exercise02 {
    public static void main(String[] args) {
        Manager person1 = new Manager("Lim Yee Jie" , 2290025 , 100000 , 9999);
        person1.work();
    }
}

abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {//实现了父类的抽象方法
        System.out.println("经理：\nName: "+ getName() + "\nID: "+getId() + "\nSalary: " + (getSalary()+bonus)  );
    }
}
