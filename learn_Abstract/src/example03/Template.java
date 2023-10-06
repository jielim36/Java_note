package example03;

public class Template {
/*
抽象模板的好处：当有某个需要重复的方法但是只有一点点东西需要改时，把固定的代码写在一个方法后，再把有变化的代码写成抽象方法
然后让子类实现这个抽象方法，也就是把需求有变化的代码写在这个方法，并且传入那个固定的代码方法里。（例子：calculateTime()方法）
 */
    public static void main(String[] args) {
        job1 a = new job1();
        a.calculateTime();//调用的是父类的calculateTime方法，但是进入到父类的方法后有调用到一个父类和子类都有的重写方法，结果是调用子类（多态中的动态绑定机制）

        job2 b = new job2();
        b.calculateTime();
    }
}

abstract class cal{

    public void calculateTime(){ //固定方法/固定模板
        long start = System.currentTimeMillis();
        job();//在固定模板中插入一个有变化的方法，然后有需要修改时就直接去到该方法修改，子类重写该方法，因为有动态绑定机制的原因，这里是调用子类的job方法（实例对象是子类）
        long end = System.currentTimeMillis();
        System.out.println("执行时间 ： " + (end - start));


    }

    public abstract void job();//有变化的方法用抽象，然后让该类的子类继承该方法并且实现，

}

class job1 extends cal{

    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 500000000; i++) {
            num += i;
        }
        System.out.println("job1类的job方法");
    }
}

class job2 extends cal{

    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 1000000000; i++) {
            num += i;
        }
        System.out.println("job2类的job方法");
    }
}
