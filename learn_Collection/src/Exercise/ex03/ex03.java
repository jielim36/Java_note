package Exercise.ex03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
1.HashMao类实例化一个Map类型的对象m，key(String) value(int) 分别用于存储 员工的姓名和工资，存入的数据根据：
jack - 650元 ； tom - 1200元  smith - 2900元
2.将jack的工资更改为2600元
3.为所有员工工资加薪100元
4.遍历集合中的所有的员工
5.遍历集合中的所有的工资
 */
@SuppressWarnings("all")
public class ex03 {
    public static void main(String[] args) {

        Map hashMap = new HashMap();
        hashMap.put("Jack",650);
        hashMap.put("Tom",1200);
        hashMap.put("Smith",2900);
        System.out.println(hashMap);

        //将jack的工资更改为2600元
        hashMap.put("Jack",2600);
        System.out.println("将jack的工资更改为2600元："+hashMap);


        //为所有的员工工资加薪100元
        Set set = hashMap.keySet();
        for (Object obj : set){
//            int salary = (int)(hashMap.get(obj)) + 100; 可以优化
//            hashMap.put(obj,salary);
            hashMap.put(obj , (Integer)hashMap.get(obj)+100);
        }
        System.out.println("为所有的员工工资加薪100元："+hashMap);


        //遍历所有的员工
        System.out.println("\n\n遍历所有员工名字：");
        for (Object obj : set){
            System.out.println(obj);
        }

        //遍历所有员工的工资
        System.out.println("\n\n遍历所有员工的工资：");
        for (Object obj : set){
            System.out.println(hashMap.get(obj));
        }

        //遍历全部信息
        System.out.println("\n\n遍历所有信息：");
        Set set2 = hashMap.entrySet();
        for (Object obj : set2){
            Map.Entry ent = (Map.Entry)obj;
            System.out.println(ent);//可以分别用getKey and getValue
        }


    }
}
