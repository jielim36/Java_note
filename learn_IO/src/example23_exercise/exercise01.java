package example23_exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
判断文件路径下是否有文件夹mytemp,如果没有就创建mytemp
 */
public class exercise01 {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\mytemp";
        File file = new File(filePath);

        if (!file.exists()){
            System.out.println("没有该文件...系统将自动生成文件夹...");
            try {
                file.mkdirs();//创建文件夹
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
