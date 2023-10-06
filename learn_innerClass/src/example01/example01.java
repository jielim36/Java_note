package example01;
/*
一个类的内部又完整的嵌套另一个类的结构。被嵌套的类称为内部类（inner class）,嵌套其他类的类称为外部类（outer class）。
是我们类的五大成员 ： 1.成员变量（属性） 2.构造方法（构造器） 3.成员方法（方法）  4. 代码块   5.内部类

内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系

内部类的分类有四种：

-定义在外部类的局部位置上（比如方法内和代码块内）
1. 局部内部类（有类名）
2. 匿名内部类（没有类名） ！！重点！！

-定义在外部类的成员位置上
3. 成员内部类（ 没有用static修饰）
4. 静态内部类（使用static修饰）
四种类型会在后续的example解释

 */
public class example01 { //外部其他类
    public static void main(String[] args) {

    }
}

class OutSide{//外部类
    private int a = 10;//member variable

    public OutSide(int a) { //constructor
        this.a = a;
    }

    public void say(){ //method
        System.out.println("say something");
    }

    {//代码块 code block
        System.out.println("code block");
    }

    class InSide{//inner class内部类

    }


}
