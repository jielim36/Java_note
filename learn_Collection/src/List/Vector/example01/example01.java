package List.Vector.example01;

import java.util.Vector;

/*
Vector基本说明
1.Vector是List接口的实现类
2.继承了AbstractList
3.Vector的底层也是一个对象数组: protected Object[] elementData;
4.Vector和ArrayList几乎一样，
5.但是Vector是线程同步的(ArrayList不是)，即线程安全，因为Vector类的操作方法带有synchronized关键字修饰
6.


Vector和ArrayList的比较

名称          底层结构     版本         线程安全（同步）和效率         扩容倍数
ArrayList    可变数组     jdk1.2        线程不安全，但效率高          如果是有参构造器（指定大小）1.5倍；如果无参第一次初始+10容量，第二次满容量开始按1.5倍扩容
List.Vector       可变数组     jdk1.0        线程安全，效率不高            如果是无参，默认10，满后，就按2倍扩容；如果指定大小，则每次按两倍扩容


 */
public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Vector vector = new Vector();
        for (int i = 1 ; i < 23 ; i++){
            vector.add(i);
        }
    }
}
