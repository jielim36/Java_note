package Set.LinkedHashSet.example01;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
LinkedHashSet的基本介绍：
1.LinkedHashSet继承了HashSet，也就是HashSet的子类
2.LinkedHashSet也实现了Set接口
3.该集合的底层是一个LinkedHashMap，底层维护了一个数组+双向链表
4.LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序，这使得元素看起来是以插入的顺序保存的。
5.LinkedHashSet不允许添加重复的元素
6.存放元素的顺序：观看韩顺平Java P528 LinkedHashSet讲解的该集合底层机制如何存放顺序
7/


 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet= new LinkedHashSet();

        for (int i = 0; i < 10; i++) {
            linkedHashSet.add(i);
        }

        System.out.println(linkedHashSet);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        /*
        1.LinkedHashSet 加入的顺序和取出袁术的顺序相同
        2.第一次添加元素时，table数组扩容到16
        3.LinkedHashSet的双向链表并不是在数组的某个索引位置的链表形成一个双向链表，而是贯通了数组的每个索引位置（比如索引位置1连接到索引位置3）
         */

        /*
        使用debugger工具测试后发现：

        顺序问题：
        数组的排序是无序的（但是输出时和加入的顺序是相同的，我猜测输出的过程是通过双向链表（有序）而不是通过数组），双向链表的排序也是有序的：
        可以发现debugger中的head属性（头）是1 ， tail属性（尾）是4 ,代表我们添加的元素顺序在LinkedHashSet的双向链表中是有序的
        虽然各个元素在数组的不同索引中，但是链表会去到其他索引串门，也就是说，即使两个元素在数组的不同索引位置中，但是这两个元素依旧有双向链表连接着
        在table数组中可以看到每个元素都拥有before和after属性，且对应着添加的顺序，比如元素（2）的before是1，after是3


        节点的类型：
        通过debugger可以发现：
        1.table数组的类型是HashMap$Node
        2.但是里面存放的元素确实LinkedHashMap$Entry
        3.问题:为什么里面存放的类型可以和table数组不一样呢？
        4.进入到源码发现Entry是个静态内部类，且继承了HashMap.Node这个静态内部类
        5.Entry静态内部类有before和after属性（对应了上面的顺序问题，因为Node类的原本叫作next）
        */

    }
}
