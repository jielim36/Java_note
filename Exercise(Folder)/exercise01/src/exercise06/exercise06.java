package exercise06;
/*
1.有一个交通工具接口类Vehicles，有work接口（方法）
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat。
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具

exercise07有优化版
 */
public class exercise06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧","boat");
        person.result();
    }
}

interface Vehicle{
    String work();
}

class Horse implements Vehicle{

    @Override
    public String work() {
        return "骑马";
    }
}

class Boat implements Vehicle{

    @Override
    public String work() {
        return "坐船";
    }
}

class VehicleUse{//交通工具工厂
    public static String useHorse(){ //用static方便调用
//        Horse horse = new Horse();
//        return horse.work();
        return new Horse().work();
    }

    public static String useBoat(){
//        Boat boat = new Boat();
//        return boat.work();
        return new Boat().work();
    }
}

class Person{
    private String name;
    private String vehicle;

    public Person(String name, String vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    //把具体需求封装成方法方便调用，不要写在main方法
    public void result(){
        if (vehicle.equals("horse")){
            System.out.println(this.name + "正在" + VehicleUse.useHorse());
        } else if (vehicle.equals("boat")) {
            System.out.println(this.name + "在大河上" + VehicleUse.useBoat());
        }else{//如果不是horse和boat
            System.out.println(this.name + "在坐UFO");
        }
    }


}


