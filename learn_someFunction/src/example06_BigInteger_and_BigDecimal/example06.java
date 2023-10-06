package example06_BigInteger_and_BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;

/*
BigInteger保存比较大的整数
BigDecimal适合保存精度更高的浮点型（小数）
 */
public class example06 {
    public static void main(String[] args) {

        //平时如果要保存比较大的整数
//        long n1 = 9999999999999999999l; 保存一个long数据类型也不支持的长度 ： 直接红字报错

        //如果用BigInteger
        BigInteger n2 = new BigInteger("2299999999999999999000000");//把该数字放入双引号变成字符串(虽然是字符串，但是不能放文字符号等)
        System.out.println(n2);

        //在对BigInteger对象进行加减乘除的时候需要使用对于的方法，不能直接使用+ - * / 符号
        /*
        方法：
        加法：add
        减法：subtract
        乘法: multiply
        除法：divide
         */
        //加法
        BigInteger n3 = new BigInteger("100");
        n2 = n2.add(n3);//加法不能直接加数字，还得创建一个BigInteger对象(也可以使用匿名创建对象，例子在减法那里)
        System.out.println("加法后："+n2);

        //减法
        n2 = n2.subtract(new BigInteger("50"));//使用匿名创建对象
        System.out.println("减法后:" + n2);

        n2 = n2.multiply(new BigInteger("5"));
        System.out.println("乘法后："+n2);

        n2 = n2.divide(new BigInteger("5"));
        System.out.println("除法后："+n2);

        //BigDecimal (和BigInteger几乎一样的规则)
        System.out.println("\n========================================\nBigDecimal:");

        double n4 = 1.99999999999999911111111111111111122222222222;
        System.out.println(n4);//输出：1.9999999999999991  可以发现有些小数点的精度连double数据类型都无法支持

        BigDecimal n5 = new BigDecimal("1.99999999999999911111111111111111122222222222");
        System.out.println(n5);

        //如果对BigDecimal进行运算，和BigInteger一样
        n5 = n5.add(new BigDecimal("4"));
        System.out.println("加法后："+n5);


        n5 = n5.subtract(new BigDecimal("3"));//使用匿名创建对象
        System.out.println("减法后:" + n5);

        n5 = n5.multiply(new BigDecimal("10"));
        System.out.println("乘法后："+n5);

        n5 = n5.divide(new BigDecimal("2"));
        System.out.println("除法后："+n5);
        /*
        BigDecimal的除法有可能会抛出一个异常,由于BigDecimal的小数点精度很高，所以当除以一个无法除完而导致无限循环的小数
        比如我们除以1.1的时候:n5 = n5.divide(new BigDecimal("1.1"));
        Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
	    at java.base/java.math.BigDecimal.divide(BigDecimal.java:1769)
	    at example06_BigInteger_and_BigDecimal.example06.main(example06.java:64)

	    解决方法：在调用divide方法时，指定精度即可， BigDecimal.ROUND_CEILING（但是我的JDK版本被弃用了）
         */
//        n5 = n5.divide(new BigDecimal("1.1" , BigDecimal.ROUND_CEILING));
//        System.out.println("调正精度的divide方法后："+n5);



    }
}
