package example05_Class_intro;

import example00.Cat;

/*
Class类的基本介绍：
1.Class也是一个类，因此也继承了Object类（参考example05的Class_diagram.uml）
2.Class类对象不是new出来的，而是系统创建的（参考img.png中的反射原理图：Class对象是通过类加载器ClassLoader的loadClass()方法）
3.对于某个类的Class类对象，在内存中只有一份，因为类值加载一次（如果先Cat cat = new Cat后再使用Class的反射，这时候的反射其实不会加载class，因为new Cat的时候已经加载过了）
4.每个类的实例都会记得自己是由哪个Class实例所生成的
5.通过Class可与完整的得到一个类的完整结构，通过一系列API（比如：getInterface获取当前Class对象的接口，getSuperClass获取其父类,newInstance返回该Class对象的一个实例）
6.Class对象是存放在堆的
7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等等）

 */
public class example05 {
    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * 测试：
         * 关于Class类对象不是new出来，而是系统创建的
         */
        //Cat cat = new Cat();//我们通过debug调式工具去追源码,然后直接使用Force Step Into功能（注意：我这里进入不到源码所以所有解释都是看hsp的video）
        /*源码：会直接进入Class类的loadClass方法进行类加载
            public Class<?> loadClass(String name) throws ClassNotFoundException {
               return loadClass(name, false);
            }
         */
        Class aClass = Class.forName("example00.Cat"); //追源码，注意：如果上面的Cat类已经加载过一次了的话，这个Class就不会再重新加载
        /*
        源码：可以发现和Cat一样到最后都会进入该loadClass方法，但是Class类前面会有一些其他的过程
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */

        /**
         * 测试：
         * 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
         *
         */
        Class cls2 = Class.forName("example00.Cat");
        Class cls3 = Class.forName("example00.Cat");
        Class cls4 = Class.forName("example00.Dog");
        System.out.println("cls2:"+cls2.hashCode());//cls2:81628611
        System.out.println("cls3:"+cls3.hashCode());//cls3:81628611
        System.out.println("cls4:"+cls4.hashCode());//cls4:1828972342
        //可以发现cls2和cls3都是Cat类的Class对象，他们的hashcode都一样
        //但是cls4是Dog类的Class对象，所以和Cat类的不一样


    }
}
