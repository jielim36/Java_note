package example05_Details;

import java.util.ArrayList;
import java.util.List;

//Generic details
//1.给泛型指向数据类型时，要求是引用类型（Reference Data Type），不能是基本数据类型(Primitive Data Type)
//2.在指定泛型具体类型后，可以传入该类型或其子类类型
//3.泛型的使用形式，可以简写（左边的<>写类型，右边的<>可以只写尖括号内容省略）
//4.平时如果我们对一些需要使用泛型的类却没有使用时，会默认变成Object
//5.泛型方法，可以定义在普通类中（普通类：类名右边没有泛型），也可以定义在泛型类中 ,注意：需要辨别什么是泛型方法：如下...
//  泛型方法：public <E> void run(E e1, E e2){}    普通方法使用泛型属性：public void run(E e1, E e2){}
//  泛型方法自己定义的泛型标识符只能自己使用，同一个类下的其他地方都不能使用。类似于作用域/局部泛型标识符

public class example05 {
    public static void main(String[] args) {

        //1.给泛型指向数据类型时，要求是引用类型（Reference Data Type），不能是基本数据类型(Primitive Data Type)
        List<Integer> list = new ArrayList<Integer>();
//        List<int> list2 = new ArrayList<int>(); 直接报错，不能用基本数据类型

        //2.在指定泛型具体类型后，可以传入该类型或其子类类型
        Pig<A> pig = new Pig<A>(new A());  //创建了Pig类指定成A类型，所以放入A对象，于是Pig类内部的e属性变成了 : A e = new A();
        Pig<A> pig2 = new Pig<A>(new B());  //可以放入A的子类,于是Pig类内部的e属性变成了 : A e = new B(); (多态)
        System.out.println("pig的e属性运行类型：" + pig.getE().getClass());
        System.out.println("pig2的e属性运行类型：" + pig2.getE().getClass());


        //3.泛型的使用形式，可以简写
        ArrayList<String> arrayList = new ArrayList<>(); //运行类型部分的<>符号里可以不写，原因是编译器会进行类型的推断，我们第一个<>已经写了类型，第二个可以省略

        //4.平时如果我们对一些需要使用泛型的类却没有使用时，会默认变成Object
        ArrayList<String> arrayList1 = new ArrayList<>();//有写泛型
        ArrayList arrayList2 = new ArrayList();//ArrayList有要求需要写泛型，但是我们没有写，此时等价于：ArrayList<Object> arrayList2 = new ArrayList<Object>();

        //5.泛型方法
        normalClass test = new normalClass();
        test.run("宝马",99);//public <E> void run(E e1, E e2){...} 这里的run方法中的泛型属性是编译器自动识别我们当前输入的数据类型，所以现在该方法的E就是String


    }
}

class A{}
class B extends A{}

class Pig<E>{
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }
}

class normalClass{

    public <E,I> void run(E e1, I i2){ //泛型方法：可以在普通类中定义，不需要在泛型类，但该类的其他地方无法使用该泛型，猜测受到作用域的影响或者是局部泛型？
        //...                        //但是不能当作返回类型
        System.out.println(e1.getClass());
        System.out.println(i2.getClass());//输入整数时，会执行自动装箱变成Integer包装类
    }

//    public E fly (){}; 上面泛型方法定义的<E>只能用于该方法，类似于收到作用域的影响，所以在类名右边定义的泛型就可以给类的内部所有地方使用

}
