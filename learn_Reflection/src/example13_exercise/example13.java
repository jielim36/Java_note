package example13_exercise;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
练习1：通过反射修改私有成员变量
1.定义privateTest类，有私有name属性，并且属性值为helloKitty
2.提供getName的公有方法
3.创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值

 */
public class example13 {
    public static void main(String[] args) throws Exception{

        Class cls = Class.forName("example13_exercise.PrivateTest");
        Object obj = cls.newInstance();
        Method method = cls.getDeclaredMethod("getName");//getName方法是public方法，所以用getMethod或者getDeclaredMethod都可以，且不需要爆破（setAccessible(true)）
        System.out.println(method.invoke(obj));//helloKitty

        //修改name
        Field name = cls.getDeclaredField("name");//name也是私有属性，所以调用DeclaredField
        name.setAccessible(true);
        name.set(obj,"小猪佩奇");
        System.out.println(method.invoke(obj));

    }
}

class PrivateTest{
    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}