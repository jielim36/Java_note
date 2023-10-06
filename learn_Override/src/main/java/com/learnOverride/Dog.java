package com.learnOverride;

import org.w3c.dom.ls.LSOutput;

public class Dog extends Animal{


    public void test() {
        System.out.println("here is Class dog");
    }

    public String test2(){
        return null;
    }

//    public Object testX(){  //Override with parent class,
                              // cant use child cant write the return type greater than parent class
//        return null;
//    }


    @Override
    public AAA test3() {
        return null;
    }
    public BBB test4(){ //return 父类的子类是可以接受的
        return null;
    }

    public void test5(){  // parent class is private and child class is public is allowed
        System.out.println("Modifier");
    }
//    private void test6(){     // parent class is public but child class is private is WRONG
//        System.out.println("Modifier");
//    }


}

class AAA{

}

class BBB{

}
