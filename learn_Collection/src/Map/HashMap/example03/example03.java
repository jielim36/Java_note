package Map.HashMap.example03;

import java.util.HashMap;

//HashMap的扩容树化触发机制
public class example03 {
    public static void main(String[] args) {
        //创建了一个test类里面有重写hashcode让每一个对象都”人为“的存入同一个数组索引位置上形成链表
        HashMap hashMap = new HashMap();

        for (int i = 1; i <= 12; i++) {
            hashMap.put(new test(i),i);
        }

        /*
        解析：注意所有元素都在数组的同一个索引位置下形成的链表
        1.当hashMap的size为8时，且都在同一个链表（代表链表的大小也为8）
        2.在这个情况下链表还没有转化为红黑树
        3.数组还未扩容（还是16）
        4.当元素添加到9时，还未进行转化成红黑树，但是数组扩容变成32了
        5.当元素添加到10时，还未进行转化成红黑树，但是数组扩容变成64了
        6.当元素添加到11时，数组没有再扩容了（还是64）
        7.但是超过了8个个数的那个链表已经转化成红黑树了

        如何分别已经是红黑树了呢？
        1.发现数组的索引位置上的该链表的运行类型是HashMap$TreeNode
         */


        //测试临界点扩容的时机
        HashMap hashMap2 = new HashMap();
        for (int i = 1; i <= 15; i++) {
            hashMap2.put(i,i);
        }



        /*
        测试过程：
        1.当数组的size到达12时，数组还未扩容，还是16
        2.当数组的size到达13时，数组扩容了，变成32
        结论：当数组的size “超过” 了临界点才会扩容，而不是大于等于临界点
            table size > threshold 才会扩容 不是 >= threshold
         */

    }
}

class test{
    int anInt;

    public test(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
