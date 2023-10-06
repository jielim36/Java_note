package Collection.example01;

import java.util.ArrayList;
import java.util.HashMap;

/*
集合的理解和好处：
对比与数组：
1.数组的长度必须指定，而且不能更改
2.保存的必须为同一个类型的元素
3.数组扩容麻烦

集合：
1.可以动态的保存任意多个对象，使用比较方便
2.提供了一系列方便的操作对象的方法：add,remove,set,get（类似增删改查）
3.使用集合添加和删除元素可以很简洁

集合体系图：查看Collection_diagram and Map_diagram

1.集合主要是两组（单列集合，双列集合）
2.Collection接口有两个重要的子接口（List和Set），他们的实现子类都是单列集合
3.Map接口的实现子类（HashTable,HashMap,TreeMap,LinkedHashMap,Properties等等）
  是双列集合，存放的K-V

 */
public class example01 {
    public static void main(String[] args) {

        //单列集合
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");//单个数据
        arrayList.add("tom");

        //双列集合
        HashMap hashMap = new HashMap();
        hashMap.put("No1","jack");//多个数据
        hashMap.put("No2","tom");

    }
}
