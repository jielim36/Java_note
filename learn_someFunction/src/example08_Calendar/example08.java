package example08_Calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
/*
Calendar是需要import:
import java.util.Calendar;
import java.util.GregorianCalendar;

Calendar类是一个抽象类并且构造器是protected的，可以通过getInstance方法获取实例对象
它为特定瞬间与一组诸如YEAR，MONTH,DAY_OF_MONTH,HOUR等日历字段之间的转换提供了一些方法
并为操作日历字段（例如获取下星期的日期）提供了一些方法

Calendar的问题：
1.可变性：像日期和时间这样的类应该是不可变的。
2.偏移性：Date中的年份是从1900开始，而月份都从0开始
3.格式化：格式化只对Date有用，Calendar不行
4.此外，他们的线程都不安全；不能处理闰秒等（每隔两天，多次1s）


由此引出第三代日期类JDK8加入的
LocalDate(年月日) ， LocalTime 时分秒 ， LocalDateTime年月日时分秒
 */
public class example08 {
    public static void main(String[] args) {

        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);//如果直接输出会把所有信息（字段）很杂乱的输出出来
        //获取日历对象的某个日历字段
        System.out.println("年：" + c1.get(Calendar.YEAR));
        System.out.println("月：" + c1.get(Calendar.MONTH)+(1));//+1是因为系统的月从0开始(但是不知道为什么系统把我的+1拼接系统的月份而不是加法)
        System.out.println("日：" + c1.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c1.get(Calendar.HOUR));
        System.out.println("分钟：" + c1.get(Calendar.MINUTE));
        System.out.println("秒：" + c1.get(Calendar.SECOND));

        //Calendar没有专门的格式化方法，所以靠自己组合
        System.out.println("日历："+c1.get(Calendar.YEAR) + "-" + c1.get(Calendar.MONTH) + "-" + c1.get(Calendar.DAY_OF_MONTH));

        //12进制时间
        System.out.println("12进制时间："+c1.get(Calendar.HOUR));
        //24进制
        System.out.println("24进制时间："+c1.get(Calendar.HOUR_OF_DAY));


        //第三代日期类 有三种类
        System.out.println("\n\n====================\n第三代日期类：");
        LocalDateTime obj1 = LocalDateTime.now();//创建实例对象的方式是通过now()方法，now方法返回表示当前日期时间的对象
        System.out.println("年月日时分秒："+obj1);//输出 年月日时分秒
        System.out.println("年："+obj1.getYear());
        System.out.println("月（英文）"+obj1.getMonth());//英文单词月份
        System.out.println("月（号码）："+obj1.getMonthValue());//号码月份
        System.out.println("时：" + obj1.getHour());
        System.out.println("分：" + obj1.getMinute());
        System.out.println("秒：" + obj1.getSecond());

        LocalDate obj2 = LocalDate.now();//第二种类
        System.out.println("年月日："+obj2);//输出 年月日

        LocalTime obj3 = LocalTime.now();//第三种类
        System.out.println("时分秒："+obj3);//输出 时分秒

        System.out.println("\n=======\n格式化");

        LocalDateTime obj4 = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String strDate = dtf.format(obj4);
        System.out.println("格式化日期："+strDate);

        //修改时间
        //提供了plus和minus方法可以对当前时间进行加或减
        System.out.println("\n===============\n修改时间：");
        LocalDateTime obj5 = LocalDateTime.now();
        String formatDate = dtf.format(obj5);
        System.out.println("当前时间："+formatDate);

        LocalDateTime obj6 = obj5.plusDays(10);
        System.out.println("obj5 的10天后："+ dtf.format(obj6));

        LocalDateTime obj7 = obj5.minusMinutes(20);
        System.out.println("obj5的20分钟前："+dtf.format(obj7));

    }
}
