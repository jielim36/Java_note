package Map.HashMap.example02;

import java.util.HashMap;

//源码解析
public class example02 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java",10);
        map.put("php",10);
        map.put("java",20);//替换第一个元素

        System.out.println(map);

        /*
        解析：关于HashMap的无参构造器

        public HashMap() {
            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted  //构造器里只是对加载因子进行初始化罢了，DEFAULT_LOAD_FACTOR = 0.75
        }

         */

        /*
        解析：关于还未使用put方法添加属性时...
        HashMap$Node table = null
        entrySet="[]"
        size = 0
        modCount = 0
        threshold=0
        loadFactor=0.75
        keySet=null
        values=null
         */

        /*
        执行put("java",10);方法

        1.进入put方法
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);  //调用并返回putVal方法，putVal的参数：使用hash(传入key)方法，该方法通过key来获得一个hash值， value：10  , onlyIfAbsent:false , evict:true
        }

        3.进入putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //执行这条语句，因为第一次添加元素，table现在没有任何元素，table==null
            n = (tab = resize()).length; //进入resize方法：看第四步：经过第四步后，resize返回容量为16的数组，然后使用.length()方法转换成长度赋给tab属性，然后在赋给n属性
        if ((p = tab[i = (n - 1) & hash]) == null)//通过之前计算得出的hash值转化成一个号码赋给i属性，该属性用于判断把新添加的元素放在tab数组的哪个索引位置上（系统算到在索引位置3，但我不知道详细计算过程），并且通过判断==null来分辨数组的i索引位置上是否有其他元素在，==null空的话表示可以进入此if语句直接添加元素进去数组，如果不等于null代表有其他元素就会去到else语句执行
            tab[i] = newNode(hash, key, value, null); //然后在tab数组的i属性索引上开始添加元素，通过newNode方法传入元素的相关参数并且通过该方法返回一个Node类对象，经过这个步骤，数组就成功添加了一个元素
        else { //不执行：已经执行了if语句
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
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
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount; //
        if (++size > threshold) //通过++size更新目前数组的最新元素个数 ，并且判断是否超过了临界值（12）
            resize(); //如果超过了，进入resize方法对数组进行扩容
        afterNodeInsertion(evict);
        return null; //return null就表示成功了
    }

      4.由于putVal方法的第一个if语句table==null里有调用resize方法：
        进入resize方法...

        final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table; //oldTab数组获得table数组
        int oldCap = (oldTab == null) ? 0 : oldTab.length; //判断oldTab数组是否等于空，是的话返回-，不是的话返回数组的长度（所以返回0），然后赋给oldCap(Capacity容量)
        int oldThr = threshold; //threshold临界值目前还是0，所以oldThr也是0
        int newCap, newThr = 0; //定义newCap 和 newThr = 0
        if (oldCap > 0) {//不执行，我们的oldCap目前是0
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold  //不执行，我们目前的oldThr是0
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults  //执行,如果执行这个else语句表示我们现在正在初始化数组大小和临界值
            newCap = DEFAULT_INITIAL_CAPACITY;   //newCap获得DEFAULT_INITIAL_CAPACITY（这个属性表示初始容量，该属性的值为16，也就代表我们的数组初始容量为16）
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); //newThr代表新的临界值，算法：DEFAULT_LOAD_FACTOR(0.75)*DEFAULT_INITIAL_CAPACITY(16)= 0.75*16 = 12
        }
        if (newThr == 0) {  //不执行：我们的newThr 是12
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;  //把newThr这个我们经过扩容数组后计算到的新临界值赋给threshold这个代表着目前临界值的属性
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];  //创建一个newTab表示一个计算后获取的新table，索引大小为newCap(16)
        table = newTab; //然后将刚创建号的newTab重新赋给我们的table，这个步骤之后table就已经完成扩容了
        if (oldTab != null) { //不执行，我们的oldTab == null
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab; //返回newTab
    }

         */

        /*
        解析：map.put("php",10);方法添加第二个元素进数组

        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //table已经不等于null了，因为有一个元素在table里
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null) //通过此元素的key值算出的hash值再通过算法转化成号码当作数组的索引赋给i属性，然后通过数组的i属性索引位置判断数组的该索引位置是否有其他元素，没有的话== null，则直接添加
            tab[i] = newNode(hash, key, value, null); //添加元素
        else { //不执行
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
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
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold) //++size更新目前数组的元素个数并且判断是否超过了临界值
            resize(); //如果超过临界值则扩容数组
        afterNodeInsertion(evict);
        return null; //返回null表示添加元素成功
    }

         */

        /*
        解析：使用put方法：map.put("java",20); ， 该方法传入的元素发现key值和第一次添加的元素相同，但是value值不相同

       1.进入put方法：
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true); //这里调用putVal方法前需要通过hash方法传入key值计算一个hash值，此时传入的key值："java"发现和第一次添加元素时的key值一样，所以计算出的hash值也一样
        }


       2.进入putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //不执行：此时table已经有两个元素
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null) //通过hash值计算的tab索引位置发现已经有一个元素了（第一次添加的那个元素），因为两个元素的key值都一样，所以索引位置也一样，数组的该索引位置已有一个元素就代表不等于null了，所以不执行该if语句（注意，计算出来的索引位置里已有的元素会赋给p属性）
            tab[i] = newNode(hash, key, value, null);
        else { //只能进入该else语句了
            Node<K,V> e; K k;
            if (p.hash == hash && //p是数组的索引位置已有的那个元素，然后判断双方元素的hash值是否相等
                ((k = p.key) == key || (key != null && key.equals(k))))    //会执行：把p.key赋给k属性后再判断是否与当前的元素的key相等，或者 判断当前添加的元素是否不等于null和判断双方元素的key调用equals方法时是否返回true
                e = p; //e获得p属性（数组的索引位置已有的那个元素）
            else if (p instanceof TreeNode) //不执行：已经执行上面的if语句了，这一句是判断数组的索引位置已有的元素是否是一个红黑树
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else { //不执行：已经执行上面的if语句了，这句的情况是：（HashSet有更详细解释）当前要添加的元素和数组的索引位置已有的元素索引位置相同（相当于hash值相同），但是使用equals方法时却是返回false，而且也不是红黑树，代表当前要增加的元素要放在另一个已有的元素后面形成链表
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {//如果当前要添加的元素与该链表的通过for循环对比每一个节点且都不相同直到去到链表的最后一个已经是null了就添加进去
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st //在链表添加元素后判断链表是否已经要超过8转换成红黑树了
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&  //和上面一开始一样，判断当前要添加的元素和链表的每个节点是否相同（这个if语句为什么不在上面的原因是一开始就已经对比过了该链表的第一个节点）
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e; //用于for循环的每次循环迭代，因为要用p.next去到下一个新节点用于对比双方
                }
            }
            if (e != null) { // existing mapping for key //执行：e是数组当前索引位置已有的元素
                V oldValue = e.value;  //oldValue属性获得e.value (数组的当前索引位置已有的元素的value：10)
                if (!onlyIfAbsent || oldValue == null)  //传入的onlyIfAbsent = false,但是感叹号取反后是true
                    e.value = value;  //将当前想要添加的元素的value:20 赋给（替换）e.value(数组的索引位置上已有的元素的value)，也就表示此时数组中索引位置的那个元素，保留它原有的key，但是它的value却变成了当前想要添加进数组的元素的value
                afterNodeAccess(e);
                return oldValue; //然后返回数组索引位置上已有的元素的value（已经变成了当前想要添加进数组的元素的value）
            }
        }
        //这里下面的全部都不执行了，因为上面已经return了
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
         */


    }
}
