package example01;
/*
StringBuffer类
1.java.lang.StringBuffer代表可变的字符序列，可以对字符串内容进行增删。
2.很多方法与String相同，但StringBuffer是可变长度
3.StringBuffer是一个容器

细节:
1.StringBuffer类是父类是AbstractStringBuilder
2.在父类AbstractStringBuilder类里有char[]value数组，但不是final修饰的（String类的value数组是final修饰的）
3.StringBuffer类是一个final类，不可继承
4.由于StringBuffer的value数组不是final的，所以该数组是变量，也能存放变量字符串
5.StringBuffer保存的是字符串变量（所以存放在堆空间），里面的值可以更改，每次对某个StringBuffer数据更改值实际上就是直接更改其内容
  不需要在常量池创建新的常量字符串对象然后指向它（不需要每次都更新地址（创建新对象）），所以效率较高。


String vs StringBuffer

1.String保存的是字符串常量，里面的值不能更改，
  每次对某个String数据更改值实际上是更改了地址（在常量池创建了新的值然后指向它），效率较低

2.StringBuffer保存的是字符串变量（所以存放在堆空间），里面的值可以更改，每次对某个StringBuffer数据更改值实际上就是直接更改其内容
  不需要在常量池创建新的常量字符串对象然后指向它，所以效率较高。
 */
public class example01 {
    public static void main(String[] args) {

    }
}
