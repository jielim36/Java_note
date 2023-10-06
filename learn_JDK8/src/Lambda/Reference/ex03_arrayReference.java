package Lambda.Reference;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 数组引用

 格式：
 数组名[] :: new

 作用：创建一个数组

 注意（不确定是否正确）：
    1.实现的方法的参数数量必须只能有1个
     因为方法的参数会放入   new 数组名[参数] ， 会放入[]中
     所以实现的方法如果0个参数就无法定义数组的长度
     如果两个参数也不能同时放入[]中

    2.尝试后发现无法通过两个参数的实现方法来创建一个二维数组



 */
public class ex03_arrayReference {

    @Test
    public void test01(){
        //传统
        Function<Integer,Employee[]> function1 = new Function<Integer, Employee[]>() {
            @Override
            public Employee[] apply(Integer length) {
                return new Employee[length];
            }
        };
        Employee[] array1 = function1.apply(4);

        //数组引用
        Function<Integer,Employee[]> function2 = Employee[] :: new;
        Employee[] array2 = function2.apply(5);

    }

}
