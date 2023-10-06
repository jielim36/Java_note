package Set.example01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set接口基本介绍：
1.无序：添加和取出的顺序不一致，没有索引
2.不允许重复的元素，所以最多包含一个null
3.JDK API 中 Set接口的实现类比如有：HashSet,TreeSet等等。API中也有提供更多Set的实现类
4.和List接口一样，Set接口也是Collection接口的子接口，因此，常用方法和Collection接口一样
5.Set接口的遍历方式
-可以使用迭代器
-增强for循环
-不能使用索引的方式获取：比如普通for循环需要索引...
6.



 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //Set接口的实现类对象（Set接口对象）
        /*
        1.不能存放重复的元素，如果有重复的只会保留最先添加进入Set的元素，重复的元素直接丢掉
        2.添加和取出的顺序不一致
        3.取出的顺序是固定的，不是随机,取出的顺序是根据底层的算法
         */
        Set set = new HashSet();
        set.add("jack");
        set.add("tom");
        set.add(null);
        set.add("jack");//重复的john
        set.add(null);//重复的null
        set.add("hi");
        set.add("1");
        set.add("2");

        System.out.println(set);//输出：[null, hi, 1, 2, tom, jack]

        //第一种遍历方式：
        System.out.println("\n=======迭代器=======");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("\n=======增强for循环=======");
        for (Object o :set) {
            System.out.println(o);
        }

        //普通for循环无法使用，因为Set并没有索引，不能通过索引获取它的值
        System.out.println("删除jack：");
        set.remove("jack");
        System.out.println(set);

    }
}
