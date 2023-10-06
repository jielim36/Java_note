package example12_controlMethod;

import java.lang.reflect.Method;

/*
操作方法
 */
public class example12 {
    public static void main(String[] args) throws  Exception{
        Class cls = Class.forName("example12_controlMethod.Teacher");
        Object obj = cls.newInstance();//得到了Teacher实例对象

        //调用普通方法
        Method method1 = cls.getMethod("hi", String.class);
        method1.invoke(obj,"嘤嘤嘤");//当调用的方法是有参时，使用invoke方法准备执行方法时需要写入参数(对象 , 参数)

        //调用private方法,使用getDeclaredMethod,该方法可以调用所有某类的方法（无视访问修饰符，但是需要爆破：setAccessible(true)）
        Method method2 = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        method2.setAccessible(true);
//        System.out.println(method2.invoke(obj,9,"哈哈哈",'S'));
        System.out.println(method2.invoke(null,9,"哈哈哈",'S'));//say方法是static方法，用null或者对象调用都可以

        //注意：在反射中，如果方法有返回值，统一返回Object,但是它的运行类型还是原本的（比如方法返回String，这里返回的值的运行类型也是String）
        Object returnValue = method2.invoke(obj, 9, "哈哈哈", 'S');
        System.out.println(returnValue);

    }
}

class Teacher{
    public int age;
    private static String name;
    public Teacher(){}

    private static String say(int n , String s , char c){
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("hi " + s);
    }
}
