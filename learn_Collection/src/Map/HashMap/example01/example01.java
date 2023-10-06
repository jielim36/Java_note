package Map.HashMap.example01;

import java.util.HashMap;
import java.util.Map;

/*
HashMap小结：
1.Map接口的常用实现类：HashMap，Hashtable,Properties
2.HashMap是Map接口使用频率最高的实现类
3.HashMap是以一对key-value的方式来存储数据（HashMap$Node类型）
4.Key不能重复，但是值可以重复，允许使用null键和null值。
5.如果添加相同的key，则会覆盖原来的key-value，等同于修改。（key不会替换（但是其实两个key都一样），value会替换）
6.与HashSet一样，不保证映射的顺序，因为底层是以hash表的方式来存储的。
7.HashMap没有实现同步，因此线程是不安全的；
 */
/*
扩容机制（和HashSet一样）：
1.HashMap底层维护了HashMap$Node类型的数组table，默认值为null(HashMap$Node实现了Map$Entry)
2.加载因子（loadFactor）初始化为0.75
3.当添加key-val时，通过key的哈希值 得到在table的索引。然后判断该索引处是否有元素，如果没有元素直接添加。如果该索引已有元素，继续判断该元素的key是否和准备加入的key相等
  如果相等，则直接替换val；如果不相等需要判断是树结构还是链表结构，做成相应的处理。如果添加时发现容量不够，则需要扩容
4.第一次添加时，需要扩容table容量至16，临界值(threshold)为12（table容量*加载因子0.75）
5.以后再扩容时，则需要扩容table容量为原来的2倍，临界值也是原来的两倍，即24（也可以直接算table的大小*0.75），以此类推。
6.在java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD（默认为8），并且table的大小 > MIN_THREEIFY_CAPACITY(默认64)，就会转化成红黑树
 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("no1","韩顺平");//1
        map.put("no2","张无忌");//2
        map.put("no1","张三丰");//3当有相同的key时，就等价于替换/修改，把第一个no1 韩顺平替换掉
        map.put("no3","张三丰");//4
        map.put(null,null);//5
        map.put(null,"abc");//6
        map.put("no4",null);//7
        map.put("no5",null);//8
        map.put(1,"赵敏");//9
        map.put(new Object(),"金毛狮王");//10

        /*
        解析：针对第三个put方法map.put("no1","张三丰");因为key值和第一个put方法相同，所以程序对key值保留，但value值更改的内部运行细节
        两个数据: 第一个put方法：key:"no1" value:"韩顺平"
                第二个put方法：key:"no1"  value:"张三丰"

        1.map.put("no1","张三丰");

        2.一些方法...

        3.重点：putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,  hash: key转化的hash值 , key: "no1"  , value:"张三丰"  ，oblyIfAbsent:false
                   boolean evict) {    evict:true
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //不执行：table此时不是第一次put了，table的大小不是null
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)   //不执行， p获得tab的索引位置的对象然后判断是否为空，（索引位置的计算通过key转化的hash值，但是第一个put方法和现在的put方法key值一样，所以索引位置也一样，导致来到这里时发现该索引已经不是空了，第一个put方法已经在这里了，所以p不为空，p = key:"no1",value:"韩顺平"）
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))  //进入这个if语句：因为p的属性现在是key:"no1" value:"韩顺平"  ,所以p的hash值和当前要添加的对象hash值相同，equals方法对比key字符串也相同，所以进入该if语句
                e = p;  //将p赋给e
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key  //进入此方法，e此时是 key:"no1" value:"韩顺平"
                V oldValue = e.value;  //oldValue获得e.value -> ("韩顺平")
                if (!onlyIfAbsent || oldValue == null)  //这里是进入该putVal方法时传进来的onlyIfAbsent = false , 这里感叹号取反后=true，所以进入该方法
                    e.value = value; //重点：将e(key:"no1",value:"韩顺平")的value更改成当前要添加的对象/元素的value("张三丰")
                afterNodeAccess(e);
                return oldValue;//这里的oldValue已经变成了张三丰 （这里的oldValue应该是指向了e.value，所以e.value更改后oldValue也更改了）
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

         */

    }
}
