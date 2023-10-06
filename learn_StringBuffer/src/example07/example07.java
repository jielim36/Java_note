package example07;
/*
String,StringBuffer和StringBuilder的比较
1.StringBuilder和StringBuffer非常相似，均代表可变的字符序列，而且方法也一样
2.String：不可改变的字符序列，效率低但复用率高。
3.StringBuffer：可变字符序列（CRUD）,线程安全
4。StringBuilder：可变字符序列，线程不安全

说明：
1.String复用率高的原因：因为如果有两个数据都是同一个内容，那他们都指向同一个常量池字符串，比如两个数据都是"lim",那么常量池也只会有一个"lim"且两个数据都指向它
2.String效率低的原因：当一个数据一直更改字符串时，原本的字符串被弃用后依然会保存在常量池中
  （如果多次执行这些改变字符串内容的操作（比如循环执行a += "ha"）时，会导致大量副本字符串对象存留在内存中，降低效率，影响程序性能）
3.StringBuffer线程安全的原因：因为StringBuffer类的全部方法都有用synchronized进行修饰（以后线程会学到）
4.StringBuilder线程不安全的原因：和StringBuffer相反，多线程时会错误读取等问题
 */

import com.sun.security.jgss.GSSUtil;

public class example07 {
//String vs StringBuffer vs StringBuilder：执行效率测试
    public static void main(String[] args) {

        String text = "";
        long startTime = 0;
        long endTime = 0;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        //Buffer
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 80000; i++){
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));


        //Builder
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++){
            builder.append(String.valueOf(i));//i不是字符串类型，所以想要增加进去buffer字符串现需要用valueOf，valueOf就是用于将非字符串类型转换成字符串的
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));


        //String
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++){
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

        /*
        测试结果：单位应该是毫秒
        1.StringBuffer的执行：10左右
        2.StringBuilder的执行：1左右
        3.String的执行：1907左右

        数据量越大，差距越明显（可以试试更改for循环的次数）

        总结：
        使用原则结论：
        1.如果字符串在大量的修改操作，一般使用StringBuffer和Builder
        2.如果字符串存在大量的修改操作，并且在单线程的情况，使用StringBuilder
        3.如果字符串存在大量的修改操作，并且是在多线程情况，使用StringBuffer
        4.如果我们的字符串很少修改，且被多个对象引用，使用String。比如：配置信息等

         */

    }

}
