package exercise01;

public class exercise01 {
    public static void main(String[] args) {
        Car c = new Car();
        Car c1 = new Car(100);
        System.out.println(c);
        System.out.println(c1);
        /*
        输出：
        price = 9 , color : red
        price = 100 , color : red

        第二个的颜色是red是因为static属性
         */

    }
}

class Car{
    double price = 100;
    static String color = "white";

    @Override
    public String toString() {
        return "Car{" +
                "price = " + price + "\tColor : " + color +
                '}';
    }

    public Car(double price) {
        this.price = price;
    }

    public Car() {
        this.price = 9;
        this.color = "red";
    }
}
