package Collection.example02;

import java.util.ArrayList;
import java.util.List;

/*
1.Collection实现子类可以存放多个元素，每个元素可以是Object
2.有些Collection的实现类，有些是有序的（list） ,有些不是有序的（Set）
3.有些Collection的实现类可以存放重复的顺序，有些不可以
4.Collection接口没有直接的实现子类，是通过它的子接口Set和List来实现的
 */
public class example02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //Collection的常用方法
        //add 添加元素
        List list = new ArrayList();
        list.add("jack");//全部数据类型都可以放入元素中，包括Object对象
        list.add(10);//底层：list.add(new Integer(10)) , 直接放入的这些数据其实都是包装类Wrapper对象，不是基本数据类型
        int a = 20;
        list.add(a);//猜测可能也是list.add(new Integer(a)) ， 有点不确定
        list.add(true);
        System.out.println("List:"+list);

        //remove 删除元素
        list.remove("jack");//可以指定删除某个元素
        System.out.println("List:"+list);

        list.remove(0);//也可以用下标，注意：jack删除过后，jack后面的元素会补充jack的位置（原本jack的下标是0，可是jack被删除了，所以现在的下标0不是jack而是10）
        System.out.println("List:"+list);

        list.remove(true);
        System.out.println("List:" + list);

        //contains 查找元素是否存在
        System.out.println("jack是否存在？："+list.contains("jack"));
        System.out.println("20是否存在?: "+list.contains(20));
        list.add("tom");
        list.add(77);
        list.add(false);
        System.out.println("List:"+list);

        //size 获得元素个数
        System.out.println("元素个数："+list.size());

        //isEmpty 判断是否为空
        System.out.println("是否为空？:"+list.isEmpty());//false 显然不是，因为我们有4个元素个数

        //clear 清空
        list.clear();
        System.out.println("List:"+list);
        System.out.println("是否为空?:" + list.isEmpty());//true

        //addAll 添加多个元素：两个Collection的实现子类之间可以传输
        ArrayList list2 = new ArrayList();//创建Collection的实现子类ArrayList的对象list2
        list2.add("Jie");//给list2添加元素
        list2.add(19);
        list2.add(false);
        list.addAll(list2);//list接收list2的数据元素
        System.out.println("List:"+list);

        //containsAll 查找多个元素是否存在：也是两个COllection实现子类的互动
        System.out.println("list是否有list2的元素？："+ list.containsAll(list2));

        //removeAll 删除多个元素：也是两个collection实现子类的互动
        list.add("hihi");//给list对象一个元素方便测试
        System.out.println("List对象删除list2的元素前："+list);
        list.removeAll(list2);
        System.out.println("list对象删除了list2的元素后："+list);






    }
}
