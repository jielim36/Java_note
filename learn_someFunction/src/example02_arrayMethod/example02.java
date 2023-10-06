package example02_arrayMethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class example02 {
    public static void main(String[] args) {

        //Array.toString()方法：更简洁的遍历数组方法
        System.out.println("toString:");
        Integer [] integers = {1,20,90};
        int [] arr = {2,4,6};
        //传统的遍历方式
//        for (int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        //Arrays类的遍历方法
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(arr));


        //演示sort方法的使用
        /*
        sort默认排序方法须知：
        1.Arrays.sort(想要排序的数组名)就完成了
        2.因为数组是引用类型，所以即使没有进行任何赋值，直接调用该方法后，就会直接影响到数组本身
        3.该方法只能排序从小到大，如果要从大到小，需要使用定制排序
         */
        System.out.println("\n======================\nSort演示：");
        int [] arr2 = {1,-1,7,-8,9,0,99};
        //使用场景：当我们想要排序时，传统是使用冒泡排序,现在直接使用sort
        Arrays.sort(arr2);//因为数组是引用类型，所以通过sort排序后，会直接影响到本体(arr2)
        System.out.println(Arrays.toString(arr2));//这里直接输出arr2就已经是经过排序的了

        //sort定制排序
        /*
        使用须知：
        1. 数组的数据类型是包装类Integer等，而不是使用基本数据类型int
        2.sort重载方法，可以通过传入一个Comparator接口实现定制排序
        3.调用定制排序时，传入两个参数 1，排序的数组  2.实现了Comparator的匿名内部类，该内部类要求实现compare方法
        4.注意：此案例实现compare方法时，因为没有学到”泛型“，所以使用了较为繁琐的方式（有向下转型），之后会优化
         */
        System.out.println("\n======================\nSort定制排序 演示：");
        Integer [] arr3 = {2,-4,5,7,-8,99};//使用定制排序时，我们的数组不能是普通的基本数据类型，要使用包装类Integer之类的
        Arrays.sort(arr3,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i2-i1;
                /*
                从大到小排序：i2-i1  (o2 - o1)
                从小到大排序：i1-i2
                 */
            }
        });
        System.out.println(Arrays.toString(arr3));
        /*
        定制排序的源代码分析：
        1.Arrays.sort(arr3,new Comparator(){...})
        2.经过一系列代码后，会去到一个很重要的地方：TimSort类的static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c,
                         T[] work, int workBase, int workLen) {..}
        3.看不懂源码了。。。
        4.example03 Arrays模拟排序
         */



        /*
        binarySearch 二分搜索法
        1.通过该方法进行查找某个值时，要求必须排好序(只能升序（小到大，不能大到小）)
        2.找到目标值就返回数组的下标位置
        3.如果找不到就返回该数组排序（小到大）后，从数组里“假设”如果有我们的目标值，会在什么位置就返回那个位置（返回的号码是数组的下标+1）
          比如：一个排好升序的数组：[-1, 2, 3, 5, 9]，目标是找到1， 但是数组没有，就找到适合放入该目标的地方也就是-1的右边，2的左边，然后假设放进去后，判断该目标在什么位置，返回该位置+1，也就是2（没有+1的话在该数组的下标1），然后变成负数
          源代码：return -(low + 1); ,low就是假设插入找不到的目标后，该目标的数组下标
         */
        System.out.println("\n=============\nBinary Search:");
        Integer [] arr4 = {9,3,5,-1,2};
//        Arrays.sort(arr4);小到大也可以
        Arrays.sort(arr4,new Comparator(){ //查找前必须先排序
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;

                return i1-i2;
            }
        });
        System.out.println(Arrays.toString(arr4));
        int index = Arrays.binarySearch(arr4,5);//第二个参数是我们要查找的值，会返回该值的数组下标（位置）
        int index2 = Arrays.binarySearch(arr4,1);
        System.out.println("Index Location: " + index);//返回数组的下标
        System.out.println("Index2 Location: " + index2);//如果找不到就返回该数组排序（小到大）后，从数组里“假设”如果有我们的目标值，会在什么位置就返回那个位置（返回的号码是数组的下标+1），然后变成负数


        //copyOf 数组元素的复制（不是复制地址）
        /*
        1.从数组中，拷贝arr.length个元素到新的数组
        2.如果新数组的长度比复制的数组长，多出来的元素是null或者0（根据数组的数据类型,包装类的都是null（Integer））
        3.如果复制时的数组长度小于0就会报错
         */
        System.out.println("\n=============\nCopy Array:");
        int [] arr5 = {9,4,6,1};
        int [] arr6 = Arrays.copyOf(arr5,arr5.length);
        System.out.println(Arrays.toString(arr6));

        int [] arr7 = Arrays.copyOf(arr5,arr5.length-1);//可以控制想要复制到第几个元素
        System.out.println(Arrays.toString(arr7));

        int [] arr8 = Arrays.copyOf(arr5,arr5.length+1);//如果想要比新的数组更长的长度，多出来的元素是null或者0（根据数组的数据类型,包装类的都是null（Integer））
        System.out.println(Arrays.toString(arr8));

        String [] arr9 = {"lee","lim","lo"};
        String [] arr10 = Arrays.copyOf(arr9,arr9.length+2);//String的空是null
        System.out.println(Arrays.toString(arr10));//[lee, lim, lo, null, null]

        Integer [] arr11 = {2,5,1,5};
        Integer [] arr12 = Arrays.copyOf(arr11,arr11.length+2);//Integer包装类的空也是null而不是0
        System.out.println(Arrays.toString(arr12));//[2, 5, 1, 5, null, null]


        //fill 数组元素的填充(替换)
        /*
            对该数组内所有的元素都更改成指定的值，包括已有值的元素也会被覆盖
            使用场景：初始化某个数组时，创建一个指定长度的数组后使用该方法对该数组的所有元素都填充一个值
         */
        System.out.println("\n===========\nFill array:");
        Integer[] arr13 = {9,3,2};
        Arrays.fill(arr13,99);
        System.out.println(Arrays.toString(arr13));//[99, 99, 99]

        //equals 比较两个数组的元素内容是否完全一直
        /*
        注意事项：
        1.使用的是Arrays类的equals重写方法
        2.需要注意两个数组的顺序
         */
        System.out.println("\n==========\nequals : ");
        int [] arr14 = {1,2,3};
        int [] arr15 = {1,2,3};
        int [] arr16 = {3,2,1};//顺序不一样返回false
        System.out.println(Arrays.equals(arr14,arr15));//true
        System.out.println(Arrays.equals(arr14,arr16));//false


        //asList 将一组值 传换成List
        System.out.println("\n===========\nasList : ");
        List list1 = Arrays.asList(2,3,4,5,6);
        System.out.println("asList:" + list1);
        System.out.println(list1.getClass());//查看运行类型
        /*
        1.List是一个接口
        2.list1对象的编译类型是List，运行类型是class java.util.Arrays$ArrayList
         -$ArrayList是Arrays里的一个内部类(可以看example02里的Arrays_diagram里有举出Arrays类里的所有内部类)
        3.private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable {...}
         -可以发现该内部类是一个静态内部类
         */

    }
}
