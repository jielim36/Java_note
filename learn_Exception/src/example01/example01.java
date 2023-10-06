package example01;
/*
Exception - 异常
 */
public class example01 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;
        int result = 0;// 10除于0 ， 在数学中分母为0是无法获得答案的，在计算机领域也一样，所以会抛出“异常”
//        System.out.println(result);

        /*
        输出结果：
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	    at example01.example01.main(example01.java:9)

	    可以发现错误是ArithmeticException (算术异常)

        我们认为计算机不应该出现这样的问题->明明是一个不致命错误却让整个程序无法运行（因为算术错误就直接退出程序了）
        这时候java设计者提供了一个叫 异常处理机制 来解决这个问题。
        如果程序员认为某段代码可能会出现异常/问题，可以用try-catch异常处理机制来解决，从而保证程序的健壮性
         */

        //选中（highlight）有可能出现的异常的代码，使用快捷键:ctrl + alt + t ,选择第六个:try-catch,就会自动生成代码
        try {
            result = n1 / n2;
        } catch (Exception e) {
            e.printStackTrace();//输出错误信息（红色字那个）
            System.out.println("出现异常的原因："+e.getMessage());//输出结果：“ / by zero ”，告诉我们错误原因是因为 除于0 （比上面的更干净一点）
        }
        //原理：尝试运行 result = n1 / n2; ,如果有异常，就catch（捕获）该信息，并且继续执行程序不会中断
        System.out.println("程序继续执行...");
    }
}
