package exercise09;


public class main {

    public static void main(String[] args) {



        Doctor person1 = new Doctor("Lim Yee Jie",19,"Doc","M",100000);
        Doctor person2 = new Doctor("Lim Yee Jie",19,"Doc","M",100000);

        //注意，这里使用的equals是Doctor类中重写的equals，不是系统Object类中的equals
        System.out.println(person1.equals(person2));//都是独立的对象（地址不相同），属性一样，返回true

        Doctor person3 = new Doctor("Jie",19,"Doc","M",100000);
        System.out.println(person1.equals(person3));

        //注意，这里使用的equals是Doctor类中重写的equals，不是系统Object类中的equals
        //各个对象的地址都不相同，但是属性一样也是返回true
        //反之，地址和属性都不相同就会返回false


    }

}
