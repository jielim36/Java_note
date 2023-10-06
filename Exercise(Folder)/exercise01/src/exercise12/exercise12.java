package exercise12;
/*
Father类为外部类，类中定义一个私有的String类型的属性name，name的值为“zhangjun”。
Child类为Father类的内部类，其中定义一个introFather()方法，方法中调用Father类的name属性。
定义一个测试类Test，在Test类的main()方法中，创建Child对象，并调用introFather ()方法
————————————————
版权声明：本文为CSDN博主「A__B__C__」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/A__B__C__/article/details/83385139
 */
public class exercise12 {
    public static void main(String[] args) {
        Father.Child child = new Father().new Child();//局部内部类对象创建方法之一
        child.introFather();

        Father.Child child2 = new Father().getChild();//局部内部类对象创建方法之一
        child2.introFather();


    }
}

class Father{
    private String name = "Jack";

    class Child{
        public void introFather(){
            System.out.println("Father name:" + name);
        }
    }

    public Child getChild(){
        return new Child();
    }
}


