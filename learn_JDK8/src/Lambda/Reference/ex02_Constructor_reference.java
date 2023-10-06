package Lambda.Reference;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 构造器引用

 作用：通过构造器创造一个该类的对象

 格式：
 类名::new

 补充说明：
 实现方法中的参数数量必须和构造器的参数数量一致
 1.当实现方法是无参的，那么创建的构造器自然是无参构造器
 2.当实现方法有两个参数，第一个Integer，第二个String。那么就必须是有两个参数的构造器，且双方参数的数据类型顺序必须保持一致，即：有参构造器的第一个参数必须Integer，第二个参数必须String
 3.总结：创建的构造器和实现方法的形参列表保持一致，顺序和数据类型和参数数量保持一致
 */
public class ex02_Constructor_reference {

    @Test
    public void test01(){
        //创建无参构造器
        System.out.println("===========Original==============");
        Supplier<Employee> supplier1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier1.get());

        System.out.println("\n===========Lambda==============");
        Supplier<Employee> supplier2 = () -> new Employee();
        System.out.println(supplier2.get());

        System.out.println("\n===========Constructor reference==============");
        Supplier<Employee> supplier3 = Employee::new;
        System.out.println(supplier3.get());

    }

    @Test
    public void test02(){
        //创建有参构造器
        Function<Integer,Employee> function1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };
        System.out.println(function1.apply(1).getId());

        System.out.println("\n========Constructor reference==========");
        Function<Integer,Employee> function2 = Employee::new;
        System.out.println(function2.apply(2).getId());
        /*
        分析：
        1. apply方法有一个参数
        2. new Employee()构造器的参数会直接拿apply的参数
         */
    }

    @Test
    public void test03(){
        //创建有参构造器
        //BiFunction<T,U,R>有三个泛型，前2个是给apply抽象方法的参数，第三个泛型是apply方法的返回类型

        BiFunction<Integer,String,Employee> biFunction1 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer id, String name) {
                return new Employee(id,name);
            }
        };
        System.out.println(biFunction1.apply(99,"Sonia"));


        System.out.println("\n========Constructor reference==========");
        BiFunction<Integer,String,Employee> biFunction2 = Employee::new;
        /*
        分析：
        1. apply方法有两个
        2. new Employee()构造器的参数会直接把apply全部参数都放入
        注意：apply方法的两个参数的顺序必须和 有参构造器的参数 的数据类型保持一致
         */
    }

}
