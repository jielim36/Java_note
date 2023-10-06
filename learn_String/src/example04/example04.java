package example04;

import com.sun.security.jgss.GSSUtil;

/*
String类的常见方法：

注意：
String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低，
因此java设计者还提供了StringBuilder和StringBuffer来增强String的功能，并且提高效率。（后面的example会教）

虽然String的拼接效率比较低，但是在某些情况下还是比较实用的（比如配置文件？）
 */
public class example04 {
    public static void main(String[] args) {

        //第一个方法：equals （有区分大小写
        //懒得举例子

        //第二个方法：equalsIgnoreCase()  （不区分大小写）
        System.out.println("\n\n======\n2:");
        String a = "abc";
        String b = "ABC";
        System.out.println(a.equalsIgnoreCase(b));//true

        //第三个方法：.length() ,获得字符串的长度
        System.out.println("\n\n======\n3:");
        System.out.println(a.length());//3

        //第四个方法：indexOf():获取目标字符在目标字符串对象中第一次出现的索引上，索引从0开始，如果找不到，返回-1
        System.out.println("\n\n======\n4:");
        String s1 = "jielim00@gmail.com";
        int index1 = s1.indexOf('@');// @在字符串里是第九个字符，但是从0开始算，所以输出8
        int index2 = s1.indexOf('x');//s1字符串里没有x字符，返回-1
        int index3 = s1.indexOf('l');//s1字符串里有2个l ， 但是indexOf是返回第一次出现的位置，所以输出3
        System.out.println(index1);//输出 8
        System.out.println(index2);//输出-1
        System.out.println(index3);//3
        String s3 = "hahaxxxxhahaxx";
        int index5 = s3.indexOf("haha");
        int index6 = s3.indexOf("xx");
        System.out.println(index5);//0
        System.out.println(index6);//4 , 获取xx目标的第一个位置，比如这个index6的xx字符是4和5位置，但是只输出4(第一个)


        //第五个方法：lastIndexOf : (和indexOf反着获取，其他保持一致)获取目标字符在目标字符串对象中最后一次出现的索引上，索引从0开始，如果找不到，返回-1
        System.out.println("\n\n======\n5:");
        String s2 = "axxa";
        int index4 = s2.lastIndexOf('a');
        int index7 = s2.lastIndexOf("xx");
        System.out.println(index4);//输出3 ， s2字符串的第0和第3个位置都是a，该方法获取最后的位置
        System.out.println(index7);//虽然lastIndexOf寻找字符是获取最后一个的，但是如果找的是字符串还是先输出第一个（和indexOf的一样）

        //第六个方法：substring 截取指定范围的子串
        System.out.println("\n\n======\n6:");
        String name = "hello,Jielim";
        System.out.println(name.substring(5));//从name字符串的第五个位置开始截取（包括第五个位置）
        System.out.println(name.substring(0,5));//截取name位置0到5区间的字符（包括0但不包括第五个）,name的位置0是'h',name的位置5是',' 所以输出hello（所以截取并输出了0-4位置的字符）

        //第七个方法：toUpperCase 转大写 和 toLowerCase转小写
        System.out.println("\n\n======\n7:");
        String s4 = "lim yee jie";
        System.out.println(s4.toUpperCase());//转大写后原本的s4指向的字符串并不会更改
        String s5 = "LIM YEE jie";
        System.out.println(s5.toLowerCase());

        //第八个方法：concat拼接字符串
        System.out.println("\n\n======\n8:");
        String s6 = "宝玉";
        s6 = s6.concat("林黛玉").concat("雪豹").concat("together");
        System.out.println(s6);

        //第九个方法：replace(a , b)
        System.out.println("\n\n======\n9:");
        String s7 = "limxxxxxyeexxxxxjie";
        //参数：左边参数target是想要替换的字，右边参数replacement是改变成什么参数
        System.out.println(s7.replace("x","_"));
        System.out.println(s7);//注意：原本的s7字符串并没有改变，除非进行赋值

        //第十个方法：分割字符串变成数组
        //注意：对于某些分割字符，我们需要转义 比如 | \\ 符号等等
        System.out.println("\n\n======\n10:");
        String s8 = "aa,bb,cc,dd,ee";
        String [] s9 = s8.split(",");
        System.out.println(s9.length);//输出5, 该数组的格子数量是利用我们所要求的目标（比如逗号）分割后取得的一个个格子（比如aa一个格子，bb一个格子..以此类推）
        for (int i = 0; i < s9.length; i++) {
            System.out.print(s9[i]);//遍历输出
        }

        System.out.println("\n");
        String s10 = "E:\\\\fileA\\\\fileB";// 像\\和 | 这种敏感符号需要使用转义字符（转义字符：\ ）
        System.out.println(s10);//输出E:\\fileA\\fileB
        String [] s11 = s10.split("\\\\");
        for (int i = 0; i < s11.length; i++) {
            System.out.print(s11[i]);//遍历输出
        }


        //第十一种方法：toCharArray 把字符串转成toCharArray字符数组
        System.out.println("\n\n\n======\n11:");
        String s12 = "happy";
        char [] s13 = s12.toCharArray();
        for (int i = 0; i < s13.length; i++) {
            System.out.println(s13[i]);
        }

        //第十二种方法： compareTo 比较两个字符串的大小
        //如果前者大，返回正数，反之就返回附属，如果相等，返回0(如果字符串长度不一致)
        System.out.println("\n\n======\n11:");
        String s14 = "jbck";
        String s15 = "jack";
        String s16 = "jdzk";
        String s17 = "jdzk";
        String s18 = "jac";
        System.out.println(s14.compareTo(s18));//如果两个字符串的长度不一样，则使用字符串长度对比：左边-右边
        System.out.println(s18.compareTo(s14));
        /*
        如果两个字符串长度相同，则看双方的字符第几个开始不一样，然后对比(类似于我们电脑的系统文件夹对文件名的顺序排序)
        jbck和jack对比就是找到了第二个字符不一样，然后如果是英文字就a到z= 1到26（汉字看Unicode）
        jbck和jack对比会输出1 : b - a = 2 - 1 = 1
        字符串长度一致但是如果有超过1个以上的字符不相同，还是只看第一个不一样的字符
         */
        System.out.println(s14.compareTo(s15));//b - a = 2 - 1 = 输出 1
        System.out.println(s15.compareTo(s16));//a - d = 1 - 4 = 输出-3
        System.out.println(s16.compareTo(s17));//所有一样就返回0

        //第十三种方法：format()
        System.out.println("\n\n======\n13:");
        String name1 = "Lim Yee Jie";
        int age = 19;
        double score = 99.356;
        char gender = 'M';
        String formatInfo = "我的姓名是%s  , 今年%d岁  , 成绩是%.2f  ， 性别是%c  ";
        /*
        %s , %d , %.2f ， %c 都是占位符：提前占好位置之后填充
        %s = String类型
        %d = double类型
        %.2f  = 保留两个小数点
        %c = char类型
         */
        String s19 = String.format(formatInfo , name , age , score , gender);
        //name,age等数据需要遵循formatInfo内的占位符顺序，类似向方法传参数一样需要注意顺序
        System.out.println(s19);



    }

}
