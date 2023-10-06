package Set.TreeSet_;
import java.util.Comparator;
import java.util.TreeSet;
/*
TreeSet特点：有序（但需要做处理）
默认排序规则：字母的编码数字大小
自定义排序规则：通过比较器Comparator的compare方法(注意：自定义排序规则也代表检查相同元素的规则，比如如果把排序规则改成比较两个元素的字符串的长度，那么就不能狗添加两个字符串长度相同的元素，因为会被检测成同一个元素)
 */
public class TreeSet_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("b");
        treeSet.add("a");

        System.out.println(treeSet);//[a, b, c, d]  默认排序规则：通过字符的ASCII编码


        //自定义排序：通过TreeSet的构造器使用匿名内部类Comparator
        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //自己写规则
                //return ((String)o1).compareTo((String)o2); //通过向下转型成String类，在通过String类的compareTo方法比较，这个其实就是默认无参构造器的排序规则（ASCII编码）
                String str1 = (String) o1;
                String str2 = (String) o2;
                return str1.length() - str2.length();//这个规则是根据字符串长度

            }
        });
        treeSet2.add("dddd");
        treeSet2.add("aa");
        treeSet2.add("bbb");
        treeSet2.add("ccc");//无法添加到treeSet
        System.out.println(treeSet2);

        /*
        源码：针对添加第二个元素：

        1.进入add方法(TreeSet类的方法)
        public boolean add(E e) {
            return m.put(e, PRESENT)==null;  //这个PRESENT其实是value，但是treeSet只允许输入key数据，value数据是系统自己的PRESENT属性（Object对象）
        }

        2.进入m.put方法（put方法是TreeMap的方法，这也是为什么会说TreeSet的底层是TreeMap）
        private V put(K key, V value, boolean replaceOld) {
        Entry<K,V> t = root;  //root = 树的根部（猜测：应该是指第一个存放的元素，也就是dddd），所以这里把"dddd"赋给t
        if (t == null) {  //不执行：t现在有第一个元素"dddd"，如果此时我们添加的是第一个元素，根部就是null，这里就会执行
            addEntryToEmptyMap(key, value); //如果根部为null，则添加元素
            return null; //然后直接return回去
        }
        //不是根部的情况下...
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator; //这个comparator属性猜测是有参构造器弄出来的Comparator类对象
        if (cpr != null) { //执行：此时的cpr指向TreeSet_$1 ,也就是我们自己的TreeSet_类的Comparator匿名内部类
            do {
                parent = t; //像根部（第一个元素）赋给parent
                cmp = cpr.compare(key, t.key); //这里用cpr对象调用compare方法传入当前要添加的元素的key和根部的key，注意：此时的compare方法是我们自己匿名内部类重写的方法
                if (cmp < 0)  //我们重写方法写的return str1.length() - str2.length(); ，用于判断这里，所以如果str1小于str2就执行该方法
                    t = t.left;  //不懂，反正就是添加元素和排序
                else if (cmp > 0)//如果str1长度长过str2
                    t = t.right; //不懂
                else { //如果我们重写的方法返回0 ，代表双方的字符串长度一致，此时程序会阻止我们添加该属性（所以我们修改TreeSet的排序方式，也会修改TreeSet判断两个元素是否相同的判定规则/标准）
                    V oldValue = t.value; //将t.value 也就是系统自己的Object对象赋给oldValue
                    if (replaceOld || oldValue == null) { //这里的replaceOld我们刚进入该方法时已经传入了，传入了true
                        t.value = value;  //将当前要添加的元素的value（Object对象）赋给t.value（替换），但是其实没有区别
                    }
                    return oldValue;//返回oldValue
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

        //如果排序规则那里双方元素判定为不同的元素，则从这里开始继续
        addEntry(key, value, parent, cmp < 0); //成功添加元素
        return null;//返回
    }
         */



    }
}
