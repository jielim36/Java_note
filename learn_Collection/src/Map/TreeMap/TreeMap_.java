package Map.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

/*
TreeMap的基本介绍：
1.TreeMap实现了Map接口
2.排序规则和判断元素一否一致也能更改编辑，使用传入Comparator类的有参构造器更改
 */
public class TreeMap_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //默认构造器创建TreeMap：排序规则: 看key字符的ASCII码
        TreeMap treeMap = new TreeMap();

        treeMap.put("a",1);
        treeMap.put("c",2);
        treeMap.put("e",2);
        treeMap.put("z",2);
        treeMap.put("d",2);
        treeMap.put("b",3);
        System.out.println(treeMap);//{a=1, b=3, c=2, d=2, e=2, z=2}  ,根据字符的ASCII编码

        TreeMap treeMap2 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
                //这里我把系统判断两个元素是否一致的规则 和 排序规则改成了看双方的字符串长度
            }
        });

        treeMap2.put("aaaa",1);
        treeMap2.put("cc",2);
        treeMap2.put("bbb",3);
        treeMap2.put("d",4);
        treeMap2.put("eee",4);//不能添加，因为更改了排序规则改变成依照字符串长度，所以如果字符串长度和其他元素一样的话，会被系统判断成同一个元素，但是和当前要当前要添加的元素一样长度的另一个旧元素的value会被现在的value替代，但是key保留
        System.out.println(treeMap2);//{d=4, cc=2, bbb=4, aaaa=1}  ，注意：bbb的value变成了4

        /*
        解析：关于传入Comparator类的有参构造器部分
        构造器：
        TreeMap treeMap2 = new TreeMap(new Comparator() {  这个new Comparator是匿名内部类
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
                //这里我把系统判断两个元素是否一致的规则 和 排序规则改成了看双方的字符串长度
            }
        });

        2.使用put方法添加第一个元素
        进入put方法。。。
        public V put(K key, V value) {
            return put(key, value, true); //调用put方法key:"aaaa" , value:1  , replaceOld:true
        }

        3.进入put方法
         private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;
        if (t == null) { //执行：t现在还没有元素所以是null
            addEntryToEmptyMap(key, value); //调用addEntryTOEmptyMap方法：t如果是null没有完全没有元素，没有顾虑可以直接添加元素了
            return null; //return null了表示成功添加元素
        }
        //全部都不用看了，因为已经return null 了
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        } else {
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        }
        addEntry(key, value, parent, cmp < 0);
        return null;
    }

    private V remapValue(Entry<K,V> t, K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        V newValue = callRemappingFunctionWithCheck(key, t.value, remappingFunction);
        if (newValue == null) {
            deleteEntry(t);
            return null;
        } else {
            // replace old mapping
            t.value = newValue;
            return newValue;
        }
    }




        4.进入addEntryToEmptyMap方法
        private void addEntryToEmptyMap(K key, V value) {
        compare(key, key); // type (and possibly null) check  //检查是否为null？(猜测)
            root = new Entry<>(key, value, null); //创建Entry类型数据然后接收现在要添加的元素，然后再赋给root属性（注意：TreeMap的存放类型是Entry，不再是以前那个Node）（此时存放的null是赋给parent属性）
            size = 1; //因为这个方法是专属给第一次添加进TreeMap的元素，所以size固定是1
            modCount++;
            //所有东西执行完了后回到第3步的方法然后return null就成功添加了新元素
        }

         */

        /*
        ////////////////////////////////////////////////////////////////////////////////////////////
        解析源代码：关于第二次添加元素
        1.省略前面的代码直接跳到put方法。。。

        2.private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root; //先将该TreeMap的根部元素（第一次添加的元素）赋给t
        if (t == null) {  //不执行，此时t已经有元素了所以不是null，现在要添加第二个元素
            addEntryToEmptyMap(key, value);
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator; //把comparator属性赋给cpr，这个comparator属性是Comparator类的，原本是默认的，但是我们的有参构造器里有传入我们自己编辑重写的一个Comparator类，然后构造器会将我们传入的该类赋给这个comparator，所以其实现在的这个comparator就是我们在构造器写的那个Comparator匿名内部类，证明：TreeMap_$1（TreeMap_是我们现在这个自己写的类，$代表内部类）        if (cpr != null) { //执行：我们的cpr不是空
            do {
                parent = t; //把根部元素t赋给parent属性
                cmp = cpr.compare(key, t.key); //cpr调用我们自己重写的compare方法来对比双方元素的key（动态绑定机制）：对比当前要添加的元素的key和根部元素的key
                if (cmp < 0)  //排序
                    t = t.left;
                else if (cmp > 0) //排序
                    t = t.right;
                else { //如果上面两个if语句都不通过，代表compare方法返回的是0，也就代表双方的元素是一样的（这也是为什么我说更改排序规则，同时也更改了系统判定双方元素是否是同一个元素的判定机制）
                    V oldValue = t.value; //根部的value赋给oldValue（猜测其实也是共享地址）
                    if (replaceOld || oldValue == null) {  //传入该方法的replaceOld是true，所以这里会进入
                        t.value = value; //如果双方元素一致，保留旧的元素的key，但是value更改成当前要添加的元素的key
                    }
                    return oldValue; //返回oldValue，t.value被更改时oldValue也随之更改（猜测）
                }
            } while (t != null); //使用do while循环
        } else {
            Objects.requireNonNull(key);
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        }
        addEntry(key, value, parent, cmp < 0); //这里就正式的创建并添加当前的元素到TreeMap
        return null;//return null表示添加成功
    }
         */

    }
}
