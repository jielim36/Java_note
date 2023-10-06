package example10;
/*
演示多态传递
 */
public class example10 {
    public static void main(String[] args) {
        B obj = new teacher();
//        A obj2 = new teacher(); 报错，因为teacher没有实现implement接口A

        C obj2 = new student();
        D obj3 = new student();//当接口C和D是继承关系时，然后student实现了子类接口，然后父类接口和子类接口都可以对student进行实例化对象
//        C obj4 = new person(); 报错，因为person实现了C的父类 接口D，这个情况下C不能对person进行实例化对象

        //原理: 当一个类实现了子类接口，就代表他也必须实现了父类接口，所以他可以依靠父类接口实例化对象
        //     而当一个类实现了父类接口，该类不需要实现子类接口，所以他在实例化时如果使用子类接口就会报错

    }
}

interface A{ }
interface B{}

interface C extends D{
    void say();
}

interface D{
    void exit();
}

class teacher implements B{ }

class student implements C{ //当student implement 子类接口时，也要同时实现该接口的父类
    @Override
    public void say() { //C接口的抽象方法

    }

    @Override
    public void exit() { //C接口 的父类接口D 的抽象方法

    }
}

class person implements D{ //实现了父类接口D，但是不需要实现该接口的子类
    @Override
    public void exit() {

    }
}