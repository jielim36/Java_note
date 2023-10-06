package example04;
/*
匿名内部类
创建类的匿名内部类注意事项：
1. 匿名内部类里不允许写构造器
 */

public class example04 {
    public static void main(String[] args) {
        new outer().method();
    }
}

class outer{
    public void method(){
        Father father1 = new Father("HoHo");//普通创建对象 , 编译类型Father,运行类型Father
        Father father2 = new Father("Lim Yee Jie"){//创建匿名内部类(匿名内部类的特征就是有大括号)
            //father2的编译类型是Father，编译类型是outer$1 (外部类名+$1)
        };
        father2.test();
        /*
        底层代码中：

        class outer$1 extends Father{   //注意：里面就算是空也可以，因为Father类中本身就有自己的代码了，不需要像接口一样需要去实现抽象方法
        }                               //但是如果是抽象类，这里就必须实现抽象类中的抽象方法
         */

        Father father3 = new Father("HIahiaiha"){

            @Override
            public void test() {
                System.out.println("I say " + getName() + "  (Override method)");
            }
        };

        father3.test();

        //测试普通对象和匿名内部类的运行类型
        System.out.println("\n测试运行类型：");
        System.out.println(father1.getClass());//Father
        System.out.println(father2.getClass());//outer$1
        System.out.println(father3.getClass());//outer$2

    }


}
class Father{
    private String name;
    public Father(String name) {
        this.name = name;
        System.out.println("Constructor name : " + this.name);//匿名内部类在形参中传入的值也会来到这里
    }
    public void test(){
        System.out.println("My name is "+ this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}