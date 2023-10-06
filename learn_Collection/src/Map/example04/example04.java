package Map.example04;

import java.util.*;

/*
Map的六大遍历方式
 */
public class example04 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("AA","aa");
        map.put("BB","bb");
        map.put("CC","cc");
        map.put("DD","dd");

        //第一种：先取出所有的key，通过key取出对应的Value(主要是通过把map的全部key提取出来交给Set集合类型来遍历)
        System.out.println("========第一种========");
        Set keyset = map.keySet();//通过keySet()方法把map的所有key赋给一个Set类型的keyset对象,keyset对象的内部现在是：[AA,BB,CC,DD]
        for (Object obj : keyset){ //然后通过keyset这个Set类型的对象使用增强for循环遍历（Map类型不能使用增强for循环）
            System.out.println(obj + "-" + map.get(obj));//使用get方法通过key找到对应的value
        }

        //第二种：Iterator迭代器(主要是通过把map的全部key提取出来交给Set集合类型来遍历)
        System.out.println("=======第二种======");
        Set keyset2 = map.keySet();
        Iterator iterator = keyset2.iterator();
        while(iterator.hasNext()){

            Object key = iterator.next();//.next()方法每次循环都取出一个key值赋给Object类key对象
            System.out.println(key + "-" + map.get(key));//再由key对象输出key和使用get方法通过key取出value

        }

        //第三种：只输出value值
        System.out.println("=======第三种======");
        Collection values = map.values();//这里把map的全部value都赋给Collection接口的values对象后之后可以用Collection所使用的遍历方法
        for (Object obj : values){
            System.out.println(obj);
        }

        //第四种:取出value，通过iterator迭代器
        System.out.println("=======第四种======");
        Collection values2 = map.values();//这里把map的全部value都赋给Collection接口的values对象后之后可以用Collection所使用的遍历方法
        Iterator iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            System.out.println(next);
        }


        //第五种：通过EntrySet，取出value
        //Map.Entry有两个特别的方法：getKey 和 getValue 可以使用
        System.out.println("=======第五种======");
        Set set2 = map.entrySet();
        for (Object obj : set2){
            Map.Entry ent = (Map.Entry)obj;
            System.out.println(ent.getValue());
        }

        //第五种：通过EntrySet，取出key
        System.out.println("=======第五种======");
        for (Object obj : set2){
            Map.Entry ent = (Map.Entry)obj;
            System.out.println(ent.getKey());
        }

        //第六种：EntrySet使用Iterator
        Iterator iterator3 = set2.iterator();
        while(iterator3.hasNext()){
            Object obj = iterator3.next();//这个iterator3的本质其实是一个Node类型，通过getClass验证
            Map.Entry ent2 = (Map.Entry)obj;
            System.out.println(ent2.getKey() + "-" + ent2.getValue());
//            System.out.println(obj); 也可以直接输出
        }



    }
}
