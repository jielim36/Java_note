package Collection.example03_Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
Iterator接口：
Iterator接口是Collection接口的父类接口

Collection接口遍历元素方式1：使用Iterator（迭代器）
                第二种方式：使用增强for循环(example04)
基本介绍：
1.Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
2.所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象，即可以返回以恶搞迭代器
3.Iterator仅用于遍历集合，Iterator本身并不存放对象

Iterator接口的方法
1. hasNext() 判断下一个下标是否有元素的存在，如果有就返回true
2. next()  从集合的下标从无去到0，并且取出0下标的数据，重复使用多一次就下移至1下标并且取出1下标的数据
3. remove() 用的很少...
 */
public class example03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("从零开始的异世界生活","老吴",100));
        col.add(new Book("学Java从入门到入土","于爵",200));
        col.add(new Book("快乐大家","欣欣",120));
        col.add("hihi");

//        System.out.println(col);//普通输出

        //使用Iterator迭代器
        //先得到col对应的迭代器
        Iterator iterator = col.iterator();//iterator()方法底层是返回一个new Itr();
        /*
        irerator底层代码：返回一个Iterator对象
        public Iterator<E> iterator() {
            return new Itr();
        }
         */

        //使用快捷键 itit + tab 可以快速生成iterator 的while循环 （Ctrl + j 可以查看所有快捷键）
        while(iterator.hasNext()){ //hasNext方法会返回true or false
            //返回下一个元素，类型是Object，不是返回Book，因为ArrayList里可能不只是存放了Book类的对象，
            // 可能也有其他类型的数据，所以使用一个可以包罗万象的类型就是Object。
            // 当然，如果你确定全部元素都是Book类型可以不需要使用Object
            Object obj = iterator.next();//编译类型是Object ， 但是运行类型是每个元素可能都不一样的类型
            System.out.print(obj);
            System.out.println("   运行类型："+obj.getClass());//查看运行类型
        }
        //退出while循环后，这时iterator迭代器已经指向最后一个元素

        //iterator.next();//这时候如果再取一次数据的话会直接报异常
        /*
        Exception in thread "main" java.util.NoSuchElementException
	        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:970)
	        at xxxxxxxxxxx.main(example03.java:45)
         异常：NoSuchElementException ， 意思就是没有更多的元素了
         */

        //那么如果我们要重新遍历ArrayList该怎么办呢？
        //这时候需要重置我们迭代器的位置（因为第一次遍历已经让迭代器跑到ArrayList的最后一个元素了）
        //重置方法：
        iterator = col.iterator();
        System.out.println("\n==========================================\n重新遍历：");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }



    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}