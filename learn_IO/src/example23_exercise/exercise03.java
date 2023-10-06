package example23_exercise;

import java.io.*;

public class exercise03 {
    public static void main(String[] args) {
        /*
        要求：使用BufferedReader读取一个文本文件，为每行加上行号？
              再连同内容一并输出到屏幕上
         */
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\TTT.txt";
        BufferedReader br = null;
        try {
//            br = new BufferedReader(new FileReader(filePath));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));//防止文件格式错误
            String data = "";
            int numberLine = 1;
            while((data = br.readLine()) != null){
                System.out.println((numberLine++) + "\t" + data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
