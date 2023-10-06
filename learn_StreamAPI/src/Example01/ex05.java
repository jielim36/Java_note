package Example01;

import General.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 终止操作的方法:
 1. forEach(Consumer c) - 对数据源遍历，传入consumer对每一个火元素进行某些操作    , 比如：forEach(System.out::println)：遍历每一个元素时输出  （Consumer接口的抽象方法： void accept(T t)）
 2. allMatch(predicate p) - 重写predicate的test抽象方法，test方法会返回一个boolean，当所有数据在test方法都true，allMatch才返回true
 3. anyMatch(Predicate p) - 和allMatch一样，但是anyMatch只需要至少一个数据满足test方法，anyMatch就返回true
 4. findFirst() - 返回第一个找到的元素,不能像forEach直接输出，而是需要接收该方法返回的对象，再输出，或者直接：System.out.println(所有代码写在这里)
 5. count() - 返回Stream中元素的总数(返回long数据类型)
 6. max(Comparator c) - 通过Comparator实现的compare方法排序后的结果，获取结果中最后的一个元素，test06方法有解释
 7. reduce(T identity,BinaryOperator) - 可以将Stream中的元素反复结合起来，得到一个值。返回T
 */
public class ex05 {
    @Test
    public void test01(){
        //匹配与查找

        //allMatch(Predicate p) - 检查是否匹配所有元素
        //Predicate的抽象方法：boolean test(T t);  返回boolean值
        List<Employee> list = Employee.getList();
        boolean b = list.stream().allMatch(emp -> emp.getAge() > 18);//检查全部Employee的年龄是否都大于18岁
        System.out.println(b);
    }

    @Test
    public void test02(){
        //anyMatch(Predicate p) - 检查是否匹配到至少一个元素(只要匹配到一个就返回true)
        List<Employee> list = Employee.getList();
        boolean b = list.stream().anyMatch(emp -> emp.getAge() > 30);//检测是否有至少一个员工大于30岁
        System.out.println(b);//返回 true
    }

    @Test
    public void test03(){
        //目的：检测是否有至少一个员工的工资大于80000
        List<Employee> list = Employee.getList();
        boolean b = list.stream().anyMatch(emp -> emp.getSalary() > 80000);
        System.out.println(b);
    }

    @Test
    public void test04(){
        //findFirst方法 - 返回第一个元素

        //目的：找到年龄最小和最大的员工
        List<Employee> list = Employee.getList();
        System.out.println("====年龄最小：====");
        //接收findFirst()返回的对象，并通过sout输出
        Optional<Employee> low = list.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findFirst();//通过对年龄的升序可以达到第一个出现的数据一定是年龄最小的
        System.out.println(low);
        System.out.println("\n====年龄最大：====");
        //不接收findFirst的对象，而是直接输出
        System.out.println(list.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).findFirst());//通过o2-o1可以达到降序的目的，所以第一个出现的员工就是年龄最大的员工
        //输出结果：Optional[Employee [id=3, name=Bob Johnson, age=35, salary=70000.0]]
        //可以发现有一个Optional前缀，可以通过get()方法只是输出里面的Employee
        System.out.println("====通过get()方法取消Optional前缀====");
        System.out.println(list.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).findFirst().get());

    }

    @Test
    public void test05(){
        //count() - 返回Stream中元素的总数
        List<Employee> list = Employee.getList();
        long count = list.stream().count(); //计算员工总数
        System.out.println("员工总数:"+count);
        System.out.print("超过60000工资的员工总数：");
        System.out.println(list.stream().filter(emp->emp.getSalary()>60000).count());//计算工资超过60000的员工数量
    }

    @Test
    public void test06(){
        //max(Comparator c) - 返回Stream中最大值，通过传入并实现的compare方法

        //目的：返回工资最高的员工
        List<Employee> list = Employee.getList();
        //获取工资最高
        Optional<Employee> max = list.stream().max((o1, o2) -> Double.compare(o1.getSalary(),o2.getSalary()));
        //获取工资最低
        Optional<Employee> low = list.stream().max((o1, o2) -> Double.compare(o2.getSalary(),o1.getSalary()));
        /*
        其实max方法是通过我们排序后的结果获取最后一个元素：

        1.当我们对工资进行升序处理时，此时工资最高的员工在最后一个元素。所以max方法可以获取到工资最高的员工
        2.当我们对工资进行降序处理时，此时工资最高的员工在第一个元素，工资最低的人在最后一个元素。max方法会获取排序后的最后一个元素，也就是获取到工资最低的员工。
         */
        System.out.println("最高"+max);
        System.out.println("最低"+low);

        //单独获取工资
        System.out.println("工资最高：");
        //get()方法可以获取到Employee对象，然后在通过getSalary获取该对象的工资
        //方式1：
        double salary = list.stream().max((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())).get().getSalary();
        System.out.println("方式1："+salary);
        Optional<Double> max1 = list.stream().map(emp -> emp.getSalary()).max(Double::compareTo);
        System.out.println("方式2："+max1);

    }

    @Test
    public void test07(){
        //forEach(Consumer c) - 对数据源遍历，传入consumer对每一个火元素进行某些操作    , 比如：forEach(System.out::println)：遍历每一个元素时输出  （Consumer接口的抽象方法： void accept(T t)）
        List<Employee> list = Employee.getList();
        //Stream类的forEach方法
        list.stream().forEach(System.out::println);

        //注意：JDK8中List类中也新增了forEach方法
        list.forEach(System.out::println);//这个forEach方法是集合的方法(Iterable接口)，不是Stream类的
        //针对list的遍历方法：使用Iterator，增强for，一般for，forEach()
    }

    @Test
    public void test08(){
        //reduce(T identity,BinaryOperator) - 可以将Stream中的元素反复结合起来，得到一个值。返回T
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(integers.stream().reduce(0, (o1, o2) -> o1 + o2));//输出55
        /**
         1. T identity 传入一个值，该值可以和BinaryOperator的数值相加，我们不需要所以传入0
         2.BinaryOperator的抽象方法是 R apply(T t,U u); (R泛型是根据我们的list<Integer>)
         所以我们把t+u的结果返回的操作遍历的话就可以达到把list中的全部元素加起来的效果
         */

        System.out.println(integers.stream().reduce(10, Integer::sum));//使用方法引用Method reference ，原本：Integer.sum(o1,o2);
        /**
         输出：65
         原本的list加起来是55，但是我们在identity传入了一个10，所以 55+10=65
         */

        //目标：算出全员工工资的总和
        List<Employee> list = Employee.getList();
        System.out.print("全员工工资总和：");
        System.out.println(list.stream().map(Employee::getSalary).reduce(0.0, Double::sum));
    }

    @Test
    public void test09(){
        //collect(Collection c) - 将Stream转换为其他形式。通过接收一个Collection接口的实现。用于给Stream做汇总的方法

        //练习1：查找工资大于60000的员工，返回结果为一个List或Set
        List<Employee> list = Employee.getList();
        List<Employee> collect = list.stream().filter(emp -> emp.getSalary() > 60000).collect(Collectors.toList());//collect()方法中可以传入Collectors.toXxxx方法转换成具体的集合类型
        System.out.println(collect);
        //或者
        collect.forEach(System.out::println);

        //目标：通过年龄进行排序并返回成一个新的list
        System.out.println("\n=====年龄=========");
        List<Employee> ageList = list.stream().sorted((o1,o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());
        ageList.forEach(System.out::println);
    }

}
