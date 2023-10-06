package example08_FileReader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
FileReader和FileWriter都是字符流，即按照字符char来操作io

FileReader相关方法：
1.new FileReader(File/String类型)
2.read:每次读取单个字符，返回该字符，如果到了文件末尾则返回-1
3.read(char [] ) ：批量读取多个字符到数组，返沪i读取的字符数，如果到文件末尾返回-1
相关API
1.new String(char[]) ： 将char数组转换成String
2.new String(char[] ,off ,len ) 将char数组的指定部分截取出来转换成String

 */
public class example08 {
    public static void main(String[] args) {

    }

    @Test //第一种方法：单个字符读取
    public void readFile01(){
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\cn.txt";
        FileReader fileReader = null;
        int data = ' '; //创建一个int数据类型用于接收read方法返回的ASCII编码
        try {
            //1.创建FileReader对象
            fileReader = new FileReader(filePath);
            //循环读取，使用read
            while((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @Test  //使用数组读取:效率更快
    public void readFile02(){
        System.out.println("readFile02 method :");
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\cn.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] data = new char[8];
        try {
            //1.创建FileReader对象
            fileReader = new FileReader(filePath);
            //循环读取，使用read
            while((readLen = fileReader.read(data)) != -1){
                System.out.print(new String(data,0,readLen));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
