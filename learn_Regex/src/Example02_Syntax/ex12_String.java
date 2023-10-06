package Example02_Syntax;

import org.junit.jupiter.api.Test;

/**
  String类中有些方法可以直接使用正则表达式，不需要特地繁琐的使用Pattern等类来完成
 1. replaceAll(String regex , String replacement)  - 直接写入匹配规则和替换成什么字
 2. matches(String regex) - 写入匹配规则，如果成功匹配返回true
 3. split(String regex) - 通过匹配规则来分割字符串，变成String数组
 */
public class ex12_String {
    /**
     String类 public String replaceAll(String regex , String replacement) 方法本身就支持正则表达式
     */
    @Test
    public void test01(){
        String content = "1995年5月23日，Java语言诞生\n" +
                "1996年1月，第一个JDK-JDK1.0诞生\n" +
                "1996年4月，10个最主要的操作系统供应商申明将在其产品中嵌入JAVA技术\n" +
                "1996年9月，约8.3万个网页应用了JAVA技术来制作\n" +
                "1997年2月18日，JDK1.1发布\n" +
                "1997年4月2日，JavaOne会议召开，参与者逾一万人，创当时全球同类会议规模之纪录\n" +
                "1997年9月，JavaDeveloperConnection社区成员超过十万\n" +
                "1998年2月，JDK1.1被下载超过2,000,000次\n" +
                "1998年12月8日，JAVA2企业平台J2EE发布\n" +
                "1999年6月，Sun微系统发布Java的三个版本：标准版（J2SE）、企业版（J2EE）和微型版（J2ME）\n" +
                "2000年5月8日，JDK1.3发布\n" +
                "2000年5月29日，JDK1.4发布";

        //目标：将文本中的 JDK1.0 , JDK1.3 等统一替换成 JDK
        content = content.replaceAll("JDK\\d\\.\\d","JDK");//注意：该replaceAll方法是String类的方法
        System.out.println(content);
    }

    @Test
    public void test02(){
        /**
         public boolean matches(String regex) {
                return Pattern.matches(regex, this);
         }
         */
        //目标：要求验证一个手机号，要求必须是以138，139开头的,而且后面有八个数字
        String content = "13812345678";
        boolean matches = content.matches("1(38|39)\\d{8}");//注意：这个matches方法是String类的方法 / matches方法自动对匹配规则加上^ $定位符，表示整体匹配
        System.out.println(matches ? "符合标准 " : "不符合格式");
    }

    @Test
    public void test03(){
        /**
         *
         */
        //目标：按照各种符号来分割字符串
        String content = "hahahah%my$friend#is@idiot";
        String[] split = content.split("[%$#@]");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
