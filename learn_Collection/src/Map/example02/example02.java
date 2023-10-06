package Map.example02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class example02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("no1","JieLim");
        hashMap.put("no2","KaiYang");
        /*
        Map存放数据的key-value。
        一对k-v是放在一个HashMap$Node中的
        有些人也说一对k-v就是一个Entry
        1.k-v最后是HashMap$Node node = newNode(hash,key,value,null);
        2.k-v为了方便程序员的遍历，还会创建EntrySet集合，该集合存放的元素类型是Entry。
        3.而一个Entry对象就有k-v EntrySet<Entry<K,V>> 即：源代码（成员属性field）：transient Set<Map.Entry<K,V>> entrySet;
         */
        //当把HashMap$Node对象存放到entrySet就方便我们的遍历，因为Map。Entry提供了重要的方法
        // K getKey(); V getValue();这两个方法

//        for (Object obj : hashMap){  //如果是HashMap不能使用增强for循环遍历
//        }
        Set set = hashMap.entrySet();//将hashMap转成Set
        System.out.println(set);//[no2=KaiYang, no1=JieLim]
        System.out.println(set.getClass());//class java.util.HashMap$EntrySet  ,可以发现运行类型已经变成了EntrySet

        for (Object obj : set){//用Set类型就能使用增强for循环
            System.out.println(obj.getClass());//class java.util.HashMap$Node ，但是实际上它还是个Node
            //为了从HashMap$Node中取出一个k-v
            //先做一个向下转型
            Map.Entry entry = (Map.Entry)obj;//向下转型
            System.out.println(entry.getKey() + "-" + entry.getValue());//向下转型后就可以使用Map.Entry的getKey和getValue单独取出key 和 value了
        }


    }
}
