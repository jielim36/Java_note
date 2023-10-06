package Example02_Syntax;

/**
 * Pattern类：
 * Pattern对象是一个正则表达式对象。Pattern类没有公共构造器。要创建一个Pattern对象，需要调用其公共静态方法(compile方法)，它会返回一个Pattern对象。
 * 该方法接收一个正则表达式作为它的第一个参数， 比如：Pattern ptn = Pattern.compile(pattern匹配规则);
 */

/**
 Matcher类：
 Matcher对象是一个对输入字符串进行解释和匹配的引擎。与Pattern类一样，Matcher也没有公共构造器 Public constructor。
 你需要调用Pattern对象的matcher方法来获得一个Matcher对象。
 */

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PatternSyntaxException
 * PatternSyntaxException是一个非强制异常类，它表示一个正则表达式模式中的语法错误
 */
public class ex10_Pattern_and_Matcher {

    /**
     Matcher类的方法
     1.public int start() - 返回以前匹配的初始索引
     2.public int start(int group) - 返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引
     3.public int end() - 返回最后匹配字符之后的偏移量
     4.public int end(int group) - 返回在以前的匹配操作期间，由给定组所捕获自学列的最后字符之后的偏移量。
     5.public boolean lookingAt() - 尝试将从区域开头的输入序列与该模式匹配
     6.public boolean find() - 尝试查找与该模式匹配的输入序列的下一个子序列
     7.public boolean find(int start) - 重置此匹配器，然后尝试查找匹配该模式，从指定索引开始的输入序列的下一个子序列
     8.public boolean matches() - 尝试将整个区域与模式匹配
     9.public String replaceAll(String replacement) - 匹配到对应的字符串之后，对其更改
     */

    @Test
    public void test01(){
        /**
         * start和end方法：
         * 当find()方法在文本中匹配到对应的字符串时，会记录其起始索引和结尾索引+1 (Example02的ex01源代码解析中有解释)
         * 而start和end方法就可以提取这两个索引并返回
         *
         * 细节：group方法其实也是根据find方法记录的索引来在文本中截取内容并输出的(Example02的ex01源代码解析中有解释)
         */
        String content = "hello edu jack tom hello smith hello";
        String regStr = "hello";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("================");
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            System.out.println(content.substring(start,end));//String类的substring方法，可以截取字符串 （传入 0-5实际上数输出0-4索引的字符）
        }
        /*
        输出结果：
        ================
        start: 0
        end: 5
        ================
        start: 19
        end: 24
        ================
        start: 31
        end: 36

        每一次循环都是对应每一个hello的起始索引和结束索引+1
         */
    }

    @Test
    public void test09(){
        /**
         replaceAll方法：
         可以对匹配到的内容进行更改。并且返回整个被修改后的文本
         */
        String content = "xx hello xx hello, hi";
        String regStr = "hi";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            //目的：把hi更改成hello
            System.out.println(matcher.replaceAll("hello"));//输出结果：xx hello xx hello, hello
        }
    }

    @Test
    public void test08(){
        /**
         * Pattern对象的matches方法
         * 该方法可以直接传入 regStr匹配规则 和 content文本内容
         * 然后可以直接返回一个Boolean值
         * 作用：如果根据匹配规则 对 "整个"文本内容进行匹配时成功匹配上，就返回true，不会返回匹配到的内容
         * 细节：mathces方法会对我们的匹配规则前后加上^ $这两个定位符让匹配规则必须一次性匹配上整个文本内容
         * 应用场景：比如验证邮箱格式时，可以直接使用这个方法返回true false，因为我们不需要输出匹配的内容，只需要了解是否匹配上
         *
         * matches 和 find 方法的却别： find方法会输出匹配的内容，并且不会对匹配规则进行任何更改
         *                            matches方法会返回boolean值，且会对匹配规则的前后加上^ &定位符
         */
        String content = "abcABC";
        String regStr = "abc"; //matches方法的效果会把匹配规则变成类似于："^abc$"  ，因此matches会用在验证整条文本内容是否匹配上
        boolean matches = Pattern.matches(regStr, content);
        System.out.println("是否成功匹配：" + matches);//返回false
    }

}
