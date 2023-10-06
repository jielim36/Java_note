package Set.HastSet.example05;

import java.util.HashSet;

/*
测试将链表转化为红黑树的过程
 */
public class example05 {
    public static void main(String[] args) {
        /*
        如果我们要测试将链表转化为红黑树，我们就要想办法将一个链表放入8个元素个数
        一个链表放入8个元素个数的方法：
        了解底层如何判断并添加节点：
        hash值相同的同时，内容不一致就能形成链表（如果hash值和内容都相同就判定成同一个对象，无法添加至hashset）
        所以我们自定义一个类，重写hashCode方法，让底层想要获取元素的hashcode时返回我们重写的方法
        然后我们重写的hashcode方法里return 随便一个号码，然后添加8元素时，每个元素的内容不一样，
        就能够达到每个对象的hashcode一样但是内容不一样

         */

        HashSet hashSet = new HashSet();


        for (int i = 1 ; i < 12; i++){
            hashSet.add(new test(i));//每个循环的时候创建的对象内容是i，所以每个对象内容不一样，但是hashcode一样（有重写hashcode方法）
        }
        System.out.println(hashSet);
        /*
        测试结论：
        1.可以发现已经添加了8个元素个数后，还没有转化成红黑树（因为数组大小还没超过64）
        2.如果已经有八个元素然后数组大小还没超过，就在让链表的个数达到9时，对数组的大小进行扩容（*2）
        3.之后我们每添加一次链表的个数，就对数组扩容一次（8-9时16扩容至32）（9-10时，32-64）注意:数组大小要超过64才会转化成红黑树，所以这时还没转化
        4.随着我们数组的扩容，原本我们的链表在数组的索引[4]变成在索引[36](而且一开始0起点，去到索引4。现在32起点，刚好也是5个个数后索引[36]，所以我猜测迁移的位置有一定的规律，或者说扩容的数组是在数组的前面填充而不是往后填充？)
        5.随着我们增加元素个数从10-11时，数组的大小本来是64，现在还是64，但是链表转化成了红黑树
         */


    }
}

class test {
    private int n;

    public test(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;   //保证每个对象的hashcode都一样
    }

    @Override
    public String toString() {
        return n+"";
    }
}
