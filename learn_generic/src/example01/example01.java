package example01;

import java.util.ArrayList;

/*
generic -> 泛型

 */
public class example01 {
    public static void main(String[] args) {
        /*
        要求：
        在ArrayList中，添加三个Dog对象
        Dog对象含有name和age，并输出name和age（要求使用getXxx（））
         */
        //先看传统的方式
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财",10));
        arrayList.add(new Dog("发财",4));
        arrayList.add(new Dog("财源",8));
//        arrayList.add(new Cat("招财猫",8));此时没有报错，但是运行时会报错，所以不安全，很难发现

        for (Object obj : arrayList){
            //向下转型
            Dog dog = (Dog)obj;//但是这里Cat类型会报错，因为Cat不能向下转型成Cat
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
        /*
        使用传统方法的分析：
        1.不能对加入到集合中的ArrayList中的数据类型进行约束（不安全）
        2.遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响
         */

        //此时可以用泛型解决这个问题（example02）


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
