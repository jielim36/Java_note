package example09_extend;

import java.util.ArrayList;
import java.util.List;

public class example09 {
    public static void main(String[] args) {

        //1.泛型没有继承性
        Object obj = new String("xx");//可以
//        List<Object> list = new ArrayList<String>(); //报错：两者必须一致

        //2. <?>支持任意泛型类型
        //3. <? extend A> 支持A类以及A类的子类，规定了泛型的上限
        //4. <> super A> 支持A类和A类的父类，不限于直接父类，规定了泛型的下线（指不能使用A类的子类）
        List<Object> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        List<A> list3 = new ArrayList();
        List<B> list4 = new ArrayList();
        List<C> list5 = new ArrayList();

        printCollection1(list1); //<?>啥都能放

//        <? extends A>
//        printCollection2(list1);报错 Object不是A的子类
//        printCollection2(list2);报错 String不是A的子类
        printCollection2(list3); //A类自己也可以
        printCollection2(list4); //B类是A的子类
        printCollection2(list5); //C是A的子类

        //<? super B>
        printCollection3(list1); //Object是B类的父类，可以通过
//        printCollection3(list2); 报错：String和B类没有关系
        printCollection3(list3); //A类是B类的父类
        printCollection3(list4); //B类自己也可以
//        printCollection3(list5); 报错：C类是B类的子类

    }

    public static void printCollection1(List<?> c){ //普通类的静态方法可以用泛型，因为类加载时不需要加载该泛型，只是我们在调用该方法时需要给指定泛型
        for (Object obj : c){
            System.out.println(obj);
        }
    }

    public static void printCollection2(List<? extends A> c){ //extend A 代表 A B C类都能用
        for (Object obj : c){
            System.out.println(obj);
        }
    }

    public static void printCollection3(List<? super B> c){ //super B 代表 A B类都能用 C不能
        for (Object obj : c){
            System.out.println(obj);
        }
    }
}

class A{}
class B extends A{}
class C extends B{}