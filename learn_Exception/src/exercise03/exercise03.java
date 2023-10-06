package exercise03;
/*
判断该题目的输出结果：

答案：
B
C
D
 */
public class exercise03 {
    public static void main(String[] args) {
        System.out.println("Exercise 03");
        try{
            func();
            System.out.println("A");//func方法抛回一个异常后直接去catch，这里的A不会输出
        }catch (Exception e){
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void func(){
        try{
            throw new RuntimeException();//这里我的理解是直接强制抛出一个RuntimeException的异常
        }finally {
            System.out.println("B");
        }
    }
}
