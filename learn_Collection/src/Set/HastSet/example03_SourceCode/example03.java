package Set.HastSet.example03_SourceCode;

import java.util.HashSet;

//源码解析
public class example03 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        /*
        HashSet的底层机制说明：

        1.HashSet底层是一个HashMap
        2.当添加一个元素时，先得到元素的hash值，然后转换为索引值（然后通过该索引值判断应该放入数组table的哪个索引上）
        3.如果存储数据表table，看这个索引的位置是否已经存放其他元素
        4.如果没有，则直接加入
        5.如果有，对比双方的hash值后，再调用equals对双方比较，如果相同（返回true），就放弃添加（因为不接受放入同样的元素），
          注意：equals方法取决于我们的元素是什么数据类型（String还是自己写的类的实例化对象）
          涉及到动态绑定机制：根据该要素的数据类型，看该类是否有重写equals方法，比如以下例子：
          存放new String类型时不同的对象但同样的字符串内容时使用equals方法会返回true，
          因为String类的重写equals方法是对比两个String对象的内容。
          但是使用StringBuffer时，不同的对象相同的字符串可以放入，
          因为StringBuffer类没有重写equals方法，所以使用的是Object类原本的对比双方地址的equals方法
          所以判断不同类型但相同的值是否能放入HashSet时，应该去看该数据类型的equals方法是判断双方的内存地址还是判断双方的内容

       6.如果equals方法返回false=不相同，则会在table数组目标索引已有的元素后面添加该元素，也就形成了一个链表
       7.HashSet的底层是HashMap，第一次添加时，table的数组扩容到16(默认)，临界点(threshold)是16*加载因子（loadFactory）是0.75 = 6*0.75 = 临界点12
       8.如果table数组的长度到达了临界值12，就会扩容到数组的长度*2，也就是扩容到32大小。然后再重新计算临界点准备下一次扩容的时机:32*0.75=临界点24.接下来的每一次扩容都以此类推...

       9.在Java8中，如果一条链表的元素个数”到达“（不是超过）TREEIFY_THRESHOLD(默认是8)，
         并且table数组的大小>= MIN_THREEIFY_CAPACITY(默认64)，就会进行树化（红黑树）
         如果链表已经到达8个元素个数，但是数组还没到64个时，会进行数组扩容。



         */
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println(hashSet);
        /*
        解析：使用add方法添加一个元素时系统的运作过程
        1. HashSet hashSet = new HashSet(); 运行时进入到无参构造器：
        public HashSet() {
            map = new HashMap<>(); //调用HashMap方法让map变成一个HashMap对象（应该？
        }

        2.hashSet.add("java");  调用add方法准备添加元素，源码：
        public boolean add(E e) {  //这里的e是我们准备添加的字符串内容"java"
            return map.put(e, PRESENT)==null; //调用map.put(e,PRESENT) ， PRESENT是HashSet类里的静态属性：private static final Object PRESENT = new Object();
        }                                     //（这里的理解不好...）这个PRESENT没有太大的实际用处，是用于占位的，注意：不管指向多少次add，e的值一直在变化，但是PRESENT都不会有变化

        3.map对象的put方法源码：
        public V put(K key, V value) { //key = "java" ，value =
            return putVal(hash(key), key, value, false, true);  //这里调用了putVal()方法，该方法的参数又调用了hash(key)方法，这个hash方法不能f7进入，可以用force into或者ctrl+b进入
        }

        4.hash（key）方法: key是我们添加的元素"java"
        static final int hash(Object key) {  //key = "java"
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //我们的key是"java"不是null，所以执行(h = key.hashCode()) ^ (h >>> 16)，这个语句是系统计算并生成的一个hash值（并不等价于hash code）,然后返回
        }



        5.执行完hash（key）后，将返回的数据传入putVal(hash(key), key, value, false, true);方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,  //hash = 3254803(hash(key)方法返回的数值) ， onlyIfAbsent = false  , evict = true
                   boolean evict) {                                     //key = "java"  , value = PRESENT，它是HashSet类里的静态属性：private static final Object PRESENT = new Object();
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //这里的tab = table，table是HashMap中存放Node和节点的数组（可以参考example02模拟的table数组）Node是HashMap的一个内部类，解释：该语句判断我们的table是否是null“或者”判断table的长度是否为0，通常第一次添加元素的时候会达成条件
            n = (tab = resize()).length; //tab通过resize()方法获得一个值然后.length获得长度赋给n （resize（）方法看第5步），结果：resize（）方法返回了一个newTab大小为16的数组,然后n获得了newTab.length所以n = 16
        if ((p = tab[i = (n - 1) & hash]) == null) //将会执行：这行代码会根据key("java")得到的hash去计算该key应该存放到table表的哪个索引位置（ 如果p为null，表示还没有存放元素，就创建一个Node）
            tab[i] = newNode(hash, key, value, null);  //tab[i的索引位置：3] 指向了 newNode(hash,key,value,null) ,hash="java"计算得出的hash值，之后其他元素要加入时也能判断双方的hash值是否相等 ； key = "java" , value = PRESENT ; null是该元素的.next = null 表示它的右边没有指向任何元素（建议看example03模拟底层结构）
        else {//已经执行if了，else不执行，直接跳到modCount++;
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
                return oldValue; //return oldValue代表添加失败
            }
        }
        ++modCount; //modCount从0变1
        if (++size > threshold) //这里的size从0变1 ， 并且判断是否大于临界点了（resize()方法有更新我们的临界点至12），所以1 > 12，不执行
            resize();
        afterNodeInsertion(evict); //调用这个方法时传进来的evict=true...  ; 对于HashMap方法而言，该方法是个空方法,主要是让HashMap的子类LinkedHashMap之类的去做一些动作
        return null; //返回空代表添加元素成功了，如果不成功是返回该行的上面几行有一个return oldValue的，那个是添加失败。
                     //返回空 给 第三步的put方法，然后put方法再返回给第二步的add方法，然后add方法返回return map.put(e, PRESENT)==null; ，我们返回的就是null，所以add方法的==null会返回true，然后就回到main方法了（如果用sout来调用add方法也能输出true或者false）
    }



    5.（第四步的代码中间调用的resize（）方法）
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table; //将table的值赋给oldTab ， table的值因为我们第一次添加元素，所以还是null
        int oldCap = (oldTab == null) ? 0 : oldTab.length; //oldTab == null，所以返回0，且赋给oldCap
        int oldThr = threshold; //threshold默认是0，所以oldThr也是0
        int newCap, newThr = 0; //newThr = 0
        if (oldCap > 0) {  //不执行
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold //不执行
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults  //只能执行这个了
            newCap = DEFAULT_INITIAL_CAPACITY;  //这里newCap是判断我们的数组要开辟多大的空间，newCap = DEFAULT_INITIAL_CAPACITY（默认是16）
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); //这里的newThr是一个临界值，计算newThr = (int)(0.75 * 16) = 12（临界值），作用：我们的数组现在有16个元素大小，但是java开发人员希望数组的扩容机制是数组的现有的大小的0.75倍（也就是12）时，就提前扩容数组的大小，以防同时间有多个数据进入造成一些错误
        }
        if (newThr == 0) { //不执行
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;//把newThr（计算出来的新临界值）赋给threshold
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];//关键点：这里创建了一个新的tab用于更新我们的table，使用Node类型创建了一个newTab数组，并且数组的大小为newCap(也就是我们上面计算出来的16)
        table = newTab;//然后将table指向最新的Tab，也就完成了一个table从null到变成一个16大小的数组
        if (oldTab != null) { //不执行
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
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        解析：hashSet.add("php"); ， 解析关于对HashSet添加第二个元素的系统运行过程源代码：

        1.hashSet.add("php"); main方法使用add方法添加属性：
        public boolean add(E e) { //e = "php"
            return map.put(e, PRESENT)==null; //调用put方法
        }

        2.put方法
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true); //获得"php"这个key的hash值然后传到putVal方法
        }

        3.putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,  //hash = "php"的hash值，key = "php"
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //不执行这句，因为table此时已经有"java"了
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null) ////将会执行：这行代码会根据key("php")得到的hash去计算该key应该存放到table表的哪个索引位置（ 如果p为null，表示还没有存放元素，就创建一个Node）
            tab[i] = newNode(hash, key, value, null); //在tab的目标索引位置放入"php"并且对该节点设置了hash值，key="php"内容,null是该节点的.next = null表示该节点的链表右边没有其他节点
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
        ++modCount; //这里继续执行
        if (++size > threshold) //判断是否触及临界点
            resize();
        afterNodeInsertion(evict);
        return null; //return null ， 表示添加元素成功
        }

         */

        /*
       \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
       hashSet.add("java");
       解析：关于添加第三个元素"java" , 但是该HashSet对象已经有了一个"java" , 分析系统的运行过程源代码：
       这里直接跳到最重要的方法部分：

       final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) //此时table已经有两个元素了，"java"和"php"
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null) //系统把现在要添加的"java"元素转换成hash值后在判断放在哪个索引时发现该索引已经不是null了（代表已经有添加过"java"元素了，索引是通过hash值算出来的，如果两次要添加进HashSet的节点内容都相同代表hash值也相同，也代表会进入一样的索引。（只要内容相同hash值就一点相同，但是不代表是相同的对象），所以这里不执行
            tab[i] = newNode(hash, key, value, null);
        else { //上面的if语句不通过表示只能执行这个else语句了
            Node<K,V> e; K k; //一个开发技巧：在什么地方需要这个局部变量，就在什么地方创建，不要全部变量都定义在最上面
            //下面这两行代码组成的if语句的目的是判断双方是否是相同的对象，需要同时达成第一行和第二行条件才能进入。。。第一行代码判断了双方的hash值是否相同，然后第二行代码是两个条件达成其一(or)就返回true，第二行代码对比了双方的内容是否一致 “或者“ 双方使用equals方法（涉及动态绑定机制，比如该元素使用Object还是String的equals方法）时是否返回true  ，第一行代码必须true，第二行代码达成其一的代码就能执行该if语句
            (注意一个性能优化的地方，先使用判断双方的hash值是否相同，如果相同才继续使用equals方法判断，这个行为可以防止优先使用equals方法判断会造成许多资源的浪费，使用较为节省资源的判断双方hash值来作为第一关，通关过后再使用较为消耗资源的equals方法)
            if (p.hash == hash &&  成功执行该if语句...     //p.hash的p是在上面(p = tab[i = (n - 1) & hash])条件语句中进行赋值的，所以(p = tab[索引] )p获得了tab[索引]的第一个节点，也就是说：获得了旧的"java"元素，因为其实那个索引是通过当前想要添加的"java"元素的hash值得到的，但是在那个索引上已经有其他节点了，所以p获得tab[索引]时，还是获得第一个节点"java"。所以此时对比的就是 旧的"java".hash == hash(现在的"java".hash)
                ((k = p.key) == key || (key != null && key.equals(k))))      //条件一：k获得p.key(已经在当前索引的元素/节点的内容)）表示-> 当前索引已有的节点内容== key（当前要添加的节点内容），判断是否一致，“或者or”  条件二：当前想要添加的节点不是null且双方通过equals方法对比（注意元素的数据类型影响使用那个equals，比如String类有重写equals方法用于对比内容，自己写的类没重写equals则使用Object类的equals，判断双方的内存地址）
                e = p; //如果这个if语句通过代表双方是同一个对象，把p（当前索引的节点） 赋给e
            else if (p instanceof TreeNode) //不执行：判断p（当前索引位置的节点）是不是红黑树
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);//如果是,则通过putTreeVal方法添加元素
            else { //不执行：如果双方不是同一个对象，且p不是红黑树，则执行这个语句，该语句是判断新添加的元素是否和当前索引的节点后面（右边）的其他节点是否相同

            //这里for死循环的思路是有两个if语句，第一个语句确认当前索引位置的节点的next是否为空，如果为空，则添加当前元素。如果不为空，则去到第二个if语句判断p.next是否和当前元素相同，如果相同，直接结束循环
                for (int binCount = 0; ; ++binCount) { //因为当前索引的节点后面可能有许多其他节点，所以使用循环一个一个对比
                    if ((e = p.next) == null) { // e 获得 p(当前索引的节点，每次循环都会去到下一个节点) ， 然后对比下一个节点是否为空，如果是空则执行
                        p.next = newNode(hash, key, value, null); //把当前要添加的元素添加在当前索引节点的最后一个节点（因为p.next空时才进入的）
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st //TREEIFY_THRESHOLD=8，该属性是链表个数到达8时转化成红黑树的要求，通过for循环定义binCount表示正在遍历第几个节点，如果某次循环时进入此if语句则会判断目前在第几个节点，如果在第八个则代表需要转换成红黑树了（注意：TREEIFY_THRESHOLD -1的目的是因为binCount从0开始，如果不减1就表示链表到第九个时才转化成红黑树）
                            treeifyBin(tab, hash); //这个方法代表判断是否要把一个8个元素的链表转化成红黑树，因为还要考虑数组是否到达64个数临界点
                        break;
                    }
                    if (e.hash == hash &&   //判断双方是否相同：如果e(p:当前索引的节点).hash 和 当前要添加的元素的hash值相同，且 对比双方的key（内容） 或者 双方使用equals方法对比时返回true时，就代表双方的节点是一致的
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break; //退出循环
                    p = e;  //p获得e ：目的是为了每次循环都可以让第一条if语句重新获得p（当前索引的节点），算是一个迭代，每次循环就前进一个节点，可以达成遍历
                }
            }
            if (e != null) { // existing mapping for key //这里会执行：我们第一条判断双方是否相同时就直接执行了，然后里面有将p（当前索引位置的节点也就是旧的"java"赋给了e ） 所以这里的e不是null，返回true，执行语句
                V oldValue = e.value;  //e.value就是PRESENT(一个Object类对象)，赋给了oldValue
                if (!onlyIfAbsent || oldValue == null) //onlyIfAbsent原本传入进来是false，！符号取反后变true，执行该语句
                    e.value = value; //不知道干嘛的
                afterNodeAccess(e);
                return oldValue;//返回oldValue 也就是返回Object，没啥用，反正调用该putVal方法的方法只有返回null时才算添加成功，这里返回Object就算是添加元素失败了
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }


         */


        /*
        解析源代码：关于判断HashSet的链表是否需要转化为红黑树的方法源代码：

        在add方法里有一个调用treeifyBin方法的if语句
        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
              treeifyBin(tab, hash);

        去到该方法判断是否真的需要转化为红黑树：进入到该方法也就意味着链表已经有八个或以上了（提示：转化为红黑树的条件：链表个数到达8，数组的长度超过64）
        final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)  //这里tab是否是null或者数组的长度小于到达64，这里的n代表数组的长度，然后判断数组长度是否小于MIN_TREEIFY_CAPACITY(64)
            resize(); //如果上面条件成立，表示链表已经到达8个了，但是数组还没有超过64，所以先进行扩容，并没有直接将链表转化为红黑树

        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }
         */



    }
}
