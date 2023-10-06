package example11;

public class example11 {
    public static void main(String[] args) {
        new C().pX();
    }
}

interface A{
    int x = 0;//public final static
    int c = 0;
}

class B {
    int x  = 1;
    static int b = 1;

    static int c = 10;
}

class C extends B implements A{
    public void pX(){
//        System.out.println(x); 报错，因为该类继承的B类和实现的A接口都有 属性x，系统无法辨别调用哪一个，所以必须详细调用
        System.out.println(super.x);//父类普通属性用super
        System.out.println(B.b);//父类的静态属性可以直接父类名+属性名
        System.out.println(A.x);//调用接口属性可以直接接口名+属性名，因为接口里的属性全部是public final static，static修饰符可以使用接口名/类名+属性名直接调用
    }
}
