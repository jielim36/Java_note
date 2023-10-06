package example03_Class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/*
反射相关的主要类：
1. java.lang.Class : 代表一个类，Class对象表示某个类加载后在堆中的对象
2. java.lang.reflect.Method:代表类的方法，Method对象表示某个类的方法
3.java.lang.reflect.Field：代表类的成员变量，Field对象表示某个类的成员变量
4.java.lang.reflect.Constructor:代表类的构造器，Constructor对象表示某个类的构造器
 */
public class example03 {
    public static void main(String[] args) throws Exception {

        //先通过Properties提取配置文件...
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classObject = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        Class cls = Class.forName(classObject);//Class对象，得到了example00.Cat
        Object obj = cls.newInstance();//通过cls的newInstance方法获取实例对象赋给obj对象
        Method method1 = cls.getMethod(methodName);//Method对象，得到了cls对象的method（该method是re.properties中写的method）
        method1.invoke(obj);

        //java.lang.reflect.Field 代表类的成员变量，Field对象表示某个类的成员变量
        //得到Cat类的name字段
        Field nameField = cls.getField("age");//通过cls这个Class类对象的getField方法得到了Cat类的age属性(Field对象得到了cls这个（Cat）对象的属性"age")
//        Field name = cls.getField("name");//会报错，因为getField不能得到private访问修饰符的属性

        System.out.println("Field: "+nameField.get(obj));//传统写法: 类名.属性名  ， 反射机制写法：属性名.类名

        //java.lang.reflect.Constructor: 代表类的构造器，Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();//(无参构造器)可以通过cls这个代表者某个类的对象获取该类的构造器（cls目前是一个Cat类，所以constructor得到了该类的构造器）
        System.out.println("Constructor: "+constructor);

        //有参构造器
        Constructor constructor2 = cls.getConstructor(String.class); //注意，如果Cat类的构造器是int，可是这里是其他数据类型，不会发生编译错误，而是运行错误
        System.out.println("constructor2: "+constructor2);//public example00.Cat(java.lang.String)
    }
}
