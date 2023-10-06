package exercise03;
/*
需求：
1.动物类Animal包含了抽象方法 shout
2.Cat继承了Animal，实现抽象方法
3.Dog也是
4.实例化dog和cat并且调用实现的方法
 */
public class exercise03 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.shout();
        dog.shout();
    }
}

abstract class Animal{
    public abstract void shout();
}

class Cat extends Animal{

    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}

class Dog extends Animal{

    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");
    }
}

