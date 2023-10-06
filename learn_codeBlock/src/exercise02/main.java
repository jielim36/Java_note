package exercise02;

public class main {
    public static void main(String[] args) {

        Test a = new Test();
    }
}

class Sample{
    Sample(String s){
        System.out.println(s);
    }
    Sample(){
        System.out.println("Sample父类默认构造器被调用");
    }
}

class Test extends Sample{
    Sample sam1 = new Sample("sam1 成员初始化");
    static Sample sam = new Sample("静态成员sam初始化");
    static{
        System.out.println("static代码块执行");
        if (sam == null ) System.out.println("sam is null");
    }
    Test(){
        System.out.println("Test子类默认构造器被调用");
    }
}

/*

1.静态成员初始化
2.static块被执行
3.Sample默认构造函数被调用
4.sam1成员初始化
5.test默认构造函数被调用
 */
