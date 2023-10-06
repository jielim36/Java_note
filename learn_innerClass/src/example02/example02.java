package example02;
/*
局部内部类（定义在外部类的局部位置，比如方法内和代码块内）
1. 可以直接访问外部类的所有成员，包括private（成员变量和成员方法等等）
2.不能添加访问修饰符，因为他的地位就是一个局部变量。局部变量是不能使用修饰符的。
3.可以使用final修饰，因为局部变量也是可以使用final
4.作用域：仅仅在定义它的方法或代码块中
5.如果外部类要使用局部内部类的功能，可以在该局部内部类所处的方法中创建对象，然后调用方法即可.((需要注意的是在该类的下方创建对象，因为如果在类的上方创建对象时系统会认为你没有这个对象，因为你创建对象后才写类
6. 虽然局部内部类可以访问外部的成员，但是外部成员不能访问局部内部类（因为局部内部类是局部变量）
7.如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想要访问外部类的成员，则可以使用（外部类名.this.成员）

 */

public class example02 {
    public static void main(String[] args) {
        outSide a = new outSide();
        a.test();
        System.out.println("Object a hashcode : " + a.hashCode());//用于对比和 outSide.this 的hashcode是否一致来证明是否是同一个对象
    }
}

class outSide{
    private int num1 = 10;//全局变量
    private int same = 0;
    public void test(){
        int a = 10;//局部变量（方法内的变量）

//        inSide obj = new inSide();这里用会报错，因为系统读取这个代码时还未读到class inSide，所以认为这个类是不存在的，所以创建时写在该类的下方

        class inSide{//局部内部类（方法内），该类相当于一个局部变量，所以不能用访问修饰符。但是本质上还是一个类，类的五大成员都可以使用
            int same = 10;

            public void f1(){
                System.out.println("num1 = " + num1);//可以访问外部的全局变量包括private属性
                System.out.println("a = " + a);//可以访问该类所处的方法内的局部变量
                mm();//可以调用private method

                //如果局部内部类的成员和外部类的成员重名，则遵循就近原则，想要调用外部类的就使用（外部类名.this.成员）
                System.out.println("inSide same = "+same);//输出这个类中的same = 10，因为就近原则，优先调用局部的
                System.out.println("outSide same = " + outSide.this.same);//输出外部类的成员 same = 0
                //这里outSide.this.same的本质就是外部类的对象，即哪个对象调用，outSide.this就是哪个对象，
                // 比如这个案例里main方法里以outSide类创建了一个对象a来调用这个方法，所以这里的this代表的就是outSide对象
                System.out.println("outSide.this hashcode : "+outSide.this.hashCode());//可以靠outSide.this和main方法里的a对象的hashcode做对比来证明是同一个对象，如果hashcode一致就是一样
            }
        }

        final class inSide2 extends inSide{ //内部类可以使用final修饰

        }

//        class inSide3 extends inSide2{ } 报错，因为想要继承的class是final修饰

        inSide obj = new inSide();
        obj.f1();
    }

    private void mm(){
        System.out.println("private method");
    }

}
