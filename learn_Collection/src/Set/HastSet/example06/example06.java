package Set.HastSet.example06;

import java.util.HashSet;

/*
测试：
HashSet的底层是HashMap，第一次添加时，table的数组扩容到16(默认)，临界点(threshold)是16*加载因子（loadFactory）是0.75 = 6*0.75 = 临界点12
测试该临界点12是指：只针对数组的长度，还是包括了链表的每个元素

 */
public class example06 {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();


        for (int i = 1 ; i <= 7; i++){
            hashSet.add(new test(i));//每个循环的时候创建的对象内容是i，所以每个对象内容不一样，但是hashcode一样（有重写hashcode方法），所以可以形成链表
        }
        for (int i = 1 ; i <= 7; i++){
            hashSet.add(new test2(i));//每个循环的时候创建的对象内容是i，所以每个对象内容不一样，但是hashcode一样（有重写hashcode方法），所以可以形成链表
        }

        /*
        针对链表的元素个数是否影响扩容数组的临界值测试结论：

        结论：
        1.数组的大小从0变成16
        2.对数组的某个索引上放入了一个链表，该链表有七个元素
        3.此时的数组大小依旧是16
        4.对数组的另外一个索引再次放入一个链表，该链表有5个元素
        5.此时的数组共有两个索引有链表，一个链表有7个元素，一个链表有5个元素= 该数组共有12个元素
        6.数组有12个元素的同时数组的大小依旧是12
        7.但是我们在第二个链表放入第六个元素时，数组的大小超过了12这个临界点
        8.然后数组的大小扩容成32了
        9.总结：临界值是包括了链表的个数而不是单独看数组的大小。且超过了临界值12才会扩容，如果元素个数正好12就还不会扩容

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

class test2 {
    private int n;

    public test2(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 200;   //保证每个对象的hashcode都一样
    }

    @Override
    public String toString() {
        return n+"";
    }
}