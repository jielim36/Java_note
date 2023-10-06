package example06;

public class example06 {
    public static void main(String[] args) {

    }
}

final class A{
    //当该类已经是被修饰成final后，该类的方法没有必要再使用final，
    // 因为该类是final类后就意味着该类不会有任何子类，
    // 也就是说没有子类的话就不可能会被重写，所以方法不需要再final修饰
    public final void say(){
        System.out.println("haha");
    }
}

class B{

}