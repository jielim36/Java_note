package com.Type_Polymorphic.type1;

public class main {

    public static void main(String[] args) {
        //Type 1 : 向上转型 ： 左边父类编译类型， 右边子类运行类型
/*
本质： 父类的引用指向了子类的对象
2.语法： Animal animal = new Cat();
特点： 编译类型看左边， 运行类型看右边。
可以调用父类中的所有成员（需要遵守访问权限）
不能调用子类中特有的成员（父类没有，子类有的成员） ： 在编译阶段， 能调用那些成员是由编译类型决定的
最终的运行效果看子类的具体实现！： 即调用方法时，按照从子类（运行类型）开始查找方法，如果有就调用，没有就继续往上（父类）寻找方法（和之前的方法调用规则一致）


*/
        Animal animal_test = new Cat("HUaHUa");
        Object obj = new Cat("HaHa");

        animal_test.num1 = 1;
        animal_test.num2 = 2;
        animal_test.num3 = 3;
//        animal_test.num4 = 4; --> num4 是子类的特有成员， 无法调用
//        animal_test.onlyCat();  --> 这个method也是只有在子类有，所以无法调用
        animal_test.onlyAnimal(); //--> 这个method只有父类有，但是子类没有，但是还是可以调用


        //向下转型

        //语法： 子类类型 引用名 = （子类类型）父类引用
        //当向下转型后，可以调用子类类型的中的所有成员
        //要求父类的引用必须指向的是当前目标类型的对象
        //Cat cat = (cat)animal_test; -> 这个是对的，因为animal_test其实就是指向Cat的(Animal animal_test = new Cat(); )
        //Dog dog = (dog)animal_test; -> 这个是错的，因为animal_test是指向Cat的，所以现在不能把他强转换成Dog
            //个人理解： 其实就是让之前创建的对象（animal_test，实际上是父类的引用，但是他原先就有指向Cat类（子类）），
            // 但是无法使用子类特有的成员，所以我们创建一个cat然后同时指向animal_test的“空间”，
            // 然后再对animal_test进行强转换，这时就可以调用cat的特有成员成员
            //所以这时Cat对象就有两个引用，一个是父类的引用(animal_test) 和 子类的引用(cat)

        System.out.println("\n向下转型");
        Cat cat = (Cat)animal_test;//这里把animal_test对象进行强转换
        System.out.println(cat.num4); //把animal_test强转换成Cat之后就可以访问Cat中特有的属性（也能访问父类）



    }

}
