package exercise03;

import java.util.Arrays;

/*
编写java程序，输入形式为：Han Shun Ping的任命，以Ping,Han .S的形式打印出来。其中的.S是中间单词的首字母
2.例如： Willian Jefferson Clinton,输出形式为：Cliton, Willian .J

要求：
必须是三个单词名字
 */
public class exercise03 {
    public static void main(String[] args) {
        Name("Han Shun Ping");
        Name("Willian Jefferson Cliton");
    }

//    public static void Name(String name){
//
//        String [] array = name.split(" ");
//
//        String temp = array[0];
//        array[0] = array[2];
//        array[2] = temp;
//
//        array[1] = "," + array[1];
//
//        String up = array[2].charAt(0)+"".toUpperCase();
//        array[2] = " ."+up;
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//        }
//
//        System.out.println("\n");
//
//    }

    public static void Name(String name){
        if (name == null){
            System.out.println("名字不能为空...");
            return;//退出
        }

        String [] array = name.split(" ");//用空格划分字符串，意味着每个单词在一个元素里

        //array.length == 3 表示我们的字符串name必须是3个单词，因为我们对字符串用空格做划分当作一个个单词所以用数组来判断
        // array[0].charAt(0) >= 'A' && array[0].charAt(0) <= 'Z' 判断每个单词的第一个字是否是大写，因为小写和大写的ASCII编码不一致所以可以利用这一点进行判断
        if (!(array.length == 3 && array[0].charAt(0) >= 'A' && array[0].charAt(0) <= 'Z' && array[1].charAt(0) >= 'A' && array[1].charAt(0) <= 'Z' && array[2].charAt(0) >= 'A' && array[2].charAt(0) <= 'Z')){
            System.out.println("名字格式不正确!");
            return;
        }


        String formatInfo = "%s ,%s .%c";
        String result = String.format(formatInfo,array[2],array[0], array[0].toUpperCase().charAt(0));//细节，先转换成大写才转成char，否则如果先转char无法使用转大写方法
        System.out.println(result);

    }
}
