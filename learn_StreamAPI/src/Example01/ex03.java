package Example01;

import General.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 关于映射
 */
public class ex03 {
    @Test
    public void test01(){
        //map(Function f) 接收一个函数作为参数，将元素转换成其他形式或提取信息
        //该函数会被应用到每个元素上

        //目的：把小写转换成大写
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
//        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);//lambda
        list.stream().map(String::toUpperCase).forEach(System.out::println);//Method reference

        //目的：把名字长度大于3的字符串输出
        System.out.println("\nQ2:");
        List<String> list2 = Arrays.asList("aaaaaaa","bb","cccccccc","dd","eeeeee");
        list2.stream().filter(str -> str.length() > 3).forEach(System.out::println); //lambda

        //目的：把员工年龄大于29的人输出他的名字
        System.out.println("\nQ3:");
        List<Employee> empList = Employee.getList();
//        empList.stream().filter(emp -> emp.getAge() > 29).map(emp -> emp.getName()).forEach(System.out::println);//Lambda
        empList.stream().filter(emp -> emp.getAge() > 29).map(Employee::getName).forEach(System.out::println);//Method reference

    }
}
