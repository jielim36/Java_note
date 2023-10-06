package exercise01;

public class exercise01 {
    /*
    问题： 请编写一个程序，能够解释圆形的面积。要求圆周率为3.14，赋值三种方式都需要用到
     */
    public static void main(String[] args) {
        Circle a = new Circle(5);
        Circle2 b = new Circle2(5);
        Circle3 c = new Circle3(5);

        System.out.println("面积 = " + a.calArea());
        System.out.println("面积 = " + b.calArea());
        System.out.println("面积 = " + c.calArea());
    }
}

class Circle{
    private final static double PI = 3.14;//全局中定义值

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calArea(){
        return PI * radius * radius;
    }
}

class Circle2{
    private final double PI;

    private double radius;

    public Circle2(double radius) {
        this.radius = radius;
        PI = 3.14;//构造器中赋值（构造器里不接受final static属性）
    }

    public double calArea(){
        return PI * radius * radius;
    }

}

class Circle3{
    private final static double PI;
    static{
        PI = 3.14;//代码块中赋值
    }
    private double radius;

    public Circle3(double radius) {
        this.radius = radius;
    }

    public double calArea(){
        return PI * radius * radius;
    }
}