package aSummary;

/*
总结：开发中如何选择集合Collection实现类

在开发中，选择什么集合实现类，主要取决于业务操作特点，然后根据集合实现类特性进行选择，分析如下：

1.先判断存储的类型（一组对象或者一组键值对key-value）
    -允许重复：List
            增删多：LinkedList(底层是一个双向链表)
            改查多：ArrayList（底层是Object类型的可变数组）

    -不允许重复：Set
            无序：HashSet（底层是HashMap，维护了一个哈希表Hashtable:数组+链表+红黑树）
            排序：TreeSet
            插入和取出顺序一致：LinkedHashSet，底层维护了数组+双向链表（底层是以恶搞LinkedHashMap,LinkedHashMap的底层是HashMap）

    -一组键值对：Map
            键key无序：HashMap（底层：哈希表Hashtable ，jdk8:数组+链表+红黑树）
            键key排序：TreeMap
            键插入和取出顺序一致：LinkedHashMap(底层是HashMap)
            读取文件：Properties





 */


public class Summary {
    public static void main(String[] args) {

    }
}
