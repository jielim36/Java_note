package example02;
/*
创建String对象的两种方式
1.直接赋值String name = "杰哥";
2.调用构造器： String name = new String("杰哥");

两种方式的区别：
1.第一种方式（直接赋值）：
    先从常量池查看是否有"杰哥"数据空间，
    如果有就直接指向；如果没有则重新创建然后指向。
    name 最终指向的是常量池的空间地址
    （总结：从栈中的name直接指向方法区的常量池里的"杰哥"，
      如果常量池没有"杰哥"就创建，总之不会经过堆Heap）
2.第二种方式（构造器）：
    先在堆(Heap)中创建空间，里面维护了value属性，
    指向常量池的"杰哥"空间。
    如果常量池没有"杰哥"，重新创建；
    如果有则直接通过value指向。最终指向的是堆中的空间地址。
    (总结：从栈中的name创建一个堆空间，
    里面有final char [] value 数组，
     然后value数组会指向常量池的"杰哥"，没有"杰哥"就创建)

内存分配图：韩顺平Java P426 String创建剖析
 */
@SuppressWarnings("all")
public class example02 {
    public static void main(String[] args) {


        System.out.println("q0:");
        String a = "abc";
        String b = "abc";
        //注意: 这里的.equals方法是String类重写的equals方法，
        // 并不是Object类的原有方法。
        System.out.println(a.equals(b));//true：对比双方的内容
        System.out.println(a == b);//true：对比地址

        q1();
        q2();
        q3();

    }

    public static void q1(){
        System.out.println("\n\nq1:");
        String a = "杰哥";
        String b = new String("杰哥");//b指向堆中对象
        System.out.println(a.equals(b));//true:内容
        System.out.println(a==b);//false 地址

        System.out.println(a == b.intern());
        //true，因为b是通过intern方法返回了b对象的常量池字符串

        System.out.println(b == b.intern());
        //false：b是b对象的地址（堆空间），b.intern()是hsp的常量池地址

        /*
        intern方法解析：当调用该方法时，
        如果池中已经包含一个等于此String对象的字符串就
        返回该字符串在常量池的地址
        否则，将此String对象添加到池中，并返回此String对象的引用
        (比如这个案例就是b调用intern时发现了a也有hsp字符串在常量池，
         所以返回hsp这个字符串的地址)

        (所以如果当 a.equals(b)的结果是true的话就代表
        a == b.intern()的结果是true，
        因为equals已经验证了双方的常量池字符串内容相同)
        总结：b.intern()方法最终返回的是常量池的地址

         */
    }
    public static void q2(){
        System.out.println("\n\nq2");
        String s1 = "hspedu";
        String s2 = "java";
        String s4 = "java";
        String obj = new String("java");

        System.out.println(s2 == obj);//false
        System.out.println(s2 == s4);//true
        System.out.println(s2.equals(obj));//true
        System.out.println(s1 == s2);//false
    }
    public static void q3(){
        System.out.println("\n\nq3:");
        Person p1 = new Person();
        p1.name = "LIM";

        Person p2 = new Person();
        p2.name = "LIM";

        System.out.println(p1.name.equals(p2.name));//true 对比内容（注意：name是String）
        System.out.println(p1.name == p2.name);//true,注意：name是String创建的，不是对象，所以对比的双方指向的常量池地址是否一样（内容一样常量池地址就一样）
        System.out.println(p1.name == "LIM");//true，因为p1.name返回的就是name指向的常量池地址（LIM的地址），所以对比LIM的话一定是一致的

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);//false ：对比的是对象的地址


    }

}

class Person{
    String name;
}