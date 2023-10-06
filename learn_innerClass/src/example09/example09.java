package example09;
/*
Static内部类：
1.static内部类是定义在外部类的成员位置上，并且类名的前面有static修饰符
2.static内部类里可以访问外部类的静态成员包含private，但是不能直接访问非静态成员
3. static内部类可以使用访问修饰符进行修饰（public,protected,default,private）
4.作用域：和其他的成员一样
5.访问方式：静态内部类访问外部类可以直接访问，外部类访问静态内部类需要先创建该静态内部类的对象才能使用对象进行访问
6.在外部其他类创建static内部类的对象时，可以直接使用类名调用
7.创建静态内部类的对象的方式：
 -依靠方法(getXxxx)
 -外部其他类通过外部类名.静态内部类名
 8.如果外部类和静态内部类的成员重名时，使用（外部类名.成员名）可以调用外部类属性（注意：静态内部类只能调用静态成员）
 */
public class example09 {
    public static void main(String[] args) {
        outer obj = new outer("Lim Yee Jie");
        obj.getPerson();

        outer.Person person1 = new outer.Person();//可以通过类名.静态内部类创建对象
        /*
        和成员内部类创建对象的区别：

        成员内部类创建对象:

        outer obj = new outer();//先创建外部类的对象
        //再通过外部类对象创建内部类对象
        outer.inner innerClass = obj.new inner(); //语法： 外部类名.成员内部类 对象名 = 提前创建过的外部对象.new 成员内部类名();

        所以静态内部类可以不需要先创建外部类的对象，而是可以直接使用外部类名.静态内部类名
         */
        person1.info("这里是main方法创建的对象");

        outer.Person person2 = obj.getPerson();//依靠方法创建对象
        person2.info("main方法调用getPerson来创建的对象");
    }
}

class outer{
    private static int same = 0;
    private String name;
    private static int numberPerson=99;

    public outer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNumberPerson() {
        return numberPerson;
    }

    public static void setNumberPerson(int numberPerson) {
        outer.numberPerson = numberPerson;
    }

    //static 内部类
    public static class Person{ //static内部类可以使用访问修饰符
        private static int same = 10;
        private int haha = 10;
        public void info(String something){
//            System.out.println(name); static内部类不能访问非静态成员
//            System.out.println(getName()); static内部类不能访问非静态成员包括方法
            System.out.println(something);
            System.out.println(getNumberPerson());
            System.out.println(outer.same);//如果same和外部类成员有重名，而且想要访问外部类的成员时，使用外部类名.成员名
            System.out.println(same);//就近原则，所以调用的是自己的same成员
        }
    }

    public Person getPerson(){
        return new Person();
    }

    class haha{}

}
