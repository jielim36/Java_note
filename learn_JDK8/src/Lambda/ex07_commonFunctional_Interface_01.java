package Lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/**
 这里会演示几个常用的Functional Interface 函数式接口(Reference包中有许多案例)

 函数式接口              称谓              用途
 1. Consumer<T>     消费型接口       对数据类型为T的对象应用操作，包含方法: void accept(T t)
 2. Supplier<T>     供给型接口       返回类型为T的对象，包含方法T get();
 3. Function<T,R>   函数型接口       对类型为T的对象应用操作，并return R类型的对象。包含方法 R apply(T t)
 4. Predicate<T>    判断型接口       确定类型为T的对象是否满足某个约束，并返回boolean值，包含方法： boolean test(T t)
 */
public class ex07_commonFunctional_Interface_01 {

    public static void main(String[] args) {

        Predicate<Integer> predicate = value -> value>0;//重写实现predicate接口的test方法，通过验证传入的整数判断是否大于0
        boolean test = predicate.test(-99);// -99 > 0 = false
        System.out.println(test);

    }



}
