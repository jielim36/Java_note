package example14;
/*
throws 和 throw的区别
1.throws：
 意义：异常处理的一种方式
 位置：方法声明处
 后面跟的东西：异常类型（比如：NullPointerException ->完整：throws NullPointerException）

2.throw：
 意义：手动生成异常对象的关键词
 位置：方法体中
 后面跟的东西：异常对象



 */
public class example14 {
    public static void main(String[] args) {

    }
}
/*
进入方法A
用A方法的finally'
制造异常
进入方法B
调用B方法的finally
 */
