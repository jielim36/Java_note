package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex03_Syntax02 {
    @Test
    public void test01(){
        /**
         * 选择匹配符 - | 符号
         */
        String content = "lim yee jie 林";
        String regStr = "lim|林";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
    }
    @Test
    public void test02(){
        /**
         限制符
         符号          含义                     示例                  解释                                      案例
         *      指定字符重复0次或n次             (abc)*      仅包含任意个abc的字符串,等效于\\w*           abc,abcabcabc
         +      指定字符重复1次或n次(至少一次)    m+(abc)*     以至少一个m开头,后接任意个abc的字符串        mmmabcabc,m,mabc
         ?      指定字符重复0次或一次(最多一次)   m+abc?      以至少一个m开头,中间有ab,结尾有0个或一个c      mmabc,mab
         {n}    只能出现n次                  [abcd]{3}    一个长度为3的字符串,内容可以是a,b,c,d任意字符   dbc,add,cab
         {n,}    至少有n次                    [abcd]{3,}    长度至少为3,内容任意a,b,c,d字符              acacddd,aaaaaa,abc,abdc
         {n,m}  至少有n次,不超过m次            [abcd]{3,5}    长度3-5,内容任意a,b,c,d字符              acacd,aaa,abcd,abdc
         */
        String content = "mmabcc";
        String regStr = "m+abc?";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到: " + matcher.group());
        }
    }
    @Test
    public void test03(){

    }
}
