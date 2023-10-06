package Example01;

import General.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 执行流程：
 1. Stream的实例化
 - 一个数据源（如：集合，数组），用该数据源通过某些方法返回一个流，用Stream对象接收


 2.一系列的中间操作
 -每次处理都会返回一个持有结果的新Stream，即：中间操作的方法返回值仍然是Stream类型的对象。因此中间操作可以是操作连
 --可以数据源的数据进行n次处理，但是在终止操作前，并不会真正的执行


 3.执行终止操作。
 -终止操作的方法返回值就不再是Stream了，因此一旦执行终止，就结束了整个Stream操作了
 -一旦执行终止操作，就执行中间操作链，最终产生结果并结束Stream
 */
public class ex02 {
    @Test
    public void test01(){
        //数据源
        List<Employee> list = Employee.getList();
        //通过数据源获取一个Stream实例化
        Stream<Employee> stream = list.stream();

        //通过filter方法 进行过滤（filter是中间操作）
        stream.filter(emp -> emp.getSalary() > 55000).forEach(System.out::println);
        //forEach方法：终止操作, 接收一个Consumer 函数式接口(抽象方法：void accept(T t);)
        System.out.println("\n=====================\n");

        /** 下面这条代码是一个错误示范 */
        //stream.limit(2).forEach(System.out::println);
        //错误：因为stream已经在上面通过forEach方法终止了操作
        //当Stream终止操作之后就不能继续进行中间操作或者终止操作了

        //如果需要重新输出，需要重新通过数据源再次创建Stream
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("\n=====================\n");
        //limit()方法说明：提取list的前x条数据


        //skip() 方法：返回 跳过前x条数据 后的数据（如果Stream中的元素少于x个，则返回空Stream）
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("\n=====================\n");

        //distinct() 方法：去重／筛选，通过Stream所生成的元素的hashcode() 和 equals() 去除重复的元素；
        System.out.println("before:");
        list.stream().forEach(System.out::println);
        list.add(new Employee(10001,"jack",18,999));
        list.add(new Employee(10001,"jack",18,999));
        System.out.println("after");
        list.stream().distinct().forEach(System.out::println);//注意：Employee类中有重写hashcode的计算方式

        System.out.println("\n=====================\n");


    }
}
