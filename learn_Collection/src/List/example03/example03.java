package List.example03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
List的三种遍历方式：
1.迭代器Iterator
2.增强for循环
3.普通for循环

List的实现子类：ArrayList，Linked，Vector都能使用
 */
public class example03 {
    public static void main(String[] args) {
        //List的实现子类：ArrayList，Linked，Vector都能使用
        List list = new ArrayList();
        list.add("hello");
        list.add("hi");
        list.add("bye");

        //1.Iterator
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }


        System.out.println("\n====2.====");
        //2. 增强for循环
        for(Object next : list){
            System.out.println(next);
        }

        //普通for循环
        System.out.println("\n====3.====");
        for (int i = 0 ; i < list.size() ; i++){
            Object next = list.get(i);
            System.out.println(next);
        }
    }
}
