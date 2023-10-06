package Exercise.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
使用ArrayList完成对 对象Car（name，price）的各种操作
1.add
2.remove
3.contains //查找某个元素
4.size
5.isEmpty  判断Collection是否为空
6.clear
7.addAll
8.containsAll 查找多个元素
9.removeAll 删除多个元素
 */
public class ex2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car1 = new Car("BMW", 7090102);
        Car car2 = new Car("Lambo", 12000000);
        Car car3 = new Car("Proton", 120000);
        Car car4 = new Car("F1", 99999999);


        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);
        arrayList.add(car4);
        System.out.println(arrayList);

        arrayList.remove(car1);
        System.out.println(arrayList);


        System.out.println("Find BMW :"+arrayList.contains("BMW"));

        System.out.println("arraylist size："+arrayList.size());

        arrayList.clear();

        System.out.println("arrayLIst is empty?" + arrayList.isEmpty());

        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car1);
        arrayList2.add(car2);
        arrayList2.add(car3);
        arrayList2.add(car4);

        arrayList.addAll(arrayList2);

        System.out.println("element arraylist2 inside here? :"+arrayList.containsAll(arrayList2));

//        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);

        //遍历：
        System.out.println("\n\n增强for 遍历：");
        for (Object obj : arrayList){
            System.out.println(obj);
        }

        //第二种：iterator
        System.out.println("\n\nIterator 遍历：");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


    }
}

class Car{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\t Price:" + price;
    }
}