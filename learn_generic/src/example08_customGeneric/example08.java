package example08_customGeneric;
//about generic interface
/*
Generic Interface Details:
1.In interface, static member cant use generic(the rule same with generic class)
2.Generic Interface Type judgment when extend another interface or implement class; 泛型接口的类型在继承接口或实现接口时确定
3.If didn't write the type,then the default type is Object type; 如果没有指定类型，默认为Object
 */
public class example08 {
    public static void main(String[] args) {

    }
}

interface Dog<E,T>{
    E get(T t);
    void hi(E e);
    void run(T t1, T t2 ,E e1,E e2);

//    E name; 接口中的属性都是static的，（接口的成员都是 public static final 修饰的），但是接口的方法是默认抽象abstract的

}

class Animal implements Dog<String,Integer>{

    @Override
    public String get(Integer integer) {
        return null;
    }

    @Override
    public void hi(String s) {

    }

    @Override
    public void run(Integer t1, Integer t2, String e1, String e2) {

    }
}

interface IA extends Dog<String,Double>{ //接口继承
}

class AA implements IA{ //实现了IA接口继承的Dog接口的所有抽象方法后，都会在原本泛型的位置自动填入对应的数据类型

    @Override
    public String get(Double aDouble) {
        return null;
    }

    @Override
    public void hi(String s) {

    }

    @Override
    public void run(Double t1, Double t2, String e1, String e2) {

    }
}