package example02;

public class example02 {
    public static void main(String[] args) {
        B b = new B();
        b.hi();//虽然A类的方法不能被B这个子类重写，但是创建的B对象还是可以调用A类的这个方法
    }
}

//当不希望父类的某个方法被子类覆盖/重写override时，可以用final关键字修饰
//通常用于一些非常重要不允许更改的方法

class A {
    public final void hi(){//加上final后如果其他类重写该方法就会报错
        System.out.println("class A hi");
    }
}

class B extends  A{
//    @Override
//    public void hi() {      //报错了
//        System.out.println("class B hi");
//    }



}
