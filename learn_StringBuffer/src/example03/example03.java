package example03;
/*
String和StringBuffer相互转换
 */
public class example03 {
    public static void main(String[] args) {

        //String 转换成StringBuffer
        String s = "hello";
        //方式1
        StringBuffer b1 = new StringBuffer(s);//转换后s数据并没有影响，只是另外通过类似于复制的手段把s的数据复制了用于创建一个StringBuffer对象b1
        //方式2
        StringBuffer b2 = new StringBuffer();
        b2.append(s);


        //StringBuffer 转换成 String 的方法
        StringBuffer sb1 = new StringBuffer("Jie");
        //方式1
        String str = sb1.toString();
        //方式2
        String str2 = new String(sb1);
    }
}
