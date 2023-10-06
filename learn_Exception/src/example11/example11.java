package example11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class example11 {
    public static void main(String[] args) {//这里也有默认的throws，然后main方法throws抛出给JVM，
                                            // 然后JVM会为我们处理异常，输出异常和退出程序，
                                            //所以运行的时候你可以看到最下面一排是 Process finished with exit code 1 代表退出了程序
        f2();//注意：先调用了f2才调用的f1，因为f1执行后会直接到JVM，然后JVM会处理异常后退出程序
        f1();//main方法是调用者，调用了一个有异常的方法后它有继续throws
    }

    public static void f1()/*throws ArithmeticException*/{ //对于运行时异常时，这里没有写throws和try-catch的话其实还是会有默认的throws的
                            //如果时编译时异常，会直接红字，需要程序员自己处理，比如try-catch 和 throws
        int n1 = 10,n2=0;
        int result = n1/n2;//运行时异常
    }

    public static void f2(){
        //问题：这里调用了f3后为什么会报错呢？
        //因为f3抛出了一个编译时异常，代表这里的f3();也是一个编译时异常了
        //所以必须处理这个异常，可以继续抛出或者使用try-catch
        try {
            f3();
        } catch (FileNotFoundException e) {
            System.out.println("有一个FileNotFound错误");
            e.printStackTrace();
        }
    }
    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("sfdfsfs");//这里有一个编译时异常（直接红色）,异常类型：FileNotFoundException
    }

    public static void f4(){
        f5();//这里不会报错，因为f5抛出的是运行时错误
    }
    public static void f5() throws ArithmeticException{}
}
