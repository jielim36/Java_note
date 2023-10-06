package example22_Properties.example02_Properties_collection;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
专门用于读写配置文件的集合类
配置文件格式：
key = value

注意：key-value不需要有空格，value不需要用引号一起阿里，默认类型是String

Properties常用方法:
1. load：加载配置文件的key-value到Properties对象
2. list：将数据显示到指定设备
3. getProperty(key)：根据key获取value
4. setProperty(key,value) : 设置key-value到Properties对象
5.store: 将Properties中的key-value存储到配置文件（如果已经存在则覆盖原本的数据），
  在idea中保存信息到配置文件，如果含有中文，会存储为unicode码
 */
public class example02 {
    public static void main(String[] args) {

        //Properties常用方法
        //1.创建Properties对象
        Properties properties = new Properties();

        //2.加载指定配置文件
        try {
            properties.load(new FileReader("src\\mysql.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //3. 把key-value显示控制台
        properties.list(System.out);

        //4.根据key获取对应的value （user = root 只想要root的话）
        String user = properties.getProperty("user");
        System.out.println("User Name : "+user);

        //5.使用Properties类来创建配置文件和修改配置文件
        Properties properties2 = new Properties();
        properties2.setProperty("charset","utf-8"); //charset = utf-8(key = value)
        properties2.setProperty("user","宇杰");//汉字被创建成配置文件时会转成unicode码
        properties2.setProperty("password","abc111");

        //将key-value存储进文件
        try {
            properties2.store(new FileOutputStream("src\\mysql2.properties"),"Here is properties file"); //这个第二个参数是个注释
            System.out.println("保存配置文件成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
        输出结果：
        charset=utf-8
        password=abc111
        user=\u5B87\u6770   这个值是“宇杰”的unicode码
         */

        //需要修改某个key-value ， 可以写入我们要该的类型（key相同的两个元素时，value会被替换，相当于修改）
        //所以如果输入新的key就创建，重复的key就修改
        properties2.setProperty("password","nnssdd");
        //重新保存
        try {
            properties2.store(new FileOutputStream("src\\mysql2.properties"),"Here is properties file"); //这个第二个参数是个注释
            System.out.println("保存配置文件成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
