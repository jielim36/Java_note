package example05_InputStream.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
FileInputStream是一个字节流，不能读取中字，所以平时要读取文本文件，最好使用字符流（Reader），而不是InputStream字节流
 */
public class ex01 {
    public static void main(String[] args) {

    }

    @Test  //第一种方法
    public void readFile01(){

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\hello.txt";
        FileInputStream fileInputStream = null;//先定义对象，然后在try里面才写详细，因为如果全部都写在里面，finally不能访问这个属性（作用域问题）
        try {
            int readData = 0;
            //创建FileInputStream对象，用于读取
            fileInputStream = new FileInputStream(filePath);
            //如果返回-1，代表读取完毕
            while((readData = fileInputStream.read()) != -1){ //read = fileInputStream.read() 返回的值不等于-1就继续读取，因为-1代表读取完毕
                System.out.print((char)readData);//把int号码转换成char，因为read = fileInputStream.read()返回的号码是一个编码
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //我们必须关闭文件流，释放资源，否则如果之后在读取这个文件就会一直累加
            try {
                fileInputStream.close(); //close方法也有异常，所以也需要try-catch
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }
    @Test   //第二种方法：效率更高，使用byte数组
    public void readFile02(){

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\hello.txt";
        FileInputStream fileInputStream = null;
        try {
            byte [] readData = new byte[8];
            int readLen = 0;

            fileInputStream = new FileInputStream(filePath);
            //如果返回-1，代表读取完毕
            while((readLen = fileInputStream.read(readData)) != -1){  //此时的byte数组有8个空间，然后我们的文件内容hello,world有十一个字符，所以数组个数显然不够用。read方法会将文件的每一个字符的ASCII码都传给数组，当数组满了后会将数组的长度赋给readLen然后往下走。//然后又上回来，因为还没有把文件的全部内容都读取，此时文件内还有三个字符未被读取，然后逐一赋给数组，数组获得了3个字符后第四次获取到-1，然后赋给readLen后就被条件!= -1 中断，然后又往下走
                System.out.print(new String(readData,0,readLen));//这里是定义一个String包装类，然后放入byte数组用于转换成字符串，然后后面两个参数0,readLen指的是截取数组的下标起点和终点，此时数组第一次进入时填满了八个字符，然后截取0-8的范围变成字符串，然后回去上面的while循环重新循环。//然后第二次下来时数组里只有3个元素，所以readLen（此时数组内的八个位置前三个是现在的元素，后面的其实是上一次下来时的数据，未被丢弃），然后传入String，截取范围是0-readLen(3),所以只有获取数组的前三个字符，后面那些旧的数据不会被接收
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //我们必须关闭文件流，释放资源，否则如果之后在读取这个文件就会一直累加
            try {
                fileInputStream.close(); //close方法也有异常，所以也需要try-catch
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }

}
