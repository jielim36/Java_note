package example13_exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
练习2：利用反射和File完成以下功能
1.利用Class类的forName方法得到File类的class对象
2.在控制台打印File类的所有构造器
3.通过newInstance的方法创建File对象，并在src\\路径下创建一个txt文件

//提示：创建文件的正常写法如下：
File file = new File("d:\\aa.txt")
file.createNewFile();

 */
public class example13_exercise02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class cls = Class.forName("java.io.File");
        Constructor constructor = cls.getConstructor(String.class);//因为我们调用的File类的构造器有String有参构造器，所以需要先创建构造器对象
        Object obj = constructor.newInstance("src\\aa.txt"); //File file = new File("src\\aa.txt")


        //打印File类的所有构造器
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constr : constructors) {
            System.out.println(constr);
        }
        /*
        public java.io.File(java.lang.String)
        public java.io.File(java.lang.String,java.lang.String)
        public java.io.File(java.net.URI)
        public java.io.File(java.io.File,java.lang.String)
         */

        //创建aa.txt文件
        Method method = cls.getMethod("createNewFile");
        method.invoke(obj);//就像：file.createNewFile(); 一样

        //确认是否创建成功
        Method ex = cls.getMethod("exists");
        System.out.println("该文件是否存在?:"+ex.invoke(obj));




    }
}
