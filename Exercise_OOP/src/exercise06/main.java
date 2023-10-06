package exercise06;

public class main {

    /*
    关于访问修饰符和this and super.

    问题： 假定Grand， Father ， Son 在同一个包,他们之间是父子类关系
        父类和子类中通过this和super都可以调用那些属性和方法？
        注意：super调用父类的属性或方法时需要注意访问修饰符modifier



    答：总而言之，this的查找规则是从本类开始查找，如果有，则调用，没有就去父类继续查找，重复这个步骤一直到最顶端（Object类），this通常表示当前对象
               而super是直接访问父类的属性和方法，而且在子类中的构造器必须要有super，super通常是子类中访问父类对象


    答： 在this中：this可以访问本类和父类的属性和方法（注意访问修饰符）
                  当我们创建多态对象比如： grand person1 = new son();
                  如果grand和son有重写的属性或方法时，使用super可以调用父类的，使用this可以调用本类（son）的
                  在通常情况下，this是访问当前的类（对象），比如在形参中引入对象时，就是使用this.


        在super中：super是当我们要调用父类的属性或方法时使用的，值得注意的是子类的构造器里一定会有super，如果没有写也会有默认的super
     */

    public static void main(String[] args) {

        testingModifier a = new testing2();

        System.out.println(a.num1);//100
        a.getNum1();//200


        a.num1 = 0;
        a.num2 = 0;
        a.num3 = 0;//default可以在同包不同类和class
//        a.num4 = 0;

    }

}
