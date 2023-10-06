package exercise05;
/*
编写一个类A，在类中定义局部内部类B，B中有一个私有常量name，有一个方法show（）打印常量name，进行测试
A中也定义一个私有的变量name，在show方法中打印测试
 */
public class exercise05 {
    public static void main(String[] args) {
        A a = new A();
        a.setName("HoHo");
        a.method();
    }
}

class A{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void method(){
        class B{
            private final static String name = "Lim Yee Jie";

            public void show(){
                System.out.println("Name:" + name);
            }
            public void show2(){
                System.out.println("Parent Class Name:" + A.this.name);
            }
        }

        B b = new B();
        b.show();
        b.show2();
    }
}


