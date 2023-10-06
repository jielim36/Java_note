package example11_controlField;

import java.lang.reflect.Field;

/*
访问属性:
1.根据属性名获取Field对象

2.爆破（暴力破解）：f.serAccessible(true) 无视访问修饰符

3.访问
f.set(obj , 值) //f是属性,obj是对象

4.注意：如果是静态属性，则set和get中的参数o可以写成null
 */
public class example11 {
    public static void main(String[] args) throws  Exception{

        //得到Student类的Class对象
        Class cls = Class.forName("example11_controlField.Student");

        //创建对象
        Object o = cls.newInstance();//o目前的运行类型已经是Student类了

        //操作属性
        //得到属性
        Field age = cls.getField("age");
        age.set(o,88);//修改o对象的age，改成88岁
        System.out.println(o);//Student{age=88  name=null}
        System.out.println(age.get(o));//查看o对象的age: 输出 ：88

        //得到name属性，该属性是 private static属性
        Field name = cls.getDeclaredField("name");//获取private属性必须用getDeclaredField
        name.setAccessible(true);//获取private成员必须要调用setAccessible(true)
        name.set(null,"小明");//因为是static属性，所以不需要指定对象，因为该属性在全部对象都能使用(注意：创造这个name属性时是使用cls来创建的，所以它一定是属于cls的运行类型的类(Student)的属性)
        System.out.println(name.get(null));//小明
        System.out.println(o);//Student{age=88  name=小明}

    }
}

class Student{
    public int age;
    private static String name;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + "  name=" + name +
                '}';
    }
}