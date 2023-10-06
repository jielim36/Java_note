package Map.Properties.example01;

import java.util.Properties;

/*
Properties基本介绍：

1.Properties类继承自Hashtable类并且实现了Map接口，也是使用一种键值对key-value 的形式保存数据
2.它的使用特点和Hashtable类型
3.Properties还可以用于从xxx.properties文件中，加载数据到Properties类对象，并进行读取和修改
4.说明：工作后，xxx.properties文件通常作为配置文件，这个知识点在IO流举例，有兴趣也可以自己去找文章（类似搜索：Java 读取 Properties文件）

 */
public class example01 {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("john",10);
        properties.put("jack",20);
        properties.put("jerry",30);

        System.out.println(properties);

        //通过key获取对应的value
        System.out.println(properties.get("john"));

        //remove
        properties.remove("jack");

        //修改：通过同一个key不同value当作修改
        properties.put("jerry",100);
        System.out.println(properties);


    }
}
