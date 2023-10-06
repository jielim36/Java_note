package example03;

public class example03 {
    public static void main(String[] args) {
        A a = new A();
//        a.tax_rate = 5; 不能更改
        a.number = 4;//可以更改
    }
}

//当不希望类的某个属性的值被修改，可以用final修饰，这种属性也被称为“常量”

class A{
    public final double tax_rate = 0.03;//不希望tax_rate被修改
    public int number = 100;

}
