package example08;
/*
成员内部类的使用：
1.成员内部类定义的位置是一个外部类的成员位置，和其他成员（成员方法和成员属性）的位置一样
2.成员方法也可以直接访问成员属性包括private modifier
3.成员内部类的特点是可以在外部类的范围内创建该类的实例对象
4.作用域：和外部类的其他成员一样，为整个整体
5.访问：成员内部类访问外部类可以直接访问，外部类想要访问成员内部类需要先创建对象
6.外部其他类也可以访问到该类的成员内部类，三种方式：
   -第一种:语法： 外部类名.成员内部类 对象名 = 提前创建过的外部对象.new 成员内部类名();
   -第二种：利用外部类创建一个方法用于返回成员内部类的对象
   -第三种就是将上面两种融合，没啥用
   -第四种：Father.Child child = new Father().new Child();  ，外部类.成员内部类 对象名 = new 外部类().new局部内部类();
7.如果外部类和成员内部类的成员重名时，默认遵循就近原则

 */
public class example08 {

    public static void main(String[] args) {
        outer obj = new outer();
        obj.test();

        //外部其他类使用某个类的成员内部类
        outer.inner innerClass = obj.new inner(); //语法： 外部类名.成员内部类 对象名 = 提前创建过的外部对象.new 成员内部类名();
        innerClass.say("使用外部其他类创建outer类的成员内部类inner");

        obj.new inner().say("用外部对象匿名创建inner对象");

//        obj.getInner_Instance().say("利用该类的方法return inner对象");
        outer.inner innerObj = obj.getInner_Instance();
        innerObj.say("利用该类的方法创建一个对象");

    }
}

class outer{
    private int a = 10;

    class inner{ //成员内部类
        public void say(String something){
            System.out.println( something +" say a = " + a);
        }
    }

    public void test(){
        inner obj = new inner();//可以在外部类的方法中访问成员内部类和创建它的实例对象
        obj.say("test方法");

        new inner(){//也可以用匿名内部类创建成员内部类的对象
            @Override
            public void say(String somthing) {
                System.out.println("匿名内部类调用的say()方法");
            }
        }.say("匿名内部类");
    }

    public inner getInner_Instance(){ //让外部其他类获取该类的成员内部类的第二种方式
        return new inner();
    }
}