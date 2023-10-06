package exercise05;

public class exercise05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);

        System.out.println(a==b);//false
        System.out.println(a.equals(b));//false equals是对比双方的内存地址，除非有Animal类重写
        System.out.println(a.name.equals(b.name));//true 因为这里的equals是String类重写的equals方法
        System.out.println(a.name == b.name);//true

        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);//false
        System.out.println(s4 == s5);//false

        String t1 = "hello" + s1;
        String t2 = "hellohspedu";
        String t3 = "hello" + "hspedu";
        System.out.println(t1 == t2);//false 注意：如果字符串是"xxx" + 某个字符串对象 ， 那么t1便会指向堆而不是直接指向常量池的字符串"hellohspedu"即便他输出的字符串是这个
        System.out.println(t1.intern() == t2);//true
        System.out.println(t2 == t3);//true
    }
}
class Animal{
    String name;

    public Animal(String name) {
        this.name = name;
    }
}