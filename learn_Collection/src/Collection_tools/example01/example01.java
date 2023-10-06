package Collection_tools.example01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
Collections集合的一些工具类和方法
工具类：Collections  (Collections和Collection有区别，有s的是一个工具类)
这些方法都是static，可以直接调用
 */
public class example01 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add("111");
        arrayList.add("2");
        arrayList.add("ab");
        arrayList.add("4");
        System.out.println("默认："+arrayList);

        //reverse方法：反转List中元素的顺序
        Collections.reverse(arrayList);
        System.out.println("反转后："+arrayList);

        //shuffle(List):对List集合中的元素进行随机排序（洗牌）
        Collections.shuffle(arrayList);
        System.out.println("随机排序后："+arrayList);

        //sort(List) : 根据ASCII编码进行排序
        Collections.sort(arrayList);
        System.out.println("自然排序后："+arrayList);

        //sort(List, Comparator) 在sort方法使用两个参数的方法，然后第二个参数使用Comparator匿名内部类在里面写排序规则
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("自定义排序后："+arrayList);

        //swap(List,int i , int j)  ,将指定list集合中的i索引位置元素和j索引位置进行交换
        Collections.swap(arrayList,0,3); //如果j或i不在数组范围内，抛出异常IndexOutOfBoundException
        System.out.println("交换后：" + arrayList);

        //Collection.max(List) 获得自然排序时最大的元素(ASCII编码中最大的)
        System.out.println("获取自然排序中最大的元素："+Collections.max(arrayList));

        //Collection.max(List, Comparator) : 根据Comparator指定的顺序里最大的号码，返回给该方法
        System.out.println(".max方法：自定义排序后获取的元素："+ Collections.max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();//自定义排序规则更改成字符串长度，所以等下sout就会输出字符串长度最长的号码
            }
        }));

        //Collection.min(...) ,和max方法一样用法只是一个找最大一个找最小，可以直接参考max（其实最大最小这个用词不适合，可以理解成“赢家”，比如我在max方法自定义排序规则是返回字符串长度最小的，那么max返回的就是这个，如果是min就会返回字符串长度最短的输家也就是长度最长的字符串）
        System.out.println(".min方法：自定义排序后获取的元素："+ Collections.min(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();//自定义排序规则更改成字符串长度，所以等下sout就会输出字符串长度最长的号码
            }
        }));

        //Collection.frequency(Collection , o ) 返回指定集合中指定元素的出现次数
        System.out.println("2出现的次数："+ Collections.frequency(arrayList,"2"));//第二个参数写我们要找的元素

        //Collection.copy(dest , src) 将src中的内容复制到dest中 （dest指的是接收者 ， src指的是被复制者）
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) { //在复制前记得先对即将复制他人的那个数组填充大小直到和被复制的数组大小一样或超过（arrayList2的数组大小要比arrayList大）
            arrayList2.add("");                      //如果arrayList2没有添加元素，他的数组大小为0，复制时会抛出IndexOutOfBoundException
        }
        Collections.copy(arrayList2 , arrayList); //arrayList2 获得arrayList的值
        System.out.println("arrayList2: "+arrayList2);


        //Collection.replaceAll(Collection , Object oldValue , Object newValue)  ,对指定集合内的所有oldValue替换成newValue
        Collections.replaceAll(arrayList , "4" , "99");
        System.out.println("替换后："+arrayList);
    }
}
