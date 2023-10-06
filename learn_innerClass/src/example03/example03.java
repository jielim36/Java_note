package example03;
/*
匿名内部类 Anonymous Inner Class：

说明： 匿名内部类的本质还是一个类。匿名内部类是定义在外部类的局部位置，比如方法中，并且没有类名
须知：1.匿名内部类虽然表面上没有名字，但是底层里系统其实还是有给该类一个名字( 外部类名+$1 ,如果有多个匿名对象就会$2,$3...)
     2.匿名内部类同时还是一个对象

注意事项：
1.匿名内部类的运行类型是该匿名内部类
1.匿名内部类的特点是执行完所有任务后就会消失
3.jdk底层在创建匿名内部类xxx(类名)后，立刻马上创建了xxx的实例XX，并且把地址返回给实例对象XX

 */
public class example03 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer{
    private int num1 = 0;
    public void method(){
        /*
        基于接口的匿名内部类
        解读：
        1.需求： 想要使用A接口，并且创建对象
        2.传统方式： 写一个类（Tiger例子），实现A接口，然后创建对象
         */
        A tiger = new Tiger();//传统方式
        tiger.say();
        /*
        3. 但是如果我们创建tiger对象却只有使用一次，之后再也不用，就会造成整个代码文件有些复杂混乱
        4.这个时候，使用匿名内部类来简化开发
         */
        A tiger2 = new A(){ //A是接口名或者类名，这里原本接口是不能直接实例化对象的，但是如果是匿名内部类的话可以做到，因为自己可以实现抽象方法了
            //上面的实例对象的编译类型是tiger2对象的左边的A接口，运行类型就是匿名内部类(可以看下面的关于底层的注释)
            @Override
            public void say() { //实现接口的抽象方法
                System.out.println("匿名内部类的say（）方法");

            }
        };//需要一个结束号才不会报错

        tiger2.say();//在匿名内部类的下方调用即可

        /*
            匿名内部类在底层中：
            class XXXX implements A{
                @Override
                public void say() { //实现接口的抽象方法
                    System.out.println("匿名内部类的say（）方法");
                }
            }

            XXXX是底层中对匿名内部类分配的一个类名，所以实际上我们在写一个匿名内部类时，底层中的实际行动是如上面所写的那样
            底层系统对匿名内部类的取名方式是： 外部类名+ $1  (1是指第一个匿名内部类，当有第二个匿名内部类时第二个匿名内部类的名字就会是2)

            jdk底层在创建匿名内部类Outer$1后，立刻马上创建了Outer$1的实例，并且把地址返回给tiger2
            匿名内部类执行完之后就会被消失，代表只能使用一次，（tiger2这个对象还是可以反复调用的）
            匿名内部类的名字由来也是因为执行完就没有这个类了，而不是单纯的因为该类没有名字
             */
        System.out.println("tiger2匿名内部类的运行类型 ：" + tiger2.getClass());//输出class example03.Outer$1（getClass用于获取该对象的运行类型）


    }


}

interface A{
    public void say();
}

class Tiger implements A{

    @Override
    public void say() {
        System.out.println("Tiger外部类实现了A接口的say（）方法");
    }
}

class Father{
    public Father() {
    }
    public void test(){

    }
}




