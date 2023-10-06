package Example01;

import General.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 使用说明：
 1. Stream不会存储数据
 2.Stream不会改变数据源对象。相反的，Stream会返回一个持有结果的新Stream
 3. Stream 操作是延迟执行的。这意味着它们会等到结果才会执行。
 4.Stream一旦执行了终止操作，就不能再调用其他中间操作或终止操作了。

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
public class ex01 {

    /**
     创建Stream的三种方式：
     */
    @Test
    public void test01(){
    //方式1：通过集合
        List<Employee> list = Employee.getList();
        Stream<Employee> stream = list.stream();
        //stream() 方法 源码：default Stream<E> stream(){...} 返回一个顺序流

        Stream<Employee> employeeStream = list.parallelStream();
        //parallelStream() 方法：返回一个并行流

    }

    @Test
    public void test02(){
        //方式2: 通过数组创建
        Integer arr[] = {1,2,3,44,5,6,7,7};
        Stream<Integer> stream = Arrays.stream(arr);
        /*
        调用Array类的public static <T> Stream<T> stream(T[] array) 方法返回一个流
         */
        int arr2[] = new int[]{1,2,3,4,5,66,7};
        IntStream stream2 = Arrays.stream(arr2);
        //如果是基本数据类型有各自的重写方法：public static IntStream stream(int[] array)
        //由IntStream接收
    }

    @Test
    public void test03(){
        //方式3：通过Stream类的of()方法 （当没有现成数据时）
        Stream<String> aa = Stream.of("AA", "BB", "CC","DD","EE");


    }


    }