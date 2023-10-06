package com.differentPackage;

import com.myCompany.ProjectName.things.Aclass;

public class differentClass_testing {

    public static void main(String[] args) {
        Aclass aclass = new Aclass();
        System.out.println(aclass.num1); //public modifier can access if different package
//        System.out.println(aclass.num2); cant access except public modifier
//        System.out.println(aclass.num3);
//        System.out.println(aclass.num4);
        aclass.print();//different package also can use the public method to access some data for private modifier
                        // but if the method is not use the public modifier, different package cant access

//        aclass.printPrivate(); //it is private modifier method, so cant access
        aclass.testPublic();
//        aclass.testProtected(); different package cant use protect
//        aclass.testDefault(); diffent package cant use default
//        test.testPrivate();  private method also cant use


    }

}
