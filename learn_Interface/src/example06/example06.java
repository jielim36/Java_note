package example06;
/*
实现接口 vs 继承类

理解：实现接口 是对java的 单继承机制 的一个补充机制
-当一个子类除了父类提供的功能以外还想要其他功能，就可以通过接口实现功能

-小结：
1.当子类继承了父类，就自动拥有了父类的功能
2.如果子类需要扩展功能，可以通过实现的机制（接口）来扩展，而且可以同时实现多个接口

-接口和继承解决的问题不同：
继承：继承的价值主要在于解决代码的复用性和可维护性
接口：接口的价值主要在于设计，设计好各种规范（方法），让其他类去实现这些方法

-接口比继承更加灵活
接口比继承更加灵活，继承时满足is - a 的关系，而接口只需要满足like - a的关系（比如：cat is a animal（已经确定）， cat like a car(cat像car一样快)）

-接口再一定程度上实现代码解耦( 接口的规范性+动态绑定可以实现代码的解耦（目前还没学）)

 */
public class example06 {
    public static void main(String[] args) {
        littleMonkey wukong = new littleMonkey("Wu Kong");
        wukong.climbing();
        wukong.swimming();
        wukong.fly();
    }
}

class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println("猴子"+name+"会爬树");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class littleMonkey extends Monkey implements fish,bird{ //可以发现只要继承了父类之后子类对象就能调用父类的方法，
                                    // 但是如果这个littleMonkey想要做Monkey类做不到的方法时发现不能再继承其他类了
    public littleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "通过接口学会了fish的swimming");//如果要让小猴子除了拥有Monkey类以外的功能，但是又不能再继承其他类时，就可以使用接口
    }

    @Override
    public void fly() {
        System.out.println(getName() + "通过接口学会了bird的fly");
    }
}

interface fish{
    void swimming();
}

interface bird{
    void fly();
}