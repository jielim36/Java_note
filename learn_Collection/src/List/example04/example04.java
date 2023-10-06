package List.example04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
练习题：
使用List的实现类添加三本图书，并且遍历

按价格排序，从低到高（冒泡排序）
要求使用ArrayList ，List.LinkedList 和 List.Vector 三种集合实现
 */
public class example04 {
    public static void main(String[] args) {

        //要求使用ArrayList ，List.LinkedList 和 List.Vector 三种集合实现
        List list = new Vector();//这里的运行类型题目要求的三种集合都能运行
        list.add(new Book("Java零基础",300,"韩顺平"));
        list.add(new Book("科幻小说",100,"HoHO"));
        list.add(new Book("玄幻小说",200,"会说话的肘子"));
        list.add(new Book("小学作文",50,"某小学生"));
        list.add(new Book("大学论文",70,"某大学生"));

        bubble(list);

        System.out.println("\n======================\n");
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void bubble(List list){
        for (int j = 0 ; j < list.size()-1 ; j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                Book book1 = (Book) list.get(i);
                Book book2 = (Book) list.get(i + 1);
                if (book1.price > book2.price) {
                    list.set(i + 1, book1);
                    list.set(i, book2);
                }
            }
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
class Book{
    String name;
    double price;
    String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "书名："+name +"\t\t价格：" + price + "\t\t作者："+author;
    }
}
