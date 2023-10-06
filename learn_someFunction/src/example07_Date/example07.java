package example07_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
这里的Date指的是java.util.Date
Date: 精确到毫秒，代表特定的时间
2.SimpleDateFormat:格式和解析日期的类SimpleDateFormat格式化和解析日期的具体类。
  它允许进行格式化（日期->文本），解析(文本->日期)和规范化
 */
public class example07 {
    public static void main(String[] args) throws ParseException {

        Date d1 = new Date();//无参构造器：可以直接获取当前系统时间
        System.out.println(d1);//输出： Sat Feb 11 09:32:40 MYT 2023 ->Saturday February 11号 (时间)  MalaysiaTime 2023年
        //我们可以更改时间的格式 -> yyyy年 / MM月 / dd日  / hh小时，mm分钟，ss秒  / E 星期   （这些都类似于占位符，有很多个占位符，但是这里不提供例子，可以去SimpleDateFormat的API查找）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 时间：hh:mm:ss  星期：E");
        String format = sdf.format(d1);
        System.out.println(format);

        System.out.println("\n==========\n通过毫秒获取时间：");
        Date d2 = new Date(999999999l);//通过指定毫秒获取时间
        System.out.println("d2:" + d2);//没看懂

        //可以把一个格式化的String转换成对应的Date
        System.out.println("\n===============\nString转换成Date格式：");
        String s = "2022年02月11日 时间：9:51:30  星期：Saturday";//这里我们需要根据SimpleDateFormat的格式，因为我们等下转换时会给SimpleDateFormat类对象spf
        //这里的转换格式时会有ParseException异常，我们在方法语句中抛出该异常
        Date    d3 = sdf.parse(s);

        System.out.println(d3);
    }
}
