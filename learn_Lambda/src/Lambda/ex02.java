package Lambda;

import java.util.function.IntBinaryOperator;

public class ex02 {
    public static void main(String[] args) {
        /**
         传统方法
          */
//        int i = calculateNumber(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });
//        System.out.println(i);
        /**
         Lambda表达式

         由于Lambda只关注参数，所以我们尝试复制传统方法中的的方法参数列表和方法内：
         (int left, int right) {return left + right;}

         然后直接在 calculateNumber(); 括号内添加我们复制的内容
         */

        int i = calculateNumber((int left, int right) -> {return left + right;});
        /*
        关于IntBinaryOperator接口：
        public interface IntBinaryOperator {
                int applyAsInt(int left, int right);
        }
        可以发现是一个接口，里面也只有一个抽象方法，所以可以使用Lambda
         */
    }

    public static int calculateNumber(IntBinaryOperator operator){
        int a = 10;
        int b = 20;

        return operator.applyAsInt(a,b);
    }

}
