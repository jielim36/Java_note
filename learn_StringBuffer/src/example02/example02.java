package example02;
//StringBuffer的各种构造器

public class example02 {
    public static void main(String[] args) {

        //StringBuffer的各种构造器

        //StringBuffer() 无参构造器：构造一个其中不带字符的字符串缓冲区，其初始容量为16字符
        StringBuffer a = new StringBuffer();

        //StringBuffer(CharSequence seq)构造一个字符串缓冲区，它包含与指定的CharSequence相同的字符
        //用的不多，不举例

        //StringBuffer(int capacity) //capacity容量： 构造一个不带字符且可以指定char[]大小的StringBuffer
        StringBuffer b = new StringBuffer(100);

        //StringBuffer(String str)：构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容
        StringBuffer c = new StringBuffer("testing something");//细节：char[]大小是字符串+16 ， （猜测：如果字符串长度大于Integer.MAX_VALUE-16,就创建一个大小为Integer.Max_Value的数组）
        System.out.println(Integer.MAX_VALUE);

    }
}
