package Example02_Syntax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex01_sourceCode {
    public static void main(String[] args) {
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
                "2000年5月29日，JDK1.4发布\n" +
                "2001年6月5日，NOKIA宣布，到2003年将出售1亿部支持Java的手机\n" +
                "2001年9月24日，J2EE1.3发布\n" +
                "2002年2月26日，J2SE1.4发布，自此Java的计算能力有了大幅提升\n" +
                "2004年9月30日18:00PM，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE1.5更名为Java SE 5.0\n" +
                "2005年6月，JavaOne大会召开，Sun微系统公开Java SE 6。此时，Java的各种版本已经更名，以取消其中的数字“2”：J2EE更名为Java EE，J2SE更名为Java SE，J2ME更名为Java ME\n" +
                "2006年12月，Sun微系统发布JRE6.0\n" +
                "2009年12月，Sun微系统发布Java EE 6\n" +
                "2010年11月，由于Oracle公司对于Java社群的不友善，因此Apache扬言将退出JCP[17]\n" +
                "2011年7月28日，Oracle公司发布Java SE 7\n" +
                "2014年3月18日，Oracle公司发布Java SE 8\n" +
                "2017年9月21日，Oracle公司发布Java SE 9\n" +
                "2018年3月21日，Oracle公司发布Java SE 10\n" +
                "2018年9月25日，Oracle公司发布Java SE 11 (LTS)\n" +
                "2019年3月，Oracle公司发布Java SE 12\n" +
                "2019年9月，Oracle公司发布Java SE 13\n" +
                "2020年3月，Oracle公司发布Java SE 14\n" +
                "2020年9月，Oracle公司发布Java SE 15\n" +
                "2021年3月，Oracle公司发布Java SE 16\n" +
                "2021年9月，Oracle公司发布Java SE 17\n" +
                "2022年3月，Oracle公司发布Java SE 18\n" +
                "2022年9月，Oracle公司发布Java SE 19";

        //目标：匹配四个数字连在一起的文字

        //提示： \\d 表示一个任意的数字
        String regStr = "\\d\\d\\d\\d"; //这个是我们编写的“文本匹配机制”
        Pattern pattern = Pattern.compile(regStr);//compile方法内传入我们的"文本匹配机制"

        //创建一个匹配器
        Matcher matcher = pattern.matcher(content);//通过pattern对象的matcher匹配器传入我们的文本内容

        while (matcher.find()){ //mather对象的find方法可以返回boolean值（把它理解成类似Iterator迭代器就好）
            System.out.println("找到: " + matcher.group(0));
        }
        /**
         * matcher.find() 的原理：
         * 1.根据指定的规则("文本匹配机制")，定位满足规则的子字符串(比如文章中的1995)
         * 2.找到后，将子字符串的起始索引记录到mathcer对象中的int数组中(源代码：int[] groups;),
         *   把1995的1的索引0存入在[0]中，把该子字符串的结束索引+1的值记录到int[] groups;
         *   也就是1995的5索引为3+1 = 4 -> [1] groups 中存入4这个值 (因为左闭右开的特性，所以需要+1,下面的group方法源代码有详细解释)
         *   (int[] groups; 默认为20个元素大小，且每个元素内的值默认为-1)
         *   所以现在[0]为1,[1]为4,[2]为-1一直到[19]
         *
         * 3.同时把oldLast属性的值为子字符串的结束的索引+1的值，1995的5为索引3,+1 = 4，存入4
         *   然后while循环就重复执行find方法是，再继续找下一个目标是就会从oldLast属性的值开始找，
         *   所以下一次循环从4这个索引开始找
         *
         * 4.下一次又找到一组匹配的数字时，会再次将起始索引和结束索引+1存入groups数组中的[0]和[1] (所以会替代掉上一组数字的值)，
         *   然后再给group方法根据[0]和[1]内的值当作索引去content中通过这两个索引截取内容并返回
         *   所以我们这个简单的使用只会使用groups数组的2个元素大小，如果是复杂的正则表达会使用多个元素大小
         */

        /**
         matcher.group方法的原理：

         源代码：
         public String group(int group) {
         if (first < 0)
         throw new IllegalStateException("No match found");
         if (group < 0 || group > groupCount())
         throw new IndexOutOfBoundsException("No group " + group);
         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         return null;
         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         }

         1.首先我们需要知道一开始有传给matcher一个文本
           Matcher matcher = pattern.matcher(content);

         3.然后在while循环中有调用group方法并且传入了0这个值
         System.out.println("找到: " + matcher.group(0));

         4.这个0在源代码中就是对应了group这个属性的值

             然后在源码中的最后一行： return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
             这一行是 groups中有两个传参
             第一个: group(也就是0) *2 = [0]
             第二个: group*2 + 1 = [1]
             所以根据groups中[0]和[1]的记录的位置，从content开始截取子字符串并返回
             （其实文本中的1995是 索引0 - 索引3的位置，但是由于”前闭后开“的特性）
             前闭后开/左闭右开：索引[0]-[4] 实际上是截取 [0]-[3]的字符，也就是结束索引的-1才是被截取到的内容
             这也体现了为什么find方法中记录结束索引时会 +1

             例子：
             String str = "abcdef";
             str.substring(0,4); 实际上是截取了abcd字符串(也就是0-4索引可以截取到0索引的数值，但不截取索引4的字符,只截取到索引3)

         5.下一次又找到一组匹配的数字时，会再次将起始索引和结束索引+1存入groups数组中的[0]和[1] (所以会替代掉上一组数字的值)，
           然后再给group方法根据[0]和[1]内的值当作索引去content中通过这两个索引截取内容并返回

         6. group方法传入的值有什么意义？
            例子：System.out.println("找到: " + matcher.group(0));   <- 传入了0

            这个参数的值会涉及到分组
         -分组：在文本匹配机制中的分组
          第一种情况：String regStr = "\\d\\d\\d\\d";  (只有一组)
            这组字符串的起始和结束索引+1会记录在groups数组中的[0]和[1]

         第二种情况：String regStr = "(\\d\\d)(\\d\\d)"; (两组，通过小括号隔开),第一个()内的表示第一组
            第一组的字符串的起始和结束索引+1会记录在groups数组中的[0]和[1]
            第二组的字符串的起始和结束索引+1会记录在groups数组中的[2]和[3]中
            如果有第三组就存入[4]和[5]中，更多组就以此类推

         也就是说，groups数组是以两个元素为一组来记录一组文本的起始和结束索引+1



         */

    }
}
