package example01_intro;


import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
Reflection 反射
 */
public class example01 {
    public static void main(String[] args) throws Exception {

        //创建对象方式+调用对象方法:

        //传统方法
//        Cat cat = new Cat();
//        cat.miao();

        //如果是反射
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();


        //使用反射机制解决
        //1.加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls得到你加载的类 example00.Cat
        Object o = cls.newInstance(); //也可以直接Cat cat = (Cat)cls.newInstance();
        System.out.println("o的运行类型："+o.getClass());//class example00.Cat

        //3.通过cls得到你加载的类example00.Cat的methodName的方法对象（也就是说可以依靠想要使用的方法字符串名字得到Cat类的方法）
        Method method1 = cls.getMethod(methodName);//methodName字符串是properties从配置文件读取获得的。然后赋给Method类的method1对象
                                                    //即: 在反射中，可以将方法视为对象

        //4.通过method1这个方法对象调用方法，即：通过方法对象来实现调用方法
        System.out.println("===========================================");
        method1.invoke(o);//按理来说应该是：o.method1 （类.方法） ， 但是反射机制是： (方法对象.类)

        //这个反射机制的强势点：这样的需求在学习框架时特别多，即通过外部文件配置，在不修改源码情况下，
        //来控制程序，也符合设计模式的ocp原则（开闭原则：不修改源码，扩容功能）

        //不修改源码的情况下，扩容功能，展示：当我们在re.properties把method=miao的miao改成另外一个方法名cry
        //然后再运行一次这个example01的java程序，就会发现它调用的是cry方法
        //即：只通过修改配置文件re.properties的method名字就实现了不修改example01代码的情况下调用另一个方法

    }
}
