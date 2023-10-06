package example09_classLoad;


import java.lang.reflect.Method;

/*
关于类加载：
反射机制是java实现动态语言的关键，也就是铜鼓反射实现类动态加载
1.静态加载：编译时加载相关的类，如果没有则报错，依赖性太强（即：在编写代码阶段就需要解决异常）：传统创建类实例对象方式的时候
2.动态加载：运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性 ：通常在反射机制中可以发现
  即：反射=动态加载

  类加载的时机（类是什么时候加载的？）
  1.当创建对象时(new)  - 静态加载
  2.当子类被加载时 - 静态加载
  3.调用类中的静态成员时（但如果是调用static+final属性时不会触发类加载） - 静态加载
  4.通过反射 - 动态加载


 */
public class example09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        //1.静态加载：编译时加载相关的类，如果没有则报错，依赖性太强（即：在编写代码阶段就需要解决异常）
        int option = 2;
        if (option == 1){
//            Dog dog = new Dog(); 静态加载：这里没有import引入包，所以会直接报错，即使我们的if-else语句有可能不会使用到它
        }else {
            System.out.println("do nothing");
        }

        //2.动态加载：运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性
        if (option == 1){
            System.out.println("nothing");
        }else {
            //实际上没Person这个类，这里在写代码阶段不会报错，在运行时如果有运行到这个部分（if-else的else部分）就会报错
            //即：如果运行时没有用到它，程序就不会报错，但是事实上这个是会报错的，因为实际上没有Person这个类
            //报错时抛出ClassNotFoundException
            Class cls = Class.forName("Person");
            Object o = cls.newInstance();
            Method haha = cls.getMethod("haha");
            System.out.println("ok!");
        }

    }
}

class A{
    /**
     * 关于类加载过程中的准备（具体看韩顺平的java手册的935页）
     */

    private int num1 = 1; //n1不会加载，因为它是实例属性，不是静态变量（所以在准备阶段不会分配内存的）
    private static int num2 = 1; //n2是静态变量，准备阶段会分配内存，然后会默认初始化该属性的值为0（int的默认值） -> 初始化阶段才会把他的值加载成1
    private static final int num3 = 1;//n3是static final，是常量，它和静态变量也不一样，它在准备阶段直接就加载了它的值为1


}