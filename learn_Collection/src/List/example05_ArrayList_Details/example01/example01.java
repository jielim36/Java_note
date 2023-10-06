package List.example05_ArrayList_Details.example01;

import java.util.ArrayList;
import java.util.List;

/*
ArrayList注意事项：
1.permits all element, including null ：ArrayList可以放入所有的元素，甚至是null
2.ArrayList底层是由数组来实现数据存储的
3.ArrayList基本等同于Vector集合，除了ArrayList是线程不安全（但执行效率高），在多线程下，不建议使用ArrayList
  -源码：private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
    可以发现这个源码中ArrayList的add方法中没有使用关键字synchronized修饰，所以线程不安全
 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(null);
        list.add("jack");
        list.add(null);
        System.out.println(list);
    }
}
