package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 关于非贪婪匹配法
 */
public class ex07_nonGreedy {
    /**
     ? 符号 - 当此字符紧随任何其他限定符(*,+,?,{n},{n,},{n,m})之后时，匹配模式转换成“非贪婪匹配”。
              非贪婪匹配模式搜索到的字符串都是尽可能短的，而默认的贪婪匹配是一次性匹配到尽可能多的字符串。
     例如：字符串 "oooooo",使用"o+?"只匹配到单个o，而"o+"直接匹配到全部o
     */
    @Test
    public void test01(){
        String content = "oooooooooooooo";//十四个o
        String regStr = "o{2,4}";//目标：匹配o的数量在2-4之间的（这时是贪婪匹配模式，所以如果能达成4个o就会先优先截取4个o）
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group());//找到了三次4个o后，还找到了一次两个o，因为只剩下两个了
        }
    }

    @Test
    public void test02(){
        String content = "oooooooooooo";//十二个o
        String regStr = "o{2,4}?";//目标：匹配o的数量在2-4之间的（这时是非贪婪匹配模式，一旦匹配到2个o个时直接截取，不继续尝试有没有第三个o）
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group());
        }
    }
}
