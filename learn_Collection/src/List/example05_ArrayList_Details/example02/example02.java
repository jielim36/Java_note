package List.example05_ArrayList_Details.example02;

import java.util.ArrayList;

/*
ArrayList的底层操作机制源码分析：
 */
public class example02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();


        //1.ArrayList中维护了一个Object类型的数组elementData。
        //private static final Object[] EMPTY_ELEMENTDATA = {};
        arrayList.add("haha");
        arrayList.add("hi");//每当我们对ArrayList添加元素（扩容）时，都会把数据存储在Object数组


        //2.当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0
            // 第一次添加后（从0个元素添加至一个元素时），则elementData容量为10，
            // 如需要再次扩容（10个元素后容量满了需要再次扩容），则扩容elementData为1.5倍（有10个元素就扩容至15容量，有15个元素就扩容至22个容量）


        //3.如果使用构造器参数int类型 ArrayList arrayList = new ArrayList(int类型);
        //该int类型数据用于指定初始ArrayList时的容量大小，如果需要扩容时，则直接扩容elementData为1.5倍
        //比如ArrayList arrayList = new ArrayList(8);，那么我们的初始容量为8，如果我们这时候有8个元素需要开始扩容则1.5倍，也就是扩容至12个容量


        //4. transient Object [] elementData； transient表示瞬间，短暂的，表示该属性不会被序列化（串行化），不能用于网络传输
        ArrayList test = new ArrayList();
        for (int i = 1; i < 25; i++) {
            test.add(i);
        }

    }
}
