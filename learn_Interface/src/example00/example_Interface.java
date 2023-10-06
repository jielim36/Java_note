package example00;

public interface example_Interface {  //语法：  访问修饰符 interface 接口名{...}
    /*接口里可以写
      1.属性
      2.静态方法
      3.抽象方法
      3.普通方法(默认实现方法)
     */
    public int n1 = 10;//属性

    //接口里的抽象方法可以不需要abstract修饰符
    public void aaa();//第一种抽象方法
    public abstract void AAA();//第二种抽象方法

    public default void bbb(){ //普通方法需要default修饰符
        System.out.println("接口里的bbb普通方法");
    }

    public static void ccc(){
        System.out.println("接口里的ccc静态方法");
    }
}
