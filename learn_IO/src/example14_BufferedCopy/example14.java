package example14_BufferedCopy;

import java.io.*;
//用于处理字符流的
public class example14 {
    public static void main(String[] args) {

        String srcFilePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\aaaCopy.txt";//拷贝的话必须是已有的文件
        String destFilePath = "C:\\Users\\jieli\\Desktop\\Java\\learn_IO\\TestingFile\\bbbCopy.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //readLine方法是读取一行的内容，但没有包括换行符，所以我们需要自己添加
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();//手动添加换行符，因为readLine方法读取一整行内容后没有自动换行
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if (br != null){//如果不判断是否为空直接close，然后刚好br是null，就会发生空指针异常
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            }catch (IOException e){
                throw new RuntimeException();
            }
        }

    }
}
