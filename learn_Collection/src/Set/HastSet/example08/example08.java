package Set.HastSet.example08;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/*
练习题：
定义一个Employee类，该类包含：private成员属性name,salary,birthday(MyDate类型)，
其中birthday为MyDate类型（属性包括：year,month,day）,要求：
1.创建三个Employee,放入HashSet中
2.当name和birthday的值相同时，认为时相同员工，不能添加到HashSet集合中
 */
public class example08 {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("Lim Yee Jie",99999,new MyDate(2004,7,23)));
        hashSet.add(new Employee("Lo Kai Yang",9999,new MyDate(2004,9,21)));
        hashSet.add(new Employee("Lim Yee Jie",100000,new MyDate(2004,7,23)));

        System.out.println(hashSet);

    }
}

class Employee{
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee Name:" + name + "\tSalary:" + salary + "\tBirthDay:" + birthday.getDate() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday.getDate(), employee.birthday.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday.getDate());
    }
}

class MyDate{

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDate(){

        String format = "%d年-%d月-%d日";
        String date = String.format(format,year,month,day);
        return date;
    }


}