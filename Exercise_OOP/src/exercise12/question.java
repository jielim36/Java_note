package exercise12;

public class question {
/*
问题 1 ： 什么是多态，多态的具体体现有哪些？
答： 多态是指一个对象的编译类型和运行类型是不一致的对象，具体实现的代码是： 父类  变量名 = new 子类（参数);
    它的特点是运行类型可以变化，比如父类Food的两个子类有chicken 和 Beef ,
    然后创建了a对象 ： Food a = new chicken();之后还可以a = new Beef();进行变化成Beef

    具体体现 1：
    可以用于调用某个方法时，比如feed方法里有一个有参（父类 变量名），内容是display 一个人吃了(对象)
    然后我们引入的对象可以是chicken运行类型或者beef运行类型

    具体代码(这个代码不是完整代码，因为没有实际运行过不知道是否有Bug，想要看例子可以去找desktop里java file中的learn_polymorphic项目file)：

    public void feed(Food a){
      sout("有个人吃了" + a.getName()); //这里不一定是name，可以是其他的东西
    }

    具体体现 2：
    第二个用法是在创作几个对象时，可以使用父类（编译类型）创作数组，给每个数组赋予想要的运行类型（子类），
    具体可以看这个项目file的exercise11





    官方答案：
    多态： 方法或对象有多种形态，是OOP的第三大特征，是建立在封装和继承基础之上的

    多态的具体体现:
    1. 方法的多态 ： 重载和重写  Overload and Override
    2. 对象的多态（重要）：
       ->对象的编译类型和运行类型可以不一致
       ->编译类型编译后就不能更改
       ->对象的运行类型是可以变化的，可以通过getClass() 来查看运行类型 （getClass是Object类的一个方法） 具体代码： 对象变量名.getClass()
       -> 编译类型看 = 左边的类， 运行类型看右边  Person a = new Student();  Person编译类型 ； Student运行类型
       -> 对象的多态有 向上转型 和 向下转型



 */

}
