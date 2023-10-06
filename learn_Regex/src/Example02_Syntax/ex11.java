package Example02_Syntax;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 疑问：
 * 如何判断一个文本内匹配出 四个数字连在一起，且第一个数字与第四个数字相同，第二和第三个数字相同，如： 1221 , 5775
 *
 * 要解决这个问题，需要了解正则表达式的三个概念
 * 1. 分组    2.捕获    3.反向引用
 *
 * 1.分组
 * 我们可以用圆括号组成一个比较复杂的匹配模式，那么一个圆括号的部分我们可以看作一个子表达式或一个分组
 *
 * 2.捕获
 * 把正则表达式中子表达式/分组匹配的内容，保存到内存中以数字编号或显式命名的组里，方便后面引用。
 * 从左到右，以分组的左括号为标志，第一个出现的分组的组编号为1，第二个为2，以此类推。编号0表示整个正则表达式
 * 该编号可以在group方法中使用用于单独输出等作用。
 *
 * 3.反向引用
 * 圆括号的内容被捕获后，可以在这个括号后被使用，从而写出一个比较使用的匹配模式，这个我们称为反向引用，这种引用既可以是在正则表达式内部
 * 也可以在正则表达式外部，内部反向引用 \\ 分组号，外部反向引用 $ 分组号
 */
public class ex11 {

    @Test
    public void test01(){
        String content = "55555";
//        String regStr = "(\\d)\\1"; //如果要匹配两个相同的数字 （\\1表示根据第一组接收到的号码来当作匹配要求，所以第一组接收到9，\\1也就变成9）转换成实际匹配规则就是： regStr = "99";
        /*
        \\1表示根据第一组接收到的号码来当作匹配要求，所以第一组接收到9，\\1也就变成9）转换成实际匹配规则就是： regStr = "99";
        这时候假设content是 98 , 当\\d接收到9了，\\1也随之变成9，可是他去匹配content的第二个号码时发现对方是8，那么就表示不匹配，因为\\1要求是9
         */
        String regStr = "(\\d)\\1{4}"; //如果要匹配5个相同的数字

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }


    @Test
    public void test02(){
        String content = "1551,5005,8998";
        String regStr = "(\\d)(\\d)\\2\\1";
        /*
        "(\\d)(\\d)\\2\\1"
        -解析-
        1.第一个(\\d)表示第一组，接收一个号码 ( 这里实际上是接收了1551的第一个号码1 )
        2.第二个(\\d)表示第二组，接收一个号码 ( 这里实际上是接收了1551的第二个号码5 )
        3. \\2表示调用第二组 , 也就是说当第二组接收到一个5，这里也要求匹配一个5
        4. \\1表示调用第一组，也就是当第一组接收到一个1时，这里也是要求匹配一个1

        所以(\\d)(\\d)\\2\\1 --> 号码A 号码B

         */
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("找到 : "+matcher.group(0));
        }
    }

    @Test
    public void test03(){
        /**
         * 题目：请在字符串中验证商品编号
         * 要求：前面是一个五位数，然后一个 - 符号 ， 接着是一个九位数，该九位数每三位要相同
         * 比如：12321-333555777
         */
        String content = "12377-333555777";
//        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}"; //第一种写法
        String regStr = "\\d{5}-((\\d)\\2{2}){3}";//第二种写法(注意：由于有一个大括号包住里面的(\\d)，所以(\\d)变成了编号2，所以使用\\2)

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }


    @Test
    public void test04(){
        /**
         * 题目：结巴改正程序
         * 案例： 将 我...我要...学学学学..编程Java  更改成 我要学编程Java
         *
         * 提示：这题会使用到外部反向引用 $符号
         */
        String content = "我...我要...学学学学..编程Java ";
        String regStr = "\\.";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            content = matcher.replaceAll(""); //排除全部 . 符号
        }
        System.out.println("第一步：" + content);


//        String regStr2 = "(.)\\1+";
//        Pattern compile1 = Pattern.compile(reagStr2);
//        Matcher matcher1 = compile1.matcher(content);
//
//        while (matcher1.find()){
//            System.out.println("找到：" + matcher1.group(0));//这里匹配到了两个： 1.我我  2.学学学学
//        }
//
//        //这时使用外部反向引用 $号
//        content = matcher1.replaceAll("$1");
//        /*
//        replaceAll("$1")不需要在while循环中使用而是直接一次性可以替换 我我 和 学学学学 两个重复字符的原因：
//
//        反向引用的内容会记录在matcher对象中，所以我们只需要调用一次 matcher1.replaceAll("$1")
//        就可以一次性更改所有的匹配项。在这个例子中，我们只有两个匹配项："我我" 和 "学学学学"。
//        所以，只需要一次调用 matcher1.replaceAll("$1") 就可以同时替换它们
//         */

        //上面注释的全部内容都可以用一行代码概括
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");

        System.out.println(content);
    }
}
