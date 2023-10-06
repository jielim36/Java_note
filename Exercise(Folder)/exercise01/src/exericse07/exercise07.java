package exericse07;
/*
exercise06优化版
1.有一个交通工具接口类Vehicles，有work接口（方法）
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat。
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具

exercise07有优化版
 */
public class exercise07 {
    public static void main(String[] args) {
        Person person = new Person("唐僧",new Boat());
        person.common();
        person.passRiver();
        person.passRiver();
        person.passRiver();
        person.common();
        person.passRiver();
        person.passFire();
    }
}

interface Vehicle{
    void work();
}

class Horse implements Vehicle{

    @Override
    public void work() {
        System.out.println("骑马");
    }
}

class Boat implements Vehicle{

    @Override
    public void work() {
        System.out.println("坐船");
    }
}

class UFO implements Vehicle{
    @Override
    public void work() {
        System.out.println("坐UFO");
    }
}

class VehicleFactory{//交通工具工厂
    private static Horse horse = new Horse();//饿汉式，目的是为了让horse只有一个，boat可以有很多个所以不用饿汉式（坐船的时候有带上马，骑马的时候带不上船，所以每次坐船都是新的船，但是每次骑马都是同一个马）
    public static Horse getHorse(){
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }

    public static UFO getUFO(){
        return new UFO();
    }
}

class Person{
    private String name;
    private Vehicle vehicle;//Vehicle接口

    public Person(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void passRiver(){//过河时使用船
        if (!(vehicle instanceof Boat)){ //当过河时的当前状态不是坐船，就变成坐船，比如陆地后再下水就会执行，如果下水后又下水就不会执行，因为是一样的
            vehicle = VehicleFactory.getBoat();//向上转型 :  Vehicle vehicle1 = new Horse();
            /*
            if vehicle = null : vehicle instanceOf Boat -> false
            if vehicle = Horse : vehicle instanceOf Boat -> false
            if vehicle = Boat : vehicle instanceOf Boat -> true
            然后上面的判断是感叹号的，所以全部调反(false变true ， true变false)
             */
        }
        vehicle.work();
    }

    public void common(){//一般情况下，使用马
        if (!(vehicle instanceof Horse)){
            vehicle = VehicleFactory.getHorse();//这里的getHorse是static对象
        }
        vehicle.work();
    }

    public void passFire(){//如果唐僧要过火焰山就坐UFO
        if(!(vehicle instanceof UFO)){
            vehicle = VehicleFactory.getUFO();
        }
        vehicle.work();
    }
}

