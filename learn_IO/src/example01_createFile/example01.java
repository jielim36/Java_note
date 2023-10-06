package example01_createFile;

/*
文件流：
流：数据在数据源（文件）和程序（内存）之间经历的路径
输入流：数据从数据源（文件）到程序（内存）的路径
输出流：数据从程序（内存）到数据源（文件）的路径
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class example01 {
    public static void main(String[] args) {

        create01();

    }

    //控制java生成文件的三种方法
    @Test
    public static void create01() {
        String filePath = "C:\\Users\\jieli\\Desktop\\createSomething.txt";  //我们可以把文件设置在Desktop，c盘好像没权限
        File file = new File(filePath);
        try {
            file.createNewFile();//只有使用这行代码才会在磁盘生成文件
            System.out.println("文件创建成功啦");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void create02(){
        File parentFile = new File("C:\\Users\\jieli\\Desktop\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void create03(){
        String parentPath = "C:\\Users\\jieli\\Desktop\\"; //和第二种方法的区别是，parentPath这里用String类型
        String fileName = "news3.txt";
        File file = new File(parentPath,fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
