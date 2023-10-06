package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex13_exercise02 {
    @Test
    public void test01(){
        /**
         验证电子邮件格式：
         要求：
         1.只能有一个@
         2.@前面是用户名，可以是a-z , A-Z , 0-9
         3.@后面是域名，并且域名只能是英文，比如sohu.com
         4.写出对应的正则表达式，验证输入的字符串是否为满足规则
         */
        String content = "jielim00@gmail.com";

        boolean matches = content.matches("[a-zA-Z0-9_-]+@([a-zA-Z]+\\.)+[a-zA-z]+");
        System.out.println(matches ? "正确格式" : "错误格式");

    }

    @Test
    public void test02(){
        /**
         题目：要求验证是不是整数或者小数
         提示：要考虑正数和负数
         正确答案比如：123 , -345 , 34.89 , -87.9 , -0.01 , 0.45
         不合理的数字：0034
          */
        String content = "0.98";

        boolean matches = content.matches("(-+)?([1-9]\\d*|0)(\\.\\d+)?");
        //(-+)? 表示-或+符号0个或1个，不可以超过1个

        //([1-9]+\\d*|0)  (表示开头的号码只能1-9且出现一次，不能0,后面的号码可以0,可以出现0次或以上)
        //                  但是这个组合出现会阻止0.1这个正常的小数，所以添加一个或0 -> |0
        //                  表示可以单独一个0，且可以阻止01.98这种错误数字，因为不允许0后面紧接一个号码，只能小数点，除非你1-9开头后面才能紧接其他数字
        System.out.println(matches ? "正确格式" : "错误格式");
    }

    @Test
    public void test03(){
        /**
         对一个url进行解析：
         https://www.sohu.com:8080/abc/index.htm
         1. 要求得到协议是什么？  http
         2. 域名是什么？    www.sohu.com
         3. 端口是什么     8080
         4. 文件名是什么    index.htm
         */

        String content = "https://www.sohu.com:8080/abc/index.htm";
        String regStr = "(https|http)://(www\\.([a-zA-Z0-9_-]+\\.)+com):(\\d+)([\\w-/_]*/([\\w.-]+))";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(4));
            System.out.println("文件名：" + matcher.group(6));
        }
    }
}
