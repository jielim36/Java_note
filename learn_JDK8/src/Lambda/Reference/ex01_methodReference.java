package Lambda.Reference;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 方法引用 Method Lambda.Reference 介绍：

 说明：
 1. 方法引用，可以看作是基于lambda表达式的进一步刻画。
 2. 当需要提供一个函数式接口的实例时，可以使用lambda表达式提供此实例
 3. 当满足一定的条件的情况下，我们还可以使用方法引用或者构造器引用替换lambda表达式

 本质：
 1.方法引用 作为 函数式接口的实例。

 特征：
 :: 符号： 两个冒号组成的操作符，就是 方法引用

 格式：
 类(或对象) :: 方法名

 具体使用情况说明：
 1. 对象 :: 实例方法
 2. 类 :: 静态方法
 3. 类 :: 实例方法 (类实际上无法直接调用实例方法，但有特别的方式可以实现)


 */
public class ex01_methodReference {

    @Test
    public void test01(){
        //这里展示：     对象::实例方法
        System.out.println("===========原始============");
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("hello");

        System.out.println("\n===========Lambda表达式===========");
        Consumer<String> con2 = str -> System.out.println(str);
        con2.accept("hello_2");

        System.out.println("\n==============方法引用================");
        Consumer<String> con3 = System.out :: println;
        con3.accept("hello_3");
        /*
        解释：
        这里使用的是： 对象 :: 实例方法

        1.System.out 源代码：
            public static final PrintStream out = null;
        可以发现out是一个PrintStream类的对象

        2. println() 是System类的一个实例方法，但是在引用可以省略()括号

        所以繁琐的写法可以是：
        PrintStream ps = System.out;
        Consumer<String> con3 = ps :: println
         */


    }

    @Test
    public void test02(){
        //这里还是展示  对象::实例方法
        Employee emp = new Employee(1001,"Lim Yee Jie");

        System.out.println("===========原始============");
        Supplier<String> sup1 = new Supplier<String>() {
            @Override
            public String get() {
                return emp.getName();
            }
        };
        System.out.println(sup1.get());

        System.out.println("\n===========Lambda============");
        Supplier<String> sup2 = () -> emp.getName();
        System.out.println(sup2.get());

        System.out.println("\n===========Method Lambda.Reference============");
        Supplier<String> sup3 = emp :: getName;//对象 :: 实例方法 (这时如果使用 Employee :: getName (类::实例方法)会报错，因为getName不是静态方法，必须要对象才能调用)
        System.out.println(sup3.get());

    }

    @Test
    public void test03(){
        System.out.println("===========原始============");
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);//o1大于o2是返回1,相等返回0，o1小于o2返回-1
                //return (x < y) ? -1 : ((x == y) ? 0 : 1);  (Integer.compare源代码)
            }
        };
        System.out.println(comparator1.compare(1,22));

        System.out.println("\n===========Lambda============");
        Comparator<Integer> comparator2 = (o1,o2)-> Integer.compare(o1,o2);
        System.out.println(comparator2.compare(1,22));

        System.out.println("\n===========Method Lambda.Reference============");
        Comparator<Integer> comparator3 = Integer::compare;//类::静态方法
        System.out.println(comparator3.compare(1,22));

    }

    @Test
    public void test04(){
        //展示 类::静态方法
        System.out.println("=========Original==========");
        Function<Double,Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);//round方法会把double值进位并转换成Long类型
            }
        };
        System.out.println(function1.apply(9.5));//10

        System.out.println("\n=========Lambda==========");
        Function<Double,Long> function2 = (doubleValue) -> Math.round(doubleValue);
        System.out.println(function2.apply(9.7));//10

        System.out.println("\n=========Method Lambda.Reference==========");
        Function<Double,Long> function3 = Math::round;
        System.out.println(function3.apply(9.1));//9
    }

    @Test
    public void test05(){
        //演示  类::实例方法
        System.out.println("========Original==========");
        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);//compareTo()方法是 实例方法，不是static方法
            }
        };
        System.out.println(comparator1.compare("abc","abcd"));

        System.out.println("\n========Lambda==========");
        Comparator<String> comparator2 = (o1,o2)->o1.compareTo(o2);
        System.out.println(comparator2.compare("abcd","abc"));

        System.out.println("\n========Method Lambda.Reference==========");
        Comparator<String> comparator3 = String::compareTo;//String类::compareTo实例方法
        System.out.println(comparator3.compare("abcd","abc"));
        /*
        什么时候可以使用 类::实例方法

        public int compare(String o1, String o2) {
                return o1.compareTo(o2);//compareTo()方法是 实例方法，不是static方法
        }

        1.假设重写实现的抽象方法(compare)的参数数量以n来计算，o1和o2共两个参数，所以n=2
        2.里面的代码调用的方法(比如：compareTo() ) 该方法的括号内的参数数量必须是n-1 (compareTo(o2))，该方法的参数数量只有1个，，n-1=1,所以满足条件
        3.重写实现的抽象方法的参数列表的第一个正好是compareTo实例方法的调用者
         */
    }

    @Test
    public void test06(){
        //演示 类::实例方法

        //使用BiPredicate<T,U>中的 boolean test(T t1,U t2)

        System.out.println("===========Original==============");
        BiPredicate<Integer,Integer> biPredicate1 = new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer n1, Integer n2) {
                return n1.equals(n2);
            }
        };
        System.out.println(biPredicate1.test(5,5));

        System.out.println("\n===========Lambda==============");
        BiPredicate<Integer,Integer> biPredicate2 = (n1,n2) -> n1.equals(n2);
        System.out.println(biPredicate2.test(5,5));

        System.out.println("\n===========Method reference==============");
        BiPredicate<Integer,Integer> biPredicate3 = Integer::equals;
        System.out.println(biPredicate3.test(5,5));
        /*
        分析：
        1. 实现的test方法有2个参数，所以n=2
        2. equals方法只需要一个参数，满足了n-1
        3. 满足了test方法的第一个参数n1调用的equals方法(也就是说test方法的第一个参数是可以调用equals方法的)

         */

    }

    @Test
    public void test07(){
        //演示 类::实例方法
        Employee employee = new Employee(1001,"Lim Yee Jie");

        System.out.println("===========Original==============");
        Function<Employee,String> function1 = new Function<Employee, String>() {
            @Override
            public String apply(Employee emp) {
                return emp.getName();
            }
        };
        System.out.println(function1.apply(employee));

        System.out.println("\n===========Lambda==============");
        Function<Employee,String> function2 = emp -> emp.getName();
        System.out.println(function2.apply(employee));

        System.out.println("\n===========Method reference==============");
        Function<Employee,String> function3 = Employee::getName;
        System.out.println(function3.apply(employee));
        /*
        解析：
        1. 实现的apply方法有一个参数，所以n=1
        2. 内部代码中调用的getName方法有零个参数，满足n-1
        3. 实现的apply方法的第一个参数正好可以调用getName方法
         */
    }
}

class Employee{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
