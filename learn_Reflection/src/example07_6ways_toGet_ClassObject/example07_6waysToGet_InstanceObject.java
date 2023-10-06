package example07_6ways_toGet_ClassObject;

import example00.Dog;

/*
有六种方式获取Class对象
每种方式都分别在Java程序运行的某个阶段使用

比如：在代码阶段/编译阶段就直接使用Class.forName
    或者Class类阶段（加载阶段）使用 类名.class
    或者在RunTime运行阶段使用 对象名.getClass()方法
    或者在类加载时直接使用类加载器得到Class对象

详细介绍：
1.前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，有可能会抛出ClassNotFoundException
  实例对象获取方式：Class cls = Class.forName("example00.Cat")
  应用场景：多用于配置文件，读取类全路径，加载类

2.前提: 若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高实例：Class cls2 = Cat.class;
  应用场景：多用于参数传递，比如通过反射得到对应的构造器对象。

3.前提：已知某个类的实例，调用该实例的getClass()方法获取Class对象，实例：Class cls3 = 对象.getClass;
  应用场景：通过创建好的对象，获取Class对象

4.其他方式：通过类加载器（有很多方式）
  ClassLoader cl = 对象.getClass().getClassLoader();
  Class cls5 = cl.loadClass("类的全类名");

5.基本数据类型Primitive Data type 比如int,char,float等 按照如下方式得到Class类对象
  Class cls = 基本数据类型.class

6.基本数据类型对应的包装类，可以通过.type得到Class对象
Class cls = 包装类.TYPE

 */
public class example07_6waysToGet_InstanceObject {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
        第一种方式：Class.forName() 方法  -> 建议用于代码阶段/编译阶段
        1.前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，有可能会抛出ClassNotFoundException
        实例对象获取方式：Class cls = Class.forName("example00.Cat")

        应用场景：多用于配置文件，读取类全路径，加载类
         */
       Class cls1 = Class.forName("example00.Dog");
        System.out.println("cls1: "+cls1);

        /*
        第二种方式：类名.class
        2.前提: 若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高实例：Class cls2 = Cat.class;
        应用场景：多用于参数传递，比如通过反射得到对应的构造器对象。
         */
        Class cls2 = Dog.class;
        System.out.println("cls2: "+cls2);

        /*
        第三种方式：Class cls3 = 对象.getClass;
        3.前提：已知某个类的实例，调用该实例的getClass()方法获取Class对象，实例：Class cls3 = 对象.getClass;
        其实就是通过对象.getClass获取该对象的运行类型然后赋给Class对象
        应用场景：通过创建好的对象，获取Class对象
         */
         Dog dog = new Dog();//假设我们已经有了一个Dog对象
        Class cls3 = dog.getClass();//通过Dog类的dog对象的getClass获取运行类型然后赋给cls3
        System.out.println("cls3: " + cls3);

        /*
        4.其他方式：通过类加载器
        ClassLoader cl = 对象.getClass().getClassLoader();
        Class cls5 = cl.loadClass("类的全类名");
         */
        //第一步：得到类加载器
        Dog dog2 = new Dog();
        ClassLoader classLoader = dog2.getClass().getClassLoader();
        //第二部：通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass("example00.Dog");
        System.out.println("cls4: "+cls4);


        //以上所有的方式创建的对象其实都是同一个对象
        System.out.println("cls1 hashCode: "+ cls1.hashCode());
        System.out.println("cls2 hashCode: "+ cls2.hashCode());
        System.out.println("cls3 hashCode: "+ cls3.hashCode());
        System.out.println("cls4 hashCode: "+ cls4.hashCode());
        /*
        输出结果：
        cls1 hashCode: 81628611
        cls2 hashCode: 81628611
        cls3 hashCode: 81628611
        cls4 hashCode: 81628611
         */

        /*
        5.基本数据类型Primitive Data type 比如int,char,float等 按照如下方式得到Class类对象
        Class cls = 基本数据类型.class
         */
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;

        /*
        6.基本数据类型对应的包装类，可以通过.type得到Class对象
        Class cls = 包装类.TYPE
         */
        Class<Integer> IntegerType = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        Class<Boolean> type2 = Boolean.TYPE;

        //即使一个用int基础数据类型，一个用Integer包装类，可是他们还是同一个对象，都是一个hashcode
        System.out.println("int：" + integerClass.hashCode());//865113938
        System.out.println("Integer: " + IntegerType.hashCode());//865113938
        System.out.print("int和Integer的内存地址对比:");
        System.out.println(integerClass == IntegerType);//true ，表示同一个对象
    }
}
