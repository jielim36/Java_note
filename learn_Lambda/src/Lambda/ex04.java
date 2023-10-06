package Lambda;

import java.util.function.Function;

public class ex04 {
    public static void main(String[] args) {

        //传统方法
//        Integer integer = typeConver(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {//目的是为了把传入的String字符串转换成Integer数据类型
//                return Integer.valueOf(s);
//            }
//        });
//        System.out.println(integer);


        //Lambda
//        Integer integer = typeConver((String s) -> {
//            return Integer.valueOf(s); //这里的return也可以省略
//        });

        //最简洁的写法
        Integer integer = typeConver(s -> Integer.valueOf(s));
        System.out.println(integer);

    }

    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
    /*
    Function 接口内的唯一抽象方法

    源代码：
    R apply(T t);

     */
}
