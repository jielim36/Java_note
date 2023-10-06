package example08_allType_Class;

import java.io.Serial;
import java.io.Serializable;

/*
哪些类型有Class对象
1.外部类，成员内部类，静态内部类，局部内部类，匿名内部类都有
2.interface接口
3.数组
4.enum枚举
5.annotation 注解
6.基本数据类型
7.void
 */
public class example08 {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;//外部类
        Class<Serializable> serializableClass = Serializable.class;//接口
        Class<Integer[]> aClass = Integer[].class;//数组
        Class<float[][]> aClass1 = float[][].class;//二维数组
        Class<Deprecated> deprecatedClass = Deprecated.class;//注解
        //枚举
        Class<Thread.State> stateClass = Thread.State.class;//枚举 ： Thread里的State是一个内部类+枚举类，里面有WAITING,RUNNABLE,BLOCKED等等的线程状态
        Class<Long> longClass = long.class;//基本数据类型
        Class<Void> voidClass = void.class;//void
        Class<Class> classClass = Class.class;//Class类也是一个Class类对象...

    }
}
