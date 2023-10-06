package example02;

public class example02 {
    public static void main(String[] args) {

    }
}

class Father{
    public void haha(){
        System.out.println("haha");
    }
    public void hi(){
        System.out.println("hi");
    }
}

class son extends Father{
    //没有写annotation

    ///表示有和父类重写，有写annotation ,其实写没写没有区别，
    //好处：
    // 工作的时候可以让他人更容易看懂，也就是：容易阅读和理解代码
    // 但是代码没有重写却写override annotation将会报错，也就是：可以让编译器检查是否正确的重写了父类的方法
    @Override//可以ctrl+b跳转到override源代码发现它是@interface类型，注意：@interface不是interface接口，是注解类，jdk1.5之后加入的
    public void hi() {
        super.hi();
    }
    //没有写annotation，代码还是重写了，但是别人看代码的时候很难察觉你的方法是否有重写
    public void haha() {
        super.haha();
    }

    /*
    Override源代码中有一串代码:
@Target(ElementType.METHOD)

意思是Override只能修饰方法

@Target是修饰注解的注解,称为元注解(Meta Annotation)
     */
}
