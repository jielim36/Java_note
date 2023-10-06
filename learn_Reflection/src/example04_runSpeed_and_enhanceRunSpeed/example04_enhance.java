package example04_runSpeed_and_enhanceRunSpeed;

import example00.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
反射优点和缺点
1.优点：可以动态的创建和使用对象（也是框架底层核心），使用灵活，没有反射机制，框架技术就失去底层支撑
2.缺点：使用反射基本是解释执行，堆执行速度有影响

example04会展示使用反射机制后对程序的运行速度的影响，和如何优化运行速度

 */

/*
反射调用优化 - 关闭访问检查
1.Method和Field，Constructor对象都有setAccessible()方法  （Accessible 可访问性，可进入）
2.setAccessible作用是启动和禁用访问安全检查的开关
3.参数值为true表示 反射的对象在使用时取消访问检查，提高反射的效率，参数值为false则表示反射的对象执行访问检查

Method，Field和Constructor有这个setAccessible方法是因为它们都继承了AccessibleObject类
 */
/**
 * 这次的测试目的：当反射使用setAccessible()方法关闭访问检查后对运行速度的影响
 */

public class example04_enhance {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }

    /**
     * 测试三种调用方法的方式的运行速度：
     * m1:传统方式调用方法
     * m2:反射的方式调用方法（没有使用setAccessible(true)的情况下）
     * m3:反射的方式调用方法（有使用setAccessible(true)的情况，即：取消了访问检查后的运行书店）
     *
     * 结果：
     *传统方式的执行速度:5
     * 反射的执行速度:51
     * 反射(setAccessible(true))的执行速度:18
     *
     * 总结： 传统方式依旧最快，反射调用方法时setAccessible可以优化一点点，但依旧慢过传统方式
     */

    public static void m1(){
        Long start = System.currentTimeMillis();
        Cat cat = new Cat();//example00的cat类
        for (int i = 0; i < 999999; i++) {
            cat.miao();
        }
        Long end = System.currentTimeMillis();
        System.out.println("传统方式的执行速度:"+ (end-start));
    }
    //计算反射机制的运行时间(没有使用setAccessible的情况)
    public static void m2() throws Exception {
        Class cls = Class.forName("example00.Cat");//这次不依靠properties提取，而是直接字符串
        Object obj = cls.newInstance();//创建obj实例对象
        Method method1 = cls.getMethod("miao");

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 999999; i++) {
            method1.invoke(obj);
        }
        Long end = System.currentTimeMillis();
        System.out.println("反射的执行速度:"+ (end-start));
    }
    //反射的执行速度(有使用setAccessible的情况)
    public static void m3() throws Exception {
        Class cls = Class.forName("example00.Cat");//这次不依靠properties提取，而是直接字符串
        Object obj = cls.newInstance();//创建obj实例对象
        Method method1 = cls.getMethod("miao");
        method1.setAccessible(true);//写成true表示取消在反射调用方法时取消访问检查

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 999999; i++) {
            method1.invoke(obj);
        }
        Long end = System.currentTimeMillis();
        System.out.println("反射(setAccessible(true))的执行速度:"+ (end-start));
    }
}
