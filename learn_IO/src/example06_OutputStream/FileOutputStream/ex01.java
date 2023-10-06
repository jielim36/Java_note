package example06_OutputStream.FileOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex01 {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile(){
        //创建FileOutputStream对象
        String filepath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filepath);//如果使用(filepath,true);, 当我们重复执行程序时写入的数据会是“追加”，比如写入hello我们重复执行两次后文本内容变成hellohello,如果原本没true时重复执行内容也一样不变
            //写入一个字节
            try {
                //写入字节
                fileOutputStream.write('a');//注意：如果此时目录没有a.txt文件的话系统会自己创建一个a.txt文件才写入'a'字符

                //写入字符串
                String str = "哈喽哈喽你好你好!";
                fileOutputStream.write(str.getBytes());//write方法中要求要byte数组，但我们可以用String的getBytes方法把字符串转换成byte数组
                //限制长度
                String str2 = "你在干嘛哟";
                fileOutputStream.write(str2.getBytes());//只截取off-len参数之间的内容


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
