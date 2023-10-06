package example19_transformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class example19 {
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s = bufferedReader.readLine();
        System.out.println("读取到的内容：");
        System.out.println(s); //如果我们的a.txt文件是一个不支持汉字的编码，比如ANSI码之类的，这里提取出来的内容就会是乱码，所以我们需要解决这个问题
                                //看example20 有方法解决

    }
}
