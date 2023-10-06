package example03;

import com.sun.security.jgss.GSSUtil;

//每个method都是一个练习题
public class example03 {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
    }

    public static void q1(){
        System.out.println("\n=================\nQuestion 1 :");
        Double d = 100d;//自动装箱 Double.valueOf(100d)
        Float f = 1.5f;//自动装箱

        System.out.println(d);
        System.out.println(f);
    }
    public static void q2(){
        System.out.println("\n=================\nQuestion 2 :");
        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1);//输出结果：1.0 ,
        // 因为三元运算符里的Double类型会提升精度，所以即使是输出Integer的数字也会变成Double的精度
        // 三元运算符是一个整体
    }
    public static void q3(){
        System.out.println("\n=================\nQuestion 3 :");

        Object obj2;
        if (true){
            obj2 = new Integer(1);
        }else {
            obj2 = new Double(2.0);
        }
        System.out.println(obj2);//输出结果：1  ,这里没有1.0是因为不是三元运算符，所以正常执行
    }

}
