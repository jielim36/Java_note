package example06_common_Method;

import example00.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*

Class常用方法

 */
public class example06 {
    public static void main(String[] args) throws Exception {

        String classAllPath = "example00.Dog";//定义我们要使用的类的路径

        //1.获取到Dog类对应的Class对象
        //<?> 表示不确定的类型，即：泛型通用符（<?>和直接不写应该没有差别）
        Class<?> cls = Class.forName(classAllPath);//该方法会有一个ClassNotFoundException异常，当我们输入的路径不正确系统找不到目标时会抛出该异常

        //2.输出
        System.out.println(cls);//class example00.Dog :直接输出该Class对象会显示该Class对象时属于哪个类
        System.out.println(cls.getClass());//class java.lang.Class ：使用getClass会返回Class类
        //得到包名
        System.out.println(cls.getPackage().getName());//example00 : getPackage获得包再getName就可以得到包名
        //得到类名
        System.out.println(cls.getName());//example00.Dog

        //3.通过Class对象创建对象实例
        Object obj = cls.newInstance();//第一种方式
        Dog dog = (Dog)cls.newInstance();//第二种方式(没有差别)

        System.out.println("obj:"+obj);//Dog{name='小黄', price=10000, color='white'} ,相当于：dog.toString()  (注意：Dog类已经提前写好了name，price，color的属性)

        //4.通过反射获取属性
        Field name = cls.getField("name");//在反射领域里属性(field)是一个对象，底层：Field [] field ， 把一个类的全部成员变量放入里面
        System.out.println(name.get(obj));//小黄 （得到Dog类的name属性），注意：如果该属性是private的话会报错

        //5.通过反射给属性赋值
        name.set(obj,"大壮");
        System.out.println("obj的name更改后："+obj);//Dog{name='大壮', price=10000, color='white'}

        //6. getFields方法获取全部属性（注意：getFields有s）
        Field[] fields = cls.getFields();
        for (Field field : fields){
            System.out.println(field.getName());//getName可以获取该类所有的属性的变量名（不是属性的值）
            System.out.println(field.get(obj));//get(该类的实例对象)可以获取该属性的值
        }

        /*
        7.getModifier 获取该属性的访问修饰符,以int形式返回修饰符
        默认default = 0  , public = 1 , private = 2 , protected = 4
        static = 8 , final = 16 , public static = 1+8=9
         */
        for (Field field : fields){
            System.out.println(field.getName() + " Modifiers:" + field.getModifiers());
        }

        //getDeclaredMethods : 获取本类的所有方法 (获取全部构造器等等也是以此类推...)
        Method [] allMethod = cls.getMethods();
        for (Method method : allMethod){
            System.out.println("dog method:  "+method.getName());
        }

        //获取全部public构造器（好像包括父类，不确定）
        Constructor<?>[] constructors = cls.getConstructors();

        //获取某个方法的形参getParameterTypes,以数组的形式返回
        Method method2 = cls.getMethod("Hi", String.class, int.class, char.class);
        Class<?>[] parameterTypes = method2.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("hihihi方法的形参："+ parameterType);
        }

        //获取全部方法+获取方法的形参
        Method [] allMeth = cls.getMethods();
        for (Method method : allMeth) {

            Class<?>[] parameterTypes1 = method.getParameterTypes();
            System.out.println("方法：" + method.getName() );
            for (Class<?> aClass : parameterTypes1) {
                System.out.println( "  形参： " + aClass);
            }

        }

        /**
         * 可以通过以上的方法搭配组合使用：
         * 比如：获取构造器后，使用getParameterTypes获取该构造器的形参等等
         */
    }
}
