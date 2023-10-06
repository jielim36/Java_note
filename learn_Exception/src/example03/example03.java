package example03;
/*
常见的五种运行时异常
 */
public class example03 {
    public static void main(String[] args) {

        //1. NullPointerException 空指针异常
        //当应用程序试图在需要对象的地方使用null时，抛出该异常
        String name = null;
        try {
            System.out.println(name.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        java.lang.NullPointerException: Cannot invoke "String.length()" because "name" is null
	        at example03.example03.main(example03.java:12)
         */



        //2. ArithmeticException 数字运算异常
        //当出现异常的运算条件时，抛出此异常。例如：一个整数除以零
        int num1=10;
        int num2 =0;
        int result=0;
        try {
            result = num1/num2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        java.lang.ArithmeticException: / by zero
	        at example03.example03.main(example03.java:23)
         */


        //3.ArrayIndexOutOfBoundsException 数组下标越界异常（超过范围）
        //用非法索引范根数组时抛出异常。如果索引为负或大于等于数组大小，则异常
        int [] array = new int [4];
        try {
            System.out.println(array[4]);//该数组的大小为4,下标是: 0,1,2,3 ，但是这里却要求输出下标4
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
	        at example03.example03.main(example03.java:33)
         */

        //4. ClassCastException类型转换异常
        //当试图将对象强制转换为不是实例的子类时，抛出该异常。例如：
        A obj = new B();//典型的向上转型
        B obj2 = (B)obj;//典型的向下转型
        //错误示范
        try {
            C c2 = (C)obj;//错误的向下转型，因为obj对象的运行类型是B类，但是这里却想要向下转型成C，C类和B类虽然都是继承A类，但两者并没有关系
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        java.lang.ClassCastException: class example03.B cannot be cast to class example03.C (example03.B and example03.C are in unnamed module of loader 'app')
	        at example03.example03.main(example03.java:44)
         */


        //5.NumberFormatException数字格式不正确异常
        //当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当的格式时，抛出异常
        // =>使用异常可以让哦我们确保输入的时满足条件的数字
        String something1 = "1234";
        //将String转换成int
        int n1 = Integer.parseInt(something1);//正确的

        String something2 = "Lim Yee Jie";
        try {
            int n2 = Integer.parseInt(something2);//会发生错误，因为String的内容不是数字
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        /*
        java.lang.NumberFormatException: For input string: "Lim Yee Jie"
	        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	        at java.base/java.lang.Integer.parseInt(Integer.java:665)
	        at java.base/java.lang.Integer.parseInt(Integer.java:781)
	        at example03.example03.main(example03.java:59)
         */


    }
}

class A{}

class B extends A{}
class C extends A{}