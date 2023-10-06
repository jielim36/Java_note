package example06;
/*
匿名内部类的实际应用场景：只有向某个方法传入一次实参

在传统方法里，想要将一个实现某个接口的类传入一个方法内，需要创建一个类，再调用方法时创建一个匿名对象
但是如果用匿名内部类可以省略创建类的步骤，直接在调用传入方法时创建匿名内部类

当然，如果有需要重复传入实参的话还是传统方法会更好
 */
public class example06 {
    public static void main(String[] args) {
        method(new Person());//传统方法第二步

        method(new AA(){ //匿名内部类传入实参
            @Override
            public void say() {
                System.out.println("Anonymous Inner Class call say() method");
            }
        });
    }
    public static void method(AA itf){
        itf.say();
    }
}


interface AA{
    void say();
}

class Person implements AA{ //传统方法 第一步

    @Override
    public void say() {
        System.out.println("class Person say()method");
    }
}
