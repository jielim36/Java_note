package example10_create_Object;

import java.lang.reflect.Constructor;

/*
通过反射创建对象
方式一： 调用类中的public修饰的无参构造器class对象
方式二：调用类中的指定构造器

3.Class类相关的方法：
newInstance : 调用类中的无参构造器，获取对应的类对象
getConstructor(Class.xxx)：根据参数列表，获取对应的public构造器对象 ，比如构造器的形参是String name , 就需要getConstructor()
getDeclaredConstructor(Class.Xxx) ： 根据参数列表，获取对应的构造器对象(包括private构造器)

4.Constructor类的相关方法
-setAccessible:爆破（暴力破解）
-newInstance(Object.obj) 调用构造器（通常要使用有参构造器创建实例对象时会使用，如果使用Class.newInstance通常是使用无参构造器的时候）

 */
public class example10 {

    public static void main(String[] args) throws Exception {

        //先获取User类的Class对象
        Class cls = Class.forName("example00.User");

        //通过public的无参构造器创建实例
        Object o = cls.newInstance();
        System.out.println(o);//User{age=2, name='小明'}

        //通过public的有参构造器。该案例我们获取User类的一个public User(String name)构造器
        Constructor constructor = cls.getConstructor(String.class);
        Object o2 = constructor.newInstance("小兔崽子");//然后才通过构造器的newInstance方法创建实例化对象，然后可以传入值
        System.out.println(o2);//User{age=2, name='小兔崽子'}

        //getDeclaredConstructor可以获取private构造器
        Constructor declaredConstructor = cls.getDeclaredConstructor( int.class , String.class);
        declaredConstructor.setAccessible(true);//爆破（暴力破解）：把该构造器使用getAccessible= true设置成一个可以跳过访问检查的构造器，就可以无视private访问修饰符了
        Object o3 = declaredConstructor.newInstance(19, "小勇");
        System.out.println(o3);//User{age=19, name='小勇'}


    }

}
