package Example01;

import General.Employee;

import java.util.Arrays;
import java.util.List;

public class ex04 {
    public static void main(String[] args) {
        /** Stream类的sorted方法：用于排序 */
        Integer [] num = {1,55,222,2466,246,2};

        System.out.println("Number Array:");
        Arrays.stream(num).sorted().forEach(System.out::println);//进行了重新排序并输出

        System.out.println(Arrays.toString(num));//注意：Stream并不会影响数据源（原本的数组）
        //Stream对数据源(如：数组/集合)进行重新排序时，只会返回一个新的结果，而不是对数据源进行更改


        /**  对Employee的年龄进行排序 */
        List<Employee> list = Employee.getList();
        /*
        由于Employee类没有实现Comparator接口，所以无法使用sorted无参方法
        但是sorted有另外一个有参方法：Stream<T> sorted(Comparator<? super T> comparator);
        可以传入一个Comparator接口并且实现compare方法
        通过这个方法传入Comparator，Employee就可以正常使用sorted方法
         */
        list.stream().sorted((o1,o2) -> o1.getAge() - o2.getAge()).forEach(System.out::println);

        System.out.println("\n=====如何升序和降序====");
        String [] str = {"dd","cc","aa","bb","aaa"};

        System.out.println("=========sorted()无参默认升序=========");
        Arrays.stream(str).sorted().forEach(System.out::println);//sorted() 无参默认升序
        System.out.println("=========实现Comparator升序=========");
        Arrays.stream(str).sorted((o1,o2) -> o1.compareTo(o2)).forEach(System.out::println);//sorted(Comparator) 实现Compare接口的compare方法升序.compare方法内依靠String的compareTo方法进行对比
        System.out.println("=========实现Comparator降序=========");
        Arrays.stream(str).sorted((o1,o2) -> -o1.compareTo(o2)).forEach(System.out::println);//在compareTo方法的结果放个-就可以降序
        System.out.println("=========方法引用(无法降序，只能升序)===============");
        Arrays.stream(str).sorted(String::compareTo).forEach(System.out::println);//在compareTo方法的结果放个-就可以降序



    }
}
