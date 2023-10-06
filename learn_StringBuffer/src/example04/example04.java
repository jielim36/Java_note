package example04;
/*
StringBuffer方法 （CRUD 增删改查）
 */
public class example04 {
    public static void main(String[] args) {

        //增加
        StringBuffer sb = new StringBuffer("hello");
        //原本字符串：hello
        sb.append(',');//hello,
        sb.append("老师");//hello,老师
        sb.append("你好").append(100).append(true).append(10.5);//100,true,10.5都会转换成字符串
        System.out.println(sb);//hello,老师你好100true10.5

        //删除
        sb.delete(13,17);//删除13-16位置的字符(不包括位置17)
        System.out.println(sb);//hello,老师你好10010.5

        //改（替换）
        sb.replace(13,17,"xx.x");//把13-16位置的字符替换成replace方法第三个参数的字符串
        System.out.println(sb);

        //插入
        sb.insert(0,"哈哈哈");//在sb字符串的位置0插入一个哈哈哈字符串
        System.out.println(sb);

        //获取长度
        System.out.println(sb.length());

    }
}
