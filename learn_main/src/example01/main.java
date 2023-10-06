package example01;

public class main {

    /*

   深入理解main方法：
   main方法的形式是： public static void main(String[] args) {}
   1.main方法是由JVM（Java Virtual Machine虚拟机）调用的
   2.java虚拟机需要调用类的main（）方法，所以main方法的访问权限必须是public(如果main方法没有public，IDE也无法run)
   3.java虚拟机在执行main（）方法是不必创建对象，所以main方法必须是static

   4.该方法接收String类型的数组参数，该数组中保存了执行java命令时传递个所运行的类的参数
    -当我们创建一个main方法：
        public static void main(String[] args) {

        for (int i = 0 ; i < args.length ; i++){
            System.out.println("Number "+(i+1)+" is : " + args[i]);
        }

        }

     -然后使用编译器（cmd）然后编译（java class），之后在执行是的代码时写入 java （java file名字） jielim hoho hi
     -此时就会输出：
        Number 1 is : jielim
        Number 2 is : hoho
        Number 3 is : hi

   5.总而言之，String[] args这个数组是当我们想要传入一些数据时使用的（平时直接run是没有传入的（应该））
   6. IDEA 这个IDE也能够实现对main方法传入值（看example02)

   6.在main（）方法中，我们可以直接调用main方法所在类的静态方法和静态属性
   7.但是，不能直接访问该类的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员
     */

    public int number = 2;//非静态属性
    public static String name = "jie";//静态属性

    public static void main(String[] args) {

        System.out.println(number);//非静态方法（没有创建对象）
        System.out.println(name); //静态方法

        main a = new main();//创建对象
        System.out.println(a.number);//非静态方法（已经创建方法）

        say();//非静态方法
        a.say();//非静态方法（使用对象调用）
    }

    public void say(){
        System.out.println("say");
    }


}
