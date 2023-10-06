package com.Equals;

public class equals02 {

    public static void main(String[] args) {

        //尝试自己写出一个对Object父类的equals方法进行重写


        Person person1 = new Person("lim yee jie" , 19 , 'M');
        Person person2 = new Person("lim yee jie" , 19 , 'M');
        Person person3 = new Person("jie" , 19 , 'M');

        System.out.println(person1.equals(person2));//true
        System.out.println(person1.equals(person3));//false

//t t t f t x
    }

}


class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //我创建这个equals重写方法的目的是为了判断两个Person对象的内容是否相同
    public boolean equals(Object obj){
        if(this == obj){ //如果传进来的对象是和this相同的（比如 person1.equals(person1） , 就可以确定是相同的内容，所以true
            return true;
        }
        if(obj instanceof Person){ //传进来的值如果是Person才做比较

            Person p = (Person)obj;//为了得到obj的Person特有成员，所以向下转型
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;

        }


        return false;
    }

}