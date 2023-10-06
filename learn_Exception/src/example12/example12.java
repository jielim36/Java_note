package example12;

public class example12 {
    public static void main(String[] args) {

    }
}

class Father{
    public void method() throws RuntimeException {}//抛出的异常类型必须是子类抛出的异常类型的父类（或者一样）
}

class Son extends Father{
    /*
    子类重写父类方法时，对抛出异常的规定：子类重写的方法
    所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常的类型的子类型
    注意:如果在throws过程中，如果有try catch，就相当于处理异常，可以不必throws了
     */
    @Override
    public void method() throws NullPointerException{//NullPointerException是RuntimeException的子类
        super.method();
    }
}
