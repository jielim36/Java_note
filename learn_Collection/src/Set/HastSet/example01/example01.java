package Set.HastSet.example01;

import java.util.HashSet;
import java.util.Set;


/*
HashSet基本介绍：
1.HashSet实现了Set接口
2.HashSet实际上是HashMap ，构造器源码：
  public HashSet() {
        map = new HashMap<>();
    }

3.可以存放null值，但只能一个
4.不保证元素是有序的，取决于hash后，再确定索引的结果
5.不能有重复的元素

 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Set hashSet = new HashSet();
        System.out.println(hashSet.add("john"));//输出：true，在执行add方法时，会返回一个boolean值，如果添加成功会返回true
        System.out.println(hashSet.add("lucy"));//true
        System.out.println(hashSet.add("john"));//false ,如果添加重复的对象，会返回false
        System.out.println(hashSet.add("Rose"));//true

        System.out.println(hashSet);//[Rose, john, lucy]  , 输出的结果不是和添加的顺序一致，也不是倒序

        hashSet = new HashSet();//重新把hashSet对象指向新的new HashSet , 意味着hashSet对象被清空了，方便我现在做测试

        hashSet.add(10);
        hashSet.add(10);
        hashSet.add("jerry");
        hashSet.add("jerry");
        hashSet.add(new StringBuffer("lucy"));
        hashSet.add(new StringBuffer("lucy"));
        hashSet.add(new Dog("tom"));
        hashSet.add(new Dog("tom"));
        System.out.println(hashSet);//[Dog:tom, lucy, jerry, lucy, Dog:tom]
                                    //jerry和10只有出现一次是因为他们的底层都是同一个对象，而lucy和tom是new一个新对象出来，两个tom的内存地址其实不一致

        hashSet.add(new String("Hi"));
        hashSet.add(new String("Hi"));//false , 进不去，需要看源码了解
        System.out.println(hashSet);

    }
}

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog:" + name;
    }
}