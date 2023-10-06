package example05;
/*
练习题
 */
public class example05 {
    public static void main(String[] args) {

        q2();
    }

    public static void q1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//看源码：没有异常，源码中append方法把null（空）转换成字符串"null"
        System.out.println(sb.length());//4
        System.out.println(sb);//输出：null字符串


        StringBuffer sb1 = new StringBuffer(str);//报错，因为StringBuffer构造器不支持放入null（源码里会先计算str的字符串长度，但是str是null所以就直接报空指针异常：NullPointerException）
        System.out.println(sb1);//报错
    }
    public static void q2(){
        System.out.println("\n\nq2:\n");
        /*
        题目：输入商品名称和商品价格，要求打印效果
        价格要求：每三位要有一个逗号比如：1000000 -> 1,000,000
         */
        String something = "12345678.90";
        StringBuffer price = new StringBuffer(something);

        //解析：int i = price.lastIndexOf(".")-3 是找到小数点的位置后再-3就获得了第一个需要放逗号的地方
        //迭代：i-=3 意思：一开始用小数点-3找到第一个逗号的位置后，再将该位置-3找到下一个逗号的位置
        //i>0是for loop的终止条件，当逗号的位置前面已经没有号码（i的位置== 0 代表前面没有号码了）就不执行
        for (int i = price.lastIndexOf(".")-3; i > 0; i-=3) {
            price = price.insert(i,",");
        }
        System.out.println(price);
        System.out.println(price.substring(0,5));


    }
}
