package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 细节部分
 */
public class ex09_Details {

    @Test
    public void test01(){
        /**
         * Java 正则表达式的匹配默认是 " 贪婪匹配 ",指: 优先匹配多的
         * 这里给几个案例,每个案例对应一个方法
         */
        String content = "aaaaaaaa";//八个a
        String regStr = "a{3,6}"; //匹配时java直接匹配到6个
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
        //最后只有输出一次六个a: aaaaaa , 剩下的两个a匹配不上了
        //也就是直接匹配了最多的那个,而不是先匹配3个aaa,然后在匹配其他的
    }

    @Test
    public void test02(){
        /**
         * Java 正则表达式的匹配默认是 " 贪婪匹配 ",指: 优先匹配多的
         * 这里给几个案例,每个案例对应一个方法
         */
        String content = "111111111111";//八个a
        String regStr = "1+"; //匹配字符1,重复1次或以上,和 \\d+类似
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
        //只输出一次,一次性直接匹配全部1

        // 1+ , 1*,1? 都是直接匹配最多重复次数的字符, *和?会多输出一次空白,因为重复0次也会输出
    }

    @Test
    public void test03(){
        /**
         * Java 正则表达式的匹配默认是 " 贪婪匹配 ",指: 优先匹配多的
         * 这里给几个案例,每个案例对应一个方法
         */
        String content = "a1111111aaaaaa";//八个a
        String regStr = "a1?"; //? 表示重复0次或最多一次 , (a1)?的结果是不一样的
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
        /*
        输出:
        找到: a1
        找到: a
        找到: a
        找到: a
        找到: a
        找到: a
        找到: a

        因为只有号码1限制了只能重复0次或1次,所以全部a都能匹配,但是1只能匹配一次
         */
    }

    @Test
    public void test04(){
        /**
         关于指定起始字符 ^ 和不使用的差别
         这里的概念也可以套用在指定结尾字符 $ 上
          */
//        String content = "abc1234"; 可以匹配上,因为开头就是a-z
//        String content = "abc";可以
//        String content = "abc1234ab";可以,因为没有对结尾进行限制,除非使用$
//        String content = "abc1234";
        String content = "1abc1234"; //匹配不上,因为该内容的开头为1,如果regStr没有使用^作为起始字符串就找得到
        String regStr = "^[a-z]+[0-9]*";//开头小写字母,至少1次或以上,0-9结尾重复0次或以上
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
    }

    /**
     * 细节：
     * [] 括号里的字符都是搜索字符本身，而不是元字符的功能，比如[.]和[?]是搜索.和?字符本身
     *
     */
}
