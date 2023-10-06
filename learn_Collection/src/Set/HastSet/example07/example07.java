package Set.HastSet.example07;

import java.util.HashSet;
import java.util.Objects;

/*
练习题：
定义一个Employee类，该类包含name和age
1.创建三个Employee类对象放入HashSet中
2.当name和age的值相同时，认为时相同员工，不能添加到HashSet中
 */
public class example07 {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("Lim Yee Jie",19));
        hashSet.add(new Employee("Lo Kai Yang",18));
        hashSet.add(new Employee("Lim Yee Jie",19));

        System.out.println(hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) { //alt+insert自动生成的equals，可以用于在hashSet中判断双方的内容是否相同，如果相同返回true，这个功能可以让HashSet不能添加两个相同内容的Employee对象
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() { //alt+insert自动生成的代码：这个hashCode重写方法可以让hashSet返回employee类对象的hashcode时，使用该对象的name和age转化的hashcode，这样可以让不同的对象但相同的内容返回的hashcode一样，让hashset判断出双方的内容一致后拒绝第二个元素的加入
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
