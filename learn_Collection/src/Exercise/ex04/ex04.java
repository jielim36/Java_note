package Exercise.ex04;
//回答问题
/*
第一题：分析HashSet和TreeSet分别如何实现去重的
（注意：我的回答没有经过验证，请勿直接当作正确答案）
我的回答：HashSet是通过双方的key值来计算出一个hash值，
        然后在添加元素到数组时，通过计算出的值当作索引值放在数组的目标索引上
        然后这时需要判断数组的该索引位置是否为null，如果是null代表没有其他元素
        如果不是null，代表早有元素已经比当前元素早占据该位置
        这种情况下很大几率就是重复的元素，但是目前只是算到他们的hash值相同，还未完全确认为同一个元素
        这时系统会判断双方的hash值是否相等，双方调用equals方法（注意动态绑定机制调用哪里的equals方法）是否返回true
        如果都是true，那么就代表双方是同一个元素，如果是同一个元素就不进行修改

        TreeSet的去重机制是通过Comparator类的compare方法
        默认情况下compare方法是看key值的ASCII编码是否相同，如果相同代表是同一个元素
        如果不相同的情况下，也能利用这一点进行排序：因为TreeSet的源码是返回的结果正数和负数分别去到不同的地方，
        可以通过这个规则来进行排序，默认的compare方法的排序规则是ASCII编码，所以是abc这样的顺序
        另外：TreeSet有一个有参构造器是接收我们自己的Comparator类，我们可以用匿名内部类传入该类
        并且在该类下重写compare方法，可以利用这个重写compare修改系统对双方属性的去重机制判断和排序机制
        比如：return 元素1的字符串长度 - 元素2的字符串长度 可以排序机制变成：key值短到长
        同时也会更改去重机制的判断，变成如果双方相减后等于0，表示同一个对象，会去重
        比如元素1的key是aaa , 元素2是bbb，此时会进行去重处理。如果判断双方是同一个元素，会对元素的value值进行替换，新的元素value覆盖掉旧的元素value
        在TreeSet里由于程序员只能放入key，value是由系统分配的一个Object对象，作为占据的作用
        如果是TreeMap，该集合可以放key-value,此时的value就会被替代
        （官方答案补充：如果构造器没有传入Comparator匿名内部类，也就是无参构造器，
        则会以自己添加的对象实现的Comparable接口的compareTo方法去重，比如String有自己的重写compareTo方法）

第二题：在main方法上



 */


import java.util.TreeSet;

public class ex04 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        /*
        第二题：分析下面代码运行时会不会抛出异常，并从源码层面说明原因
         */
        TreeSet treeSet = new TreeSet();
        //treeSet.add(new Person());
        /*
        自己的答案：
        会，因为自己写的Person方法并没有实现Comparable接口，无法调用compareTo等方法.所以抛出异常：ClassCastException
         */

        //如果我添加一个自己写的类但是有去实现Comparable接口的话就能正常运行
        treeSet.add(new Person2());
        treeSet.add(new Person2());
        treeSet.add(new Person2());
        treeSet.add(new Person2());
        treeSet.add(new Person2());
        //TreeSet总共也只有一个元素，因为我的类里实现的compareTo方法只是return 0 ， 所以每个添加的元素都是return 0
        //代表系统判断去重机制时发现双方都是0所以判定成是同一个对象


    }
}
class Person{}
class Person2 implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}