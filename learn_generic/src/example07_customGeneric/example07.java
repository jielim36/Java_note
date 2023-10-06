package example07_customGeneric;
/*
custom generic - 自定义泛型
指自己写一个类或接口，然后定义一些泛型

细节：
1.普通成员可以使用泛型（属性，方法）
2.使用泛型的数组，不能初始化
3.静态方法中不饿能使用类的泛型
4.泛型类的类型，是在创建对象时确定的，（因为创建对象时，需要指定确定类型）
5.如果在创建对象时，没有指定类型，则默认为Object
6.一个类的泛型可以有多个，比如class Tiger<T,G,R> 该类有三个泛型标识符
 */
public class example07 {
    public static void main(String[] args) {
    }
}

class Tiger<T,G,R>{ //这个Tiger类有泛型，这种类我们都称作为 自定义泛型类
    String name;
    T t; //属性使用泛型
    G g;
    R r;
    T [] array1; //数组可以用泛型
//    T [] array2 = new T[8]; //但是不能初始化（不能直接new），因为new了代表就要开辟空间了，可是数组还不知道自己什么数据类型

    public Tiger(String name, T t, G g, R r) { //构造器使用泛型
        this.name = name;
        this.t = t;
        this.g = g;
        this.r = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() { //方法也可以使用泛型，返回类型和参数等都接受
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public G getG() {
        return g;
    }

    public void setG(G g) {
        this.g = g;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

//    static R test;    static成员不能使用泛型，原因是类加载时static成员也会直接加载，但是此时他们还没有接收数据类型（在类加载时，对象还没创建）
//    public static void method(T t){}      所以，如果静态成员使用了泛型，JVM就无法完成初始化
}

/*



 */