package example03_makeDirectory_and_delete;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class example03 {
    public static void main(String[] args) {

    }
    @Test
    public void m1(){
        String filePath = "C:\\Users\\jieli\\Desktop\\news4.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println(file.getName()+" 文件已创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(file.getName() + "文件是否存在？:" + file.exists());//确认是否在磁盘生成成功

        if (file.exists()){ //如果文件已存在，返回true
            if (file.delete()){ //delete方法，如果成功删除时会返回一个boolean，所以删除后返回的boolean可以顺便做一个if else语句
                System.out.println("删除成功");
            }else {
                System.out.println("文件删除失败");
            }
        }else {
            System.out.println("该文件不存在...");
        }
    }

    @Test  //思维：这里我们需要体会到，在java变成中，目录也被当作文件（目录=文件夹）
    public void m2(){
        String filePath = "C:\\Users\\jieli\\Desktop\\testingFile\\a\\b\\c"; //这里的news10是目录（文件夹），不是txt文件（注意：没有生成文件，只是创建对象，如果电脑原本就有这个文件，就会匹配，然后下面exist方法可以确认是否有这个文件）
        File file = new File(filePath);                                     //如果我们的路径是连续几个都没有的目录，之后创建的时候会一起创建出来

        System.out.println(file.getName() + "文件是否存在？:" + file.exists());//确认是否在磁盘生成成功

        if (file.exists()){ //如果文件已存在，返回true
            System.out.println("该目录已经存在");
        }else {
            System.out.println("该目录不存在...");
            if (file.mkdirs()){ //mkdirs方法是创建目录，不要使用mkdir方法，因为该方法会创建在一级目录，mkdirs方法就是创建多级目录（直接用mkdir方法会报错，除非我们之间创建在C盘（一级目录））
                System.out.println("该目录创建成功");
            }
        }
    }




}
