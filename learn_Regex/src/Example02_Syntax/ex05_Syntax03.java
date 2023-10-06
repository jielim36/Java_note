package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex05_Syntax03 {
    @Test
    public void test01(){
        /**
         符号          含义                     示例                  解释                                              案例
         ^         指定(文本的)起始字符        ^[0-9]+[a-z]*     以至少一个数字开头,后接任意个小写字母的字符串(中间字符随意)       123,6aa,555edf
         $         指定(文本的)结束字符        ^[0-9]\\-[a-z]+$  任意数字开头,中间-符号,结尾至少一个任意小写字母                 1-a
         \\b       匹配目标字符串的边界         han\\b             字符串边界指子串间有空格或目标字符串的结束位置               xxxxhan,1234han(只输出han,没有输出前面的字)
         \B       和\\b相反,匹配开头的         han\\B            匹配单词的开头为目标字符的                                hanxxxx , "han"1234(只输出han,其他字符只做示范)
         */
        String content = "hanshunping sphan nnhan";//出现了三次han
        String regStr = "han\\b";//只输出处于边界的han
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
        /*
        只输出了两次, sphan 和 nnhan中的han,因为这两个的han在单词的最尾端,第一个hanshunping是在开头
        判断han是否在边界是依据han的后面是否是空白字符或者是content的最尾端
         */

    }
}
