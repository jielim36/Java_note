package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex08_exercise {

    @Test
    public void test01(){
        /**
         * 汉字验证
         * 目标：验证整个文章是否都是中文，是的话返回 "满足格式"
         */
        String content = "韩顺平教育";
        //目标：验证整个文章的开头和结尾是否都是中文，是的话返回 "满足格式"
        String regStr = "^[\u0391-\uffe5]+$";//这个是网上搜到的十六进制编码的汉字范围,如果文章有字母，这里就不通过,
                                            // 因为+符号表示重复1次或以上，$又表明必须到结尾，所以就变成了从头到尾都必须连续是中文编码范围
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    public void test02(){
        /**
         * 邮政编码
         * 要求：必须是1-9开头的一个六位数，比如：123890
         */
        String content = "911783";
        String regStr = "^[1-9]\\d{5}$";//开头必须1-9，后面需要5个号码。不能直接写[1-9]{6}是因为第一个号码不接受0，但后面5个号码接受0
//        String regStr2 = "^[1-9]\\d{4,9}$";//要求2：开头是1-9，总长度为5位数-10位数
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    public void test03(){
        /**
         * 手机号验证：
         * 要求：必须要以13，14，15，18开头的11位数
         */
        String content = "18993993993";
        String regStr = "^1[3458]\\d{9}$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

    @Test
    public void test04(){
        /**
         * 验证URL网址是否符合规定
         *
         * 思路：
         * 1. 以https或http开头
         * 2. 必须有://
         * 3.必须有www. (这个.必须要转义) ，有时候URL地址会有 - 符号，所以需要[\\w-](接收字符或者-符号)
         * 4. 使用^和$搭配，可以有一次性验证整个字符串内容的效果
         *
         *  ((http|https)://) 匹配  https://
         * ([\w-]+\.)+[\w-]+ 匹配 www.bilibili.com
         *   /[\w-?=&/%.]*)?  匹配  /video/BV1Zk4y177kP/?spm_id_from=333.1007.tianma.1-1-1.click&vd_source=114500c2627a5627c7d30c7176c58bbb
         *
         * GPT答案：String regStr = "^(http|https)://[a-zA-Z0-9]+([\\-\\.]{1}[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,5}(:[0-9]{1,5})?(/[a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~]*)?$";
         */
        String content = "https://www.bilibili.com/video/BV1Zk4y177kP/?spm_id_from=333.1007.tianma.1-1-1.click&vd_source=114500c2627a5627c7d30c7176c58bbb";
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(/[\\w-?=&/%.#]*)?$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
            System.out.println(matcher.group(0));
        } else {
            System.out.println("不满足格式...");
            System.out.println(matcher.group(0));
        }
    }

    @Test
    public void test05(){
        String content = "oooooooooooo";
        String regStr = "o{2,4}?";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }

}
