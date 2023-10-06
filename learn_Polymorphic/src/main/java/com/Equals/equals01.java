package com.Equals;

public class equals01 {

    public static void main(String[] args) {

        // == 比较运算符 和 equals 的对比

        // == 是一个比较运算符
        //1.可以判断基本类型，又可以判断引用类型
        //如果判断基本类型，判断的是值是否相等
        //如果判断引用类型， 判断的是地址是否相等， 即判定是不是同一个对象
        System.out.println(" == 比较运算符 : ");
        double num1 = 10.0;
        int num2 = 10;
        System.out.println("1:");
        System.out.println(num1 == num2);//true

        System.out.println("2:");


        B test1 = new B();
        B test2 = test1;
        B test3 =test2;
        System.out.println(test1 == test3);//true
        System.out.println(test2 == test3);//true
        A bObj = test1;//此代码类似于-->  A bObj = new B();，但是这个是指向了test1的地址
        System.out.println(bObj == test3);//true  ，无论编译类型如何，他们指向的地址还是一致的就是true

        System.out.println("5：");
        A test4 = new B();
        A test5 = new B();
        System.out.println(test4 == test5);//false ， 虽然他们都是指向B，但是他们是不同的地址


        //equals方法是Object类中的方法， 只能判断引用类型，但是判断的是引用类型的值是否相等

        System.out.println("\n\nequals ：");
        "hello".equals("abc");//false

        // 提示：可以光标放在equals这个方法源代码上按ctrl + b 可以查看源代码
        //Integer 和 String 类的对象都是有对equals方法有重写的，所以判断的是两者的值是否相同

        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.print("比较运算符：");
        System.out.println(integer1 == integer2);//false ， ==判断的是两个对象的地址是否相同
        System.out.print("equals方法：");
        System.out.println(integer1.equals(integer2));//true , equals在有重写的情况下判断的是两个对象的值是否相同




        String str1 = new String("hahaha");
        String str2 = new String("hahaha");
        System.out.println(str1 == str2);//false
        System.out.println(str1.equals(str2));//true

        A test6 = new A();
        A test7 = new A();
        System.out.println("判断A类的equals");
        System.out.println(test6.equals(test7));


        /*
        总结： 对于基本类型而言：
              只能用 == 比较运算符 ， 判断的是两者的值是否相等

              对于引用类型而言：
              ==比较运算符 ， 判断的是两者的地址是否相等
              equals方法， 在有重写的情况下是判断的是两者的值是否相等，没有重写的时候判断的是两者的地址是否相同
         */

        /*
        细节：

        equals方法是Object类里的方法
        但是Integer和String等Object的子类也有equals方法
        这个情况也就是equals方法被重写override了
        所以当普通的对象使用equals时是判断两者的地址是否相同
        但是使用Integer和String等Object的子类当作对象的话equals会重写，Integer和String里的equals方法代码是不一样的
        所以导致使用Integer的两个对象比较时使用equals却是判断两者的值是否相等

        Object中的equals方法源代码：

        public boolean equals(Object obj) {
        return (this == obj);


        Integer中的equals源代码：

        public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }

    String里equals的源代码也和Integer不一样

    }


         */
        A test8 = new A();
        A test9 = new A();
        B test10 = new B();
        C test11 = new C();

        System.out.println(test8 == test9);//可以执行 ， 同类之间可以互相比较
        System.out.println(test8 == test10);//可以执行 ， 父类和子类也可以比较
//        System.out.println(test8 == test11); 报错了， 因为A和C不是同一个类或其子类



    }

}

class A{

}

class B extends A {

}

class C{

}
