package example01;

public class example01 {
}

abstract class A{//当该类中有抽象方法，该类也需要进行抽象修饰

    /*
    思考：这里eat你实现了，但是你发现其实没有什么意义
    即： 父类的方法不确定性的问题
    -考虑将该方法设计为抽象方法 abstract method
    -所谓抽象方法就是没有实现的方法
    -所谓没有实现就是指没有方法体
     */
    //原本没有意义的方法：
//    public void say(){
//        System.out.println("say something...");
//    }

    //更改成：
    public abstract  void say();//把该方法写出来并且给予abstract修饰符，
                                // 而且方法需要abstract时该类也需要进行abstract修饰
                                //抽象方法不需要方法体（内容），方法体包括{}符号
    /*
    一般来说，抽象类会被继承，由其子类来实现抽象方法
    抽象类的价值更多的作用是在于设计，是设计者设计好后，让子类继承并实现该抽象类
    抽象类通常是用于框架或设计模式中（尤其是模板设计模式）
     */
}
