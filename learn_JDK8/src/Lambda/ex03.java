package Lambda;

import java.util.function.IntPredicate;

public class ex03 {
    public static void main(String[] args) {

        //传统方法
//        printNumber(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value%2==0;//当传入的value是双数就返回true
//            }
//        });
        /*
        复制test方法的参数列表和方法体和内部就好了
        复制这段：
        (int value) {
                return value%2==0;
            }

         */

        //Lambda
        //只需要在printNumber()的括号内复制粘贴test方法的参数列表和方法体就完成了
        printNumber((int value)->{
            return value%2==0;
        });

        /*
        IntPredicate 接口的源代码：

        public interface IntPredicate {

            boolean test(int value);


            default java.util.function.IntPredicate and(java.util.function.IntPredicate other) {
                Objects.requireNonNull(other);
                return (value) -> test(value) && other.test(value);
            }

            default java.util.function.IntPredicate negate() {
                return (value) -> !test(value);
            }

            default java.util.function.IntPredicate or(java.util.function.IntPredicate other) {
                Objects.requireNonNull(other);
                return (value) -> test(value) || other.test(value);
            }
        }

        可以发现虽然有很多个方法，但只有一个抽象方法，所以还是满足使用Lambda的使用前提要求
        要求：必须是接口，且接口内只有一个抽象方法

         */

    }

    public static void printNumber(IntPredicate predicate){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if (predicate.test(i)){//把数组的每一个整数都传入test方法，test方法内部就是我们重写的test方法，然后会返回boolean值
                System.out.println(i);//如果test方法返回true就输出值
            }
        }
    }
}
