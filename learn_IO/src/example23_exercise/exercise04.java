package example23_exercise;

import java.io.*;
import java.util.Properties;

public class exercise04 {
    public static void main(String[] args) {
        /*
        提前手动编写一个dog.properties
        name = tom
        age = 5;
        color = red
        2.编写Dog类（name,age,color） 创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化
        3.读取Dog.properties文件到控制面板输出
        4.将创建的Dog对象，序列化到文件dog.dat
         */
        String filePath = "src\\Dog.properties";

        Properties propertiesDog = new Properties();
        try {
            propertiesDog.load(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //利用properties创建Dog对象
//        Dog dog1 = new Dog(propertiesDog.get("name"),propertiesDog.get("Age"),propertiesDog.get("Color")); 直接get返回的是Object类型
        String name = (String) propertiesDog.get("Name");
        int age = Integer.parseInt(propertiesDog.get("Age")+"");//返回的是Object类型加上字符串""转成字符串类型，然后再转成age
        String color = (String) propertiesDog.get("Color");
        Dog dog = new Dog(name,age,color);


        //读取properties文件
        System.out.println("读取properties文件:");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf8"));
            String read;
            while((read = br.readLine()) != null){
                System.out.println(read);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //序列化Dog对象
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\DogInfo.dat"));
            oos.writeObject(dog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //反序列化
        System.out.println("\n\n反序列化后:");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\DogInfo.dat"));
            try {
                Dog dogInfo = (Dog)ois.readObject();
                System.out.println(dogInfo);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
