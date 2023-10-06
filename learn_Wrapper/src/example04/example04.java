package example04;

public class example04 {
    public static void main(String[] args) {

        //包装类Integer 转换成 String字符串
        Integer i = 100;
        //方法1
        String str1 = i + "";//i + "" 类似于变成 "i";
//        str1获得了i的值，但是i本身没有变化,可以继续使用

        //方法2
        String str2 = i.toString();

        //方法3
        String str3 = String.valueOf(i); //这里传进去的值是要求Object对象，而i是Integer对象，且Integer的父类是Object，所以可以传进去

        //String 转换成 Integer包装类
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//这里使用到了自动装箱 ， 类似于 Integer i2 = 12345;

        //String转换成Integer包装类，依赖Integer包装类的构造器 但是已经过时了，不建议使用
//        Integer i3 = new Integer(str4);
    }

}
