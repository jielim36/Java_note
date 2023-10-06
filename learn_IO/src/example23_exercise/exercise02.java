package example23_exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class exercise02 {
    public static void main(String[] args) throws Exception {
        //在目录下创建ex02.txt
        //如果该文件已存在，提示用户，就不在创建了
        //并且在该文件中写入hello world
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\ex02.txt";
        //创建文件
        File file = new File(filePath);
//        file.createNewFile();
        //判断
//        if (file.exists()){
//            System.out.println("文件已存在...停止创建文件");
//        }else {
//            System.out.println("文件不存在，准备创建文件...");
//            file.createNewFile();
//            System.out.println("创建成功");
//        }
        if (file.createNewFile()){ //如果创建了会返回true，已经有该文件了创建不了返回false
            System.out.println("创建成功");
        }else {
            System.out.println("文件已存在，停止创建");
        }

        //写入
        String path = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\";
        String targetPath = path + "ex02.txt"; //新用法，用拼接字符串
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath));
        bw.write("Hello,World!!___hahahaha");
        bw.close();
    }
}
