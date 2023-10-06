package com.myCompany.ProjectName.things;

public class Test {





    public static void main(String[] args) {
        Aclass test = new Aclass();
        test.print();//如果是调用同一个package下的方法来间接使用该类的private是可以接受的, 但是直接调用test.num4就不行        System.out.println("num1 : " + test.num1);
        System.out.println("num2 : " + test.num2);//same package can access protect modifier
        System.out.println("num3 : " + test.num3);//same package can access default modifier
//        System.out.println("num4 : " + test.num4); 在同一个包package内,可以访问除了private 以外的访问修饰符

        test.testPublic();
        test.testProtected();
        test.testDefault();
//        test.testPrivate();  private method also cant use

    }

}
