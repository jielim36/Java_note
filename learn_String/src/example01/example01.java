package example01;
/*
String类

1.String对象用于保存字符串，也就是一组字符序列
2.字符串常量对象是用双引号括起来的字符序列。例如："你好" , "12.97" , "boy"
3.字符串的字符使用Unicode字符编码，一个字符（不区分字母和汉字）占两个字节
4.String类较常用的构造方法（其他的看源码或API手册或网上），该project的String_diagram上有展示
  常用： 1.String s1 = new String();
        2.String s2 = new String(String original);
        3.String s3 = new String(char [] a);
        4.String s4 = new String(char [] a , int startIndex , int count);
        5.String s5 = new String(byte [] b);
-
 */
/*
细节：
1.看Project的String_diagram里String有实现一个Serializable接口，
  实现了该接口代表我们的对象是可以串行化的，意味着可以在网络上传输
2.String类实现了Comparable接口，代表这个对象可以相互比较（大小）。
3. String类是一个final类，不能被其他类继承
4.String类里有一个很重要的field字段，
就是private final char value[] 它是个数组
  -value[] 源代码说明：该值用于字符存储
  -也就是说我们的字符串内容其实都是保存在该char数组的
  -重点：字符串的本质是char数组
  -注意：value数组是一个final类型，不可以修改
  （地址不可以修改，内容可以修改)
   (比如value指向tom之后就不能指向jack，但是可以对tom这个内容的单个字符修改)
   例子：
   final char [] value = {'T','o','m'}; //final修饰的value数组
   value[0] = 'H'; //对内容字符修改是可以的
   char [] v2 = {'J','a','c','k'};
   value = v2;//错误，不能将value指向其他地址
 */
public class example01 {
    public static void main(String[] args) {

        //jack就是一个字符串常量，然后让name指向该常量，
        // 注意：name是变量,"jack"是常量
        String name = "jack";
        name = "tom";//name是变量，可以改变它指向的地方


    }
}
