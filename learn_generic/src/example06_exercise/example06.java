package example06_exercise;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
题目要求排序方式：
调用ArrayList的sort方法，传入Comparator对象（使用泛型），先按照name排序，如果name相同，则按照生日日期先后排序
 */

public class example06 {
    public static void main(String[] args) {

        Employee person1 = new Employee("Lim Yee Jie",999999,new MyDate(2004,7,23));
        Employee person2 = new Employee("Lim Yee Jie",999999,new MyDate(2004,7,14));
        Employee person3 = new Employee("Lim Yee Jie",999999,new MyDate(2002,7,23));
        Employee person4 = new Employee("ALin Alin Alin",999999,new MyDate(2002,7,23));

        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
/*
题目要求排序方式：
调用ArrayList的sort方法，传入Comparator对象（使用泛型），先按照name排序，如果name相同，则按照生日日期先后排序
 */
        Collections.sort(arrayList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                if (!(o1.getName().compareTo(o2.getName()) == 0)){ //如果返回的不是0就代表双方不一样name
                    return o1.getName().compareTo(o2.getName());//如果名字不相同，因为使用compareTo方法，所以会根据ASCII编码决定排序，小的在前
                }

                return o1.getBirthday().compareTo(o2.getBirthday());

            }
        });

        for (Employee emp : arrayList){
            System.out.println(emp);
        }

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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee Name:"+name + "\nSalary:"+salary+"\nBirthday:" + birthday.getDate()
                +"\n==================================================\n";
    }

}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDate(){
        String format = "%d年-%d月-%d日";
        String date = String.format(format,year,month,day);
        return date;
    }


    @Override
    public int compareTo(MyDate o) {
//        MyDate obj2 = (MyDate) o; 有泛型可以不用向下转型
        int y = year - o.year;
        if (y != 0){
            return y;
        }

        int m = month - o.month;
        if (m != 0){
            return m;
        }

        return day - o.day;
    }
}

