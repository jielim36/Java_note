package Static_example04;

public class main {
    /*
    1.类方法/静态方法的使用场景
    -当方法中不涉及任何和对象相关的成员时，则可以将方法设计成静态方法，可以提高开发效率
    -提高开发效率的原因是：如果我们希望不要创建实例(创建对象)时，也可以调用该类的某个方法（通常是当作工具来使用）
    -这时候把方法变成静态方法是非常合适的
    比如：
        System.out.println("9开平方的结果是 ： " + Math.sqrt(9) )
        这是一个Math类中的方法，此方法是静态方法，可以不需要创建Math对象就能够直接使用该类的对象
    当然也不只是Math类中的sqrt静态方法，程序的很多工具其实都是静态方法，
    包括我自己在Desktop\java file\project_folder中的HouseRentApp里也有自己写一个Utility类当作开发工具使用，我在Utility类里有写入许多静态方法比如readInt,readConfirmSelection等等
     常见的自己创建的静态方法用于当作工具类来使用有： 冒泡排序，打印数组，完成某个计算任务等等...
     */
    public static void main(String[] args) {
        System.out.println(Math.sqrt(9));//3.0   Math类中的sqrt静态方法就是一个将静态方法用于当作开发工具使用的经典案例

        //我自己创建了一个Tools类当作我项目的工具类
        System.out.println(Tools.sum(5,7.7));
    }

    /*
    静态方法注意事项：

    1.非静态方法不能通过类名调用
    -如果想要调用非静态方法就需要创建对象才能调用，
     也能够直接创建匿名对象调用
    -比如： new Tools().say();
     Tools是类的名字，say是Tools类里的方法

    2.静态方法中无this的参数（静态方法里不能使用this）
    -普通方法中隐含this参数

    3.静态方法中不允许使用和对象有关的关键字
    -比如this和super

    4.静态方法中，只能访问静态变量和静态方法 ，
      不能访问非静态变量和方法
    -普通成员方法，即可以访问非静态变量（方法），
     也可以 访问静态变量

    5.无论静态还是非静态的任何方法和变量，
      都必须遵守访问修饰符的访问权限
     */



}
