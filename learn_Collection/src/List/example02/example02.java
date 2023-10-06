package List.example02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
练习题：
添加十个以上的元素，
在二号位加入韩顺平教育，
获得第五个元素
删除第六个元素
修改第七个元素
在使用迭代器遍历集合
要求：使用List的实现类ArrayList完成
 */
public class example02 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");
        list.add("hello");

        list.add(1,"韩顺平教育");
        System.out.println("第五个元素："+list.get(4));//获得第五个元素
        list.remove(5);//删除第六个元素
        list.set(6,"Hi");

        //使用迭代器Iterator遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
