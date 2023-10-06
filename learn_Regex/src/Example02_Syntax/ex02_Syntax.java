package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 正则表达式语法
 基本介绍：
 如果要灵活运用正则表达式Regular Expression(Regex), 必须了解其中各种元字符的功能
 元字符功能大致上分为：
 1.限定符 - 限定它出现的次数
 2.选择符 - 选择A还是B出现
 3.分组组合和反向引用符 -
 4.特殊字符 -
 5.字符匹配符
 6.定位符
 */
public class ex02_Syntax {

    @Test
    public void test01(){

        /**
         元字符（Metacharacter） - 转义号 \\
         \\ 符号：在我们使用正则表达式去检索某些特殊字符的时候，需要使用转移符号，否则检索不到结果，甚至会报错的。
         案例：用 $ 去匹配 "abc$(" 会怎样？

         应用场景：当我们需要使用这些字符： .  *  +  (  )  $  /  \ ? [  ]  ^  }   {
         这些需要转义的字符通常是因为有功能会需要用到这些字符，所以如果我们需要匹配这些字符需要转义

         题外话: Java语言的转义是 \\ , 其他语言的转义都是 \ (单个斜杠)
         */

        String content = "abc$(abc(123(";
        //匹配
        String regStr = "\\("; //当我们要匹配 ( 符号时，会报错，需要使用\\进行转义才可以
        //注意：如果我们要匹配 . 符号，写成 //.  , 如果只有.其实不会报错，但是功能不一样，功能是把全部字符都匹配到
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }

    }
    @Test
    public void test02(){
        /**
         元字符 - 字符匹配符
         符号          含义                     示例                  解释                                              案例
         []      可接受的字符列表               [efgh]            e,f,g,h中任意一个字符                                   e,f,g,h
         [^]     不接受的字符列表               [^abc]            除了a,b,c之外的任意一个字符，包括数字和特殊符号              d,e,f
         -        连字符                       A-Z              任意单个大写字母                                         N,B.V
         .       匹配除了\n以外的任何字符        a..b             以a开头，b结尾，中间有2个任意字符，总长度为4的字符串         avvb,a88b
         \\d    匹配单个字符字符,类似[0-9]      \\d{3}(\\d)?     包含3个或4个数字的字符串                                 123,9876
         \\D    匹配单个非数字字符,类似[^0-9]    \\D(\\d)*        以单个非数字字符开头，后接任意个数字符的字符串              a,A342
         \\w    匹配单个数字，大小写字母字符     \\d{3}\\w{4}     以任意三个数字开头，以任意四个数字或大小写字母结尾          9991234,1239BcD
                  相当于[0-9a-zA-Z]
         \\W    匹配单个"非"数字,大小写字母字符   \\W+\\d{2}      以"至少"单个非数字或大小写字母字符开头                       #12,#?@10
                相当于 [^0-9a-zA-Z]                            和两个任意数字字符结尾的字符串
         \\s    匹配任意空白字符(空格和制表符)    [A-Z]\\s[a-z]   大写字母开头，中间空格，结尾小写字母                      A b,A\tn
         \\S    匹配除了空白字符以外的字符
         */

        String content = "#122244BAzzdBa@123%CmmD";
        String regStr = "[A-Z]{2}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
    @Test
    public void test03(){
        /**
         Java正则表达式默认区分大小写，比如 [a-z]和[A-Z]分别是任意小写字母和任意大写字母（有区别）
         如何实现不区分大小写？
         可以使用 (?i) , 在这个括号后面的字符都判定成不区分大小写

         (?i)abc   : abc都不区分大小写
         a(?1)bc   : a区分大小写，bc不区分
         a((?i)b)c : 只有b不区分，因为被括号包起来
        Pattern pattern = Pattern.compile(regStr,PatternCASE_INSENSITIVE);
         */

        String content = "abcABC";
//        String regStr = "(?i)abc"; 不区分大小写
        String regStr = "abc";
        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE); //在参数后面多加一个参数：Pattern.CASE_INSENSITIVE
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
    @Test
    public void test04(){
        String content = " A B C\tb";
//        String regStr = ".";  包括空白字符也都匹配上
//        String regStr = "[^\\s]";  //除了空白字符
//        String regStr = "\\S"; //和第二个一样，除了空白字符都匹配上
        String regStr = "[A-Z]\\s(?i)[A-Z]";//开头大写,中间空白,结尾任意大小写字母
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
