package Map.HashTable.example01;

import java.util.Hashtable;

/*
1.存放的元素是k-v
2.hashtable的key和value不能为null，否则会抛出空指针异常
3.hashtable使用方法基本上和HashMap一样
4.hashtable是线程安全(该类的方法有使用synchronized)的，hashMap是线程不安全的
5.添加新元素时其他元素有一样key值，和HashMap一样只替换掉旧的value，改成新添加的元素的value
6.数组的初始容量大小为11

底层结构：
1.HashTable继承了Dictionary类（翻译：字典）


名称          版本      线程安全（同步）        效率      允许null key 和 null value
HashMap      1.2       不安全                 快           允许
Hashtable    1.0        安全                  慢           不可以

 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Hashtable hashtable = new Hashtable();
        hashtable.put("john",10);
        hashtable.put("john",23);//替换
        //hashtable.put(null,23);//抛出空指针异常
        //hashtable.put("jack",null);//value为空也会抛出空指针异常

        for (int i = 1; i <= 7; i++) {
            hashtable.put(i,i);
        }
        for (int i = 9; i <= 100; i++) {
            hashtable.put(i,i);
        }

        /*
        1.底层有一个数组，Hashtable$Entry[] 数组，初始化大小为11
        2.扩容机制：当数组的元素个数“超过”8时就会进行扩容，扩容的计算为：原本的数组大小乘2 ：（11）*2 = 23 ，此时的临界点= 0.75 * 23 = 17.25 = 17 ,

         */
        /*
        解析：关于数组元素个数从8添加到9时，数组的扩容细节源码：
        1.使用put方法添加元素：
        public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {  //如果value为null，返回空指针异常
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length; //这是一个获取一个数组索引值的算法
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];//将tab的index索引值的元素赋给entry(注意：如果该索引值内有链表，就是整个链表都赋给entry)
        for(; entry != null ; entry = entry.next) { //不执行：因为这时添加的元素的索引值是null，没有其他元素在这个索引值内。；for循环，循环条件：entry != null（终止条件就是 entry == null） ,迭代：entry = entry.next(这里用循环应该是因为这个数组的索引值里的元素可能是个链表（所以终止条件是entry == null），所以需要依次对每个节点对比)
            if ((entry.hash == hash) && entry.key.equals(key)) { //对entry.hash这个节点的hash值和当前要添加的元素的hash值对比 和 双方的key使用equals方法对比，如果双方是同一个元素，进入该if语句
                V old = entry.value; //已有的节点元素的value赋给old属性
                entry.value = value; //已有的节点的元素替换成当前要添加的元素的value
                return old; //返回old ，此时的old和entry.value共享（应该），所以entry.value被替换时old也会被替换
            }
        }
        //如果上面的for循环的依次对比了数组内的链表内的每个节点都没有相同的，代表是个新的元素
        //比如现在要添加的key:9 value:9就是新的元素（没有其他相同的元素），所以可以添加
        addEntry(hash, key, value, index); //新的元素使用addEntry方法添加新的元素
        return null;
    }

        2.addEntry方法:该方法是void，所以没有return
        private void addEntry(int hash, K key, V value, int index) {
        Entry<?,?> tab[] = table;//将table赋给tab数组
        if (count >= threshold) { //执行：count目前是8。 ；判断目前的元素个数有没有超过临界值（注意：此时还没有完成添加元素这个步骤，现在是添加第九个，但是此时尚未完成添加，所以这里的count是8），这也是为什么有明明>=8就会扩容但是实际上8个元素了还没扩容，因为添加第八个的时候先判定到此时有7个元素然后不扩容，然后才添加第八个。此时添加第九个元素的时候count才等于8，所以现在才会扩容
            // Rehash the table if the threshold is exceeded
            rehash(); //看第三步...没有返回，因为是void方法（这个方法后就对数组进行扩容了）

            tab = table; //此时的table已经经过了扩容，将table赋给tab
            hash = key.hashCode(); //当前要添加的元素的hashcode赋给hash
            index = (hash & 0x7FFFFFFF) % tab.length; //通过hash和一些算法 计算出一个index属性用于判断当前要添加的元素应该放在数组的哪个索引值
        }

        // Creates the new entry.  正式开始添加数组
        @SuppressWarnings("unchecked")
        Entry<K,V> e = (Entry<K,V>) tab[index];  //（这里不太懂）将tab的index索引位置连接Entry类型的e对象，并且有向下转型？
        tab[index] = new Entry<>(hash, key, value, e); //此时tab的index索引位置下创建一个Entry类型的对象作为元素，传入各种属性
        count++; //对数组的元素个数更新
        modCount++;
    }



        3.当数组要扩容时，进入rehash()方法

        protected void rehash() {
        int oldCapacity = table.length; //把当前的table.length(11)赋给oldCapacity
        Entry<?,?>[] oldMap = table; //然后将table赋给oldMap

        // overflow-conscious code
        int newCapacity = (oldCapacity << 1) + 1; //(oldCapacity << 1) = 22 (相当于乘二，可以用电脑自带的计算机用programmer模式算出)，然后22+1 = 23赋给newCapacity（代表新的数组容量）
        if (newCapacity - MAX_ARRAY_SIZE > 0) { //不执行：  MAX_ARRAY_SIZE=2147483639（代表数组可以承受的最大元素个数），进入这个if语句的条件是newCapacity超过了MAX_ARRAY_SIZE。
            if (oldCapacity == MAX_ARRAY_SIZE) //如果旧数组已经是在数组的极限范围内，则直接return（退出该方法）
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE; //如果旧的数组容量不是极限，那么就把这次新的扩容数组更改成极限范围
        }
        //如果newCapacity不超过数组的承受范围，则继续执行以下代码
        Entry<?,?>[] newMap = new Entry<?,?>[newCapacity]; //创建一个新的Entry类型数组然后定义大小为newCapacity赋给Entry类型newMap数组

        modCount++;
        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1); //计算新的临界值，通过Math.min方法判断（newCapacity*loadFactor加载因子0.75）还是（数组的极限范围+1）这两个数值哪个小就选择哪个，如果是右边的小(数组的极限范围+1)，表示此时数组的元素个数已经到了数组的极限范围，为了防止继续扩容，所以把临界值改成超过数组范围（猜测）
        table = newMap; //将newMap赋给table，此时就更新了新的table数组数量（此时还没有添加第九个元素，只是在扩容数组罢了）

        for (int i = oldCapacity ; i-- > 0 ;) { //（猜测！）这个双重for循环应该是对整个数组进行遍历，并且修改里面的元素的链表关系
            for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
                Entry<K,V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = (Entry<K,V>)newMap[index];
                newMap[index] = e;
            }
        }
    }


         */
        System.out.println(hashtable.get(11));
    }
}
