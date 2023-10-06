package com.conpany.learnJava.keywordSuper;

public class Super {

    public static void main(String[] args) {

        System.out.println("Object person1");
        B person1 = new B();
        person1.call();
        person1.test();

        System.out.println("Object person2 :");

        B person2 = new B(2); //use another constructor to call test method


        System.out.println("Object Person3 : ");
        B person3 = new B(2,3);

        System.out.println("Object Person4 : ");
        B person4 = new B(2,3,4);

        System.out.println("Object Person5 : ");
        B person5 = new B(1); //test field
        person5.testField();

        System.out.println("Object Person6 : ");
        B person6 = new B("test"); //test field


        //In summary, when parent class and child class have same variable name method and same parameter type,
        //1. System will 依照我们写入的代码在哪里call就在该code的class开始找, (总结来说, 从本类开始寻找)
        //2. 如果本类没有, 就开始向父类寻找, 父类没有又继续向父类的父类找
        //3. 如果父类和父类的父类(爷爷)都有一样的method, 但是父类的是private, 系统不会跳过去寻找爷爷, 而是直接报错
        //4. 如果有super.test(); 就可以优先从父类寻找method
        //4. refer参考 our code, Object person1 is use person1.test(); can directly call the class B.
        //5. and refer object person3, the code go to class B and
        //   class B constructor use super.test() to call parent class method test();.
        //6. refer object person4, the code is go to classA constructor and there are code ( this.test() )
        //   but also find the test(); method in class B first because this object is create by class B
        //   so that means code (this) is class B.

        /*
        * super关键字不只是找父类, 也能找爷爷类, 但是是从父类开始找
        * 比如父类和爷爷类里, 父类 a =100 , 爷爷类 a= 900 , 此时子类用super.a 的话就是得到100
        * 如果只有爷爷类有b = 100 , 而父类没有b变量, 此时子类使用super.b将会得到100 , 原理是父类找不到b就去爷爷类找
        *
        *
        */


        /*
        Question : so What different (this) and (super) ?

            if parent class and child class have the same method (override重写), use (super) this code can
            find the method in parent class first, and no write : test();  or use this.test(); can find the method
            from child class first , and if child class didn't have , then go parent class find.
            But if this program have no override, so use (super) and (this) is same.

        */

        /*
        *               !!! 查找父类和子类的属性field或方法method的顺序 !!!
        *
        * 属性field
        * when we find the field, the system will find the target start finding at parent class
        * 但是在父类找到目标后如果又在子类看到相同的目标, 此时将会替换子类的值, (可以参考 object person5)
        * 但是如果输出的时候使用super.a的话却又是直接拿父类的值, (参考person6)
        *
        *方法method
        * when we find the method, the system will find the target start finding at child class
        * but if we use super.xxx can find in parent class
        *
        * */


    }

}
