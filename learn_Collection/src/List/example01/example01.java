package List.example01;

import java.util.ArrayList;
import java.util.List;
/*
List接口基本介绍：
List接口是Collection接口的子接口
1.List集合类中的元素有序（即添加的顺序和取出的顺序一直），且可以重复
2.List集合中的每个元素都有其对应的顺序索引，即支持索引（其实底层就是数组）
3.JDK API中List接口的实现类其实不只是有ArrayList等，还有至少5个种类的实现类
 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        //List的特点:
        //1.List集合类中的元素有序（即添加的顺序和取出的顺序一直），且可以重复
        List list = new ArrayList();
        list.add("jack");//可以重复
        list.add("tom");
        list.add("jack");//可以重复
        list.add("jerry");
        System.out.println(list);//[jack, tom, jack, jerry] 输出的顺序和我们添加元素的顺序相同

        //2.List集合中的每个元素都有其对应的顺序索引，即支持索引（其实底层就是数组）
        //索引从0开始
        System.out.println(list.get(1));//tom

        //List的常用方法：
        //1.插入 -> add , addAll
        list.add(1,"于爵");//把于爵插入再下标1，原本的下标1去到下标2
        System.out.println(list);

        List list2 = new ArrayList();
        list2.add("韩顺平");
        list2.add("三上悠亚");
        list.addAll(3,list2);//插入时也可以使用addAll把另外一个List集合也插入进去
        System.out.println(list);

        //2.查找并返回其下标
        //indexOf 返回第一次出现的位置下标
        System.out.println("jack第一次出现的下标："+list.indexOf("jack"));
        //lastIndexOf 返回目标最后一次出现的位置下标
        System.out.println("jack最后一次出现的下标："+ list.lastIndexOf("jack"));

        //3.移除 remove
        list.remove(4);//可以写下标
        System.out.println("移除了下标4："+list);
        list.remove("jerry");//可以写目标
        System.out.println("移除了jerry目标："+list);

        //4.替换 set  ， 替换将直接覆盖原本的位置数据，更改成新的数据
        list.set(1,"于杰");
        System.out.println("替换了下标1："+list);
//        list.set(10,"hi"); 如果下标索引不在范围内，会抛出异常:IndexOutOfBoundsException

        //5. subList 返回从fromIndex参数到toIndex参数-1的子集合
        List returnList = list.subList(0,2);//会返回0-1索引的元素，不包括2
        System.out.println("subList : " + returnList);




    }
}
