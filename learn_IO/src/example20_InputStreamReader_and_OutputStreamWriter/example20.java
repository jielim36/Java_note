package example20_InputStreamReader_and_OutputStreamWriter;

import java.io.*;

/*
转换流：InputStreamReader和OutputStreamWriter
介绍：
1.InputStreamReader:Reader的子类，可以将InputStream（字节流）包装/转换成Reader（字符流）
2.OutputStreamWriter：Writer的子类，实现将OutputStream（字节流）包装/转换成Writer（字符流）
3.当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转换成字符流
4.可以在使用时指定编码格式（比如：utf-8 , gbk,gb2312  , ISO8859-1 等）
 */
public class example20 {
    public static void main(String[] args) throws Exception {
        InputStreamReader01();
        OutputStreamWriter01();
    }

    public static void InputStreamReader01() throws Exception {
        //注意：其实a.txt本来就没有乱码，只是做一个示范
        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\a.txt";
        //1.把FileInputStream 转换成 InputStreamReader
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath),"UTF-8");//charsetName编码类型
        //2.把InputStreamReader 转换成 BufferedReader
        BufferedReader br = new BufferedReader(inputStreamReader);

        //也可以把1和2步连接起来
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));

        //读取
        String s = br.readLine();
        System.out.println("读取内容："+s);
        //关闭外层流
        br.close();

    }

    public static void OutputStreamWriter01() throws Exception {

        String filePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\haha.txt";
        String charSet = "utf-8";//UTF-8,utf-8,utf8都可以
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),charSet));//可以放入变量
        bw.write("hihiihihihihihihih你好年份哈解放啦电话发卡机和");
        System.out.println("按照"+charSet+"编码保存文件成功");
        bw.close();


    }
}
