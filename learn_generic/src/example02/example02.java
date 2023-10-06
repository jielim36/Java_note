package example02;

import java.util.ArrayList;
/*
generic泛型的声明：

interface 接口名<T> {...} 和 class类<K,V>{...} (注意：接口也能用)

说明：
1.T,K,V等不代表某个值，而是表示类型
2.任意字母都可以。常用T表示，因为T是Type的缩写


泛型的实例化：
要在类名后面指定类型参数的值，如：
1. List<String> strList = new ArrayList<String>();
2.Iterator<Customer> iterator = customers.iterator;



 */
public class example02 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        //解决example01的问题
        ArrayList<Dog> arrayList = new ArrayList<Dog>();//在创建ArrayList时使用泛型
        arrayList.add(new Dog("旺财",10));
        arrayList.add(new Dog("发财",4));
        arrayList.add(new Dog("财源",8));
//        arrayList.add(new Cat("招财猫",8)); 有泛型的情况下会报错（数据类型受到约束，编译器会报错，容易发现错误）


        //在遍历的时候，可以直接取出Dog类型,可以在增强for循环直接放Dog类型而不是Object类型（如果没有泛型的话会直接报错）
        //所以相当于直接省略了向下转型成Dog这个步骤
        for (Dog obj : arrayList){
            System.out.println(obj.getName() + "-" + obj.getAge());
        }


    }
}
class Dog{
    private String name;
    private int age;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
