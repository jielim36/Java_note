package example00;

public class Dog {
    public String name = "小黄";
    public int price = 10000;
    public String color = "white";
    private int num = 5;//反射不能够直接获取private属性，但是有其他方法可以获得
    public static String animal = "dog";

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public void Hi(String a , int b , char c){}
    public void Run(){}
}
