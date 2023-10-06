package Map.example05;

import java.util.*;

/*
练习题：
使用HashMap添加三个员工对象，要求
key：员工id
值：员工对象

并遍历显示工资>18000的员工（至少两种遍历方式）
员工类：姓名，工资，员工id
 */
public class example05 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        Employee person1 = new Employee("Lim Yee Jie",999999,2290025);
        Employee person2 = new Employee("Ho Ho Ho",9999,77889);
        Employee person3 = new Employee("Lo Kai Yang",289999,7745);

        hashMap.put(1,new Employee("Lim Yee Jie",999999,2290025));
        hashMap.put(2,new Employee("Ho Ho Ho",9999,77889));
        hashMap.put(3,new Employee("Lo Kai Yang",289999,7745));

        System.out.println("====第一种方式：Set方法====");
        Set keyset = hashMap.keySet();
        for (Object obj : keyset){
            Employee employee = (Employee) hashMap.get(obj);
            if (employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }

        System.out.println("====第二种方式：MapEntry方法====");
        //第二种：EntrySet
        Set set2 = hashMap.entrySet();
        for (Object obj : set2){
            Map.Entry ent = (Map.Entry) obj;
            Employee employee =(Employee) ent.getValue();
            if (employee.getSalary()>18000){
                System.out.println(employee);
            }
        }

        System.out.println("====第二种方式：MapEntry方法使用Iterator迭代器====");
        Set set3 = hashMap.entrySet();
        Iterator iterator = set3.iterator();
        while(iterator.hasNext()){
            Map.Entry ent2 = (Map.Entry) iterator.next();//这里的运行类型是HashMap$Node
            Employee emp =(Employee) ent2.getValue() ;
            if (emp.getSalary()>18000){
                System.out.println(emp);
            }
        }

        System.out.println("====第三种方式：values方法====");
        Collection values = hashMap.values();
        for (Object obj : values){
            Employee emp = (Employee) obj;
            if (emp.getSalary() > 18000){
                System.out.println(emp);
            }
        }


    }
}
class Employee{
    private String name;
    private double salary;
    private int id;


    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}'+"\n";
    }
}