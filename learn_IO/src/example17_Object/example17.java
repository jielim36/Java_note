package example17_Object;

import java.io.*;

/*
对象：ObjectInputStream和ObjectOutputStream（都是处理流）

看一个需求：
1.将int num = 100 这个int数据保存到文件中，注意：不是100这个数字，而是int 100，从文件中直接回复int 100
2.将Dog dog = new Dog("小黄",3)这个dog对象保存在文件中，并且能够从文件恢复。
3.上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化的操作

序列化和反序列化
1.序列化就是在保存数据时，保存数据的值和数据类型
2.反序列化是在恢复数据时，恢复数据的值和数据类型(将保存在文件的数据（值和数据类型）恢复成Dog对象，就称为反序列化)
3.需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的
  该类必须实现两个接口之一：Serializable / Externalizable（一般不会用这个，因为需要实现该接口的方法）


 对象处理流的细节：
1.读写顺序必须一致（序列化时(ObjectOutputStream)writeInt后writeUTF ,  之后反序列化(ObjectInputStream)时也必须readInt后readUTF）
2.要求实现序列化或反序列化对象，实现类需要实现Serializable接口
3.序列化的类中建议添加SerialVersionUID，为了提高版本的兼容性 （//序列化的版本号，可以提高兼容性，当Dog类添加新的属性时，系统会认为是新的类，但是有版本号就会认为是同一个类只是更新了）
4.序列化对象时，默认将里面的所有属性都进行序列化，但除了static或transient修饰的成员，比如说如果toString方法有输出这两种属性，反序列化后变成null
5.序列化对象时，要求里面的属性的类型也需要实现序列化接口（比如Dog里有其他类的对象，那个类也需要实现Serializable接口）
6.序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化

 */
public class example17 {
    public static void main(String[] args) {
        ObjectOutputStream01();
        ObjectInputStream01();
    }

    public static void ObjectOutputStream01(){
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\objectFile.dat";//（序列化后，保存的文件格式不是存文本的，而是按照它的格式来保存）,所以用txt格式也可以
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeInt(100);//int -> Integer () 注意：Integer类已经实现了Serializable接口的
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeDouble(9.5);
            objectOutputStream.writeUTF("hihihi");
            objectOutputStream.writeObject(new Dog("小黄",3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void ObjectInputStream01(){//准备反序列化
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\objectFile.dat";//找到我们想要反序列化的文件的路径，注意文件格式（根据目标文件，如果是txt这里也txt，应该不会报错）

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            //读取（反序列化）的顺序需要和你报错数据（序列化）时的顺序一致
            //否则出现异常
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());
            Object dog = null;
            try {
                dog = objectInputStream.readObject(); //注意，反序列化的.java文件中必须也有这个Dog类（Dog类在其他地方的话需要import，条件是Dog类必须是public class）
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Info Dog = "+dog);//根据dog类中的重写toString方法
            System.out.println("运行类型："+dog.getClass());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Dog implements Serializable{
    String name;
    int age;

    private static final long serialVersionUID = 1L;//序列化的版本号，可以提高兼容性，当Dog类添加新的属性时，系统会认为是新的类，但是有版本号就会认为是同一个类只是更新了

    //序列化时，不会对static和transient进行序列化，其他的全部都会序列化
    private static String nation;
    private transient String color;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name:" + name + "  Age: " + age;
    }
}