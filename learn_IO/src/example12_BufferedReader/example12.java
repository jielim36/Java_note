package example12_BufferedReader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
BufferedReader and BufferedWriter 属于字符流，是按照字符来读取数据的
关闭处理流时，只需关闭外层流即可

建议用于读取文本文件，如果用于处理二进制文件（图片，声音，视频）有可能会损毁
 */
public class example12 {
    public static void main(String[] args) {

    }
    @Test
    public void BufferedReader01() throws Exception {
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));//方法声明时已经抛出所有异常了，所以不需要try-catch

        String line;
        //readLine方法，如果以达到文件的末尾就返回null
        while ((line = bufferedReader.readLine()) != null ){
            System.out.println(line);
        }

        //关闭流时，只需要关闭bufferedReader,因为底层会自动关闭FileReader这个节点流
        bufferedReader.close();


    }
    public static void BufferedReader02(){}
    public static void BufferedReader03(){}


}
