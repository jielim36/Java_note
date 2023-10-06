package Collection.example05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
练习题：
1.创建3个Dog{name,age} 对象，放入到ArrayList中，付给List引用
2.用迭代器和增强for循环两种方式来遍历
3.重写Dog的toString方法，输出name和age
 */
public class example05 {
    public static void main(String[] args) {
        List dogList = new ArrayList();
        dogList.add(new Dog("小花",3));
        dogList.add(new Dog("大壮",1));
        dogList.add(new Dog("小猪佩奇",2));

        System.out.println("\n===Iterator迭代器==");
        Iterator iterator = dogList.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("\n===增强for循环===");
        for(Object next : dogList){
            System.out.println(next);
        }
    }
}
class Dog{
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}