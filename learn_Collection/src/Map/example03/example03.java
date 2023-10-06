package Map.example03;

import java.util.HashMap;
import java.util.Map;

/*
Map的常用方法
 */
public class example03 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        //put方法，添加元素Key和Value
        Map map = new HashMap();
        map.put("Person 1" , new Book("",10));
        map.put("Person 2" , "Person 3");
        map.put("Person 4" , "Person 5");
        map.put("Person 6" , null);
        map.put(null , "Person 9");
        map.put("Person 10" , "Person 11");

        System.out.println(map);

        //remove 根据key删除映射关系（根据key删除key和value）
        map.remove(null);//输入key删除对应元素（key和value）
        map.remove("Person 10", "Person 11");//也可以key和value都输入
        System.out.println(map);

        //get 通过key获得value
        System.out.println("key:Person 4 , Value ? : "+map.get("Person 4"));//输出value：Person 5

        //size 获取元素个数
        System.out.println("size"+map.size());

        //isEmpty 判断个数是否为0
        System.out.println("判断map的个数是否为零："+map.isEmpty());

        //constant ： 查找key或者value是否存在
        System.out.println("Key : Person 1 是否存在？"+map.containsKey("Person 1"));//寻找key
        System.out.println("Value: Person 2 是否存在？" + map.containsValue("Person 2")); //寻找value


        //clear 清空所有元素
        map.clear();

        System.out.println("清空后\nmap：" + map);

    }
}

class Book{
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}