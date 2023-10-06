package example03;

import java.util.ArrayList;

/*
generic的基本介绍:

generic泛型-> 泛（广泛）型（类型）
1.泛型又称参数化类型，是jdk5.0出现的新特性，解决数据类型的安全性问题
2.在类声明方法或实例化时只要指定好需要的具体的类型即可。
3.Java泛型可以保证如果程序在编译时没有发生警告，运行时就不会产生ClassCastException异常。同时代码更简洁，健壮
4.泛型的作用是：可以在类声明时通过一个标识表示类中的某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。


 */
public class example03 {
    public static void main(String[] args) {

        Person<String> person1 = new Person<String>("Jie");//这时我们定义Person类的对象时，就可以在<>内写入我们要的数据类型
        System.out.println(person1.getName().getClass());//class java.lang.String  ，可以发现我们的该方法返回类型确实是String

        /*
        所以传入了String之后，Person类的内部相当于...

        String name;//E变成String了

        public Person(String name) { //参数的E变成String
            this.name = name;
        }

        public String getName(){ //方法的返回类型E变成String
            return name;
        }

         */


//        以下代码会报错，因为我们把Person改成String类型后，我们的IDE编译器就会自动识别我们输入的数据是否和输入的generic泛型一致，现在我泛型定义成String，但是我输入int数据，就会报错
//        Person<String> person2 = new Person<String>(12);


    }
}
//泛型作用：可以在类声明时通过一个标识表示类中的某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
class Person<E>{  //Person旁边添加了一个<E>标识，当外部定义Person类对象时，可以自定义传入一个类型，然后该类中的有关属性也会随之改变（在编译期间就已经确认E是什么类型，所以有错误会直接红字报错）

    E name; //(属性)name的数据类型根据外部传入什么类型给<E>

    public Person(E name) { //参数
        this.name = name;
    }

    public E getName(){ //方法的返回类型
        return name;
    }
}