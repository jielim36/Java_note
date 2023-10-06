package example02_someMethod;

import org.junit.jupiter.api.Test;

import java.io.File;

public class example02 {
    public static void main(String[] args) {

    }

    @Test//用Test运行该方法
    public void info(){
        //创建文件对象
        File newFile = new File("C:\\Users\\jieli\\Desktop\\news2.txt");//没有立刻在磁盘中生成文件，现在只是创建了一个对象
        //调用getName方法
        System.out.println("文件名：" + newFile.getName());

        //得到绝对路径 AbsolutePath
        System.out.println("该文件的绝对路径：" + newFile.getAbsolutePath());//C:\news1.txt

        //得到父级目录
        System.out.println("该文件的父级目录" + newFile.getParent());

        //文件大小（字节）
        System.out.println("文件大小(字节):" + newFile.length());//该文件内容是hello，所以返回5. UTF-8编码下：英文字占1个byte（字节），中字占3字节Byte

        //文件是否存在？
        System.out.println("文件是否存在："+newFile.exists());//true

        //是不是一个文件
        System.out.println("是不是一个文件：" + newFile.isFile());
        System.out.println("是不是一个目录：" + newFile.isDirectory());

    }

}
