package example01;

public class Movie {

    private String name;
    private double price;
    private String director;

    //constructor(Overload)
    public Movie(String name) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影开始...");
        System.out.println("Movie(String name)被调用");
        this.name = name;
    }
    public Movie(String name, double price) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影开始...");
        System.out.println("Movie(String name,double price)被调用");
        this.name = name;
        this.price = price;
    }
    public Movie(String name, double price, String director) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影开始...");
        System.out.println("Movie(String name,double price,String director)被调用");
        this.name = name;
        this.price = price;
        this.director = director;
    }
    //这三个构造器有一个问题就是输出的三个东西都重复了所以看起来很繁琐
    //所以我们可以写下以下的代码
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影开始...");
    }
    /*
    什么是代码块？
    1.代码块又成为初始化块，属于类中的成员，类似于方法，将逻辑语句封装在方法中，通过{}包围起来
    2.但和方法不同，没有方法名，没有返回，没有参数，只有方法体和修饰符（不写或者只能写static）
    3.代码块不用通过对象或者类显式调用，也就是说不用特地调用，因为代码块是加载类，创建对象时隐式调用
    4.基本语法： (修饰符只能是不写或者只能static，其他所有的修饰符都不能)
        [修饰符]{
          代码...
          };
    5.代码块里的逻辑语句可以为任何逻辑语句（输入，输出，方法调用，循环，判断等）
    6.代码块的尾部有一个;符号，这个符号也能省略
     */


    /*
    代码块细节：
    1.代码块被调用的顺序比构造器更优先，所以不管我们调用那个构造器，都是代码块先被调用
    2.代码块可以视作为对构造器的一个补充机制
     */

}

class Run{
    public static void main(String[] args) {
        Movie test = new Movie("Jielim");
        System.out.println("=======================");
        Movie test2 = new Movie("Jielim",1888);
        System.out.println("=======================");
        Movie test3 = new Movie("Jielim",1888,"DDDD");

    }
}
