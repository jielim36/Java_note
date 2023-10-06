package example05;
/*
展示一些Integer和Character包装类的常用方法

这里展示的都是极少一部分代码
 */
public class example05 {
    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);//返回最小值
        System.out.println(Integer.MAX_VALUE);//返回最大值

        System.out.println(Character.isDigit('a'));//判断是不是数字 返回true false
        System.out.println(Character.isLetter('a'));//判断是不是字母 返回true false
        System.out.println(Character.isUpperCase('a'));//判断是不是大写
        System.out.println(Character.isLowerCase('a'));//是不是小写

        System.out.println(Character.isWhitespace('a'));//判断是不是空格
        System.out.println(Character.toUpperCase('a'));//转换成大写
        System.out.println(Character.toLowerCase('A'));//转换成小写


    }
}
