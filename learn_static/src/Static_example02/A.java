package Static_example02;

public class A {

    public static String name = "Jielim";
//    static public String name = "Jielim"; 把static和public换位置也一样，但是更推荐public static
    public int id=5;

}

class B{

    public static void main(String[] args) {

//        static静态变量/类变量在 类加载的时候就生成了。
        // 也就是说，即使你没有创建对象，只要类加载了，就可以使用静态变量/类变量了
        //比如：直接在main里不创建对象并且直接使用类名调用,看以下A.name例子

        System.out.println("Class A : "+A.name);//即使没有创建该类的对象也可以直接使用类名+属性进行访问，这也是static的特征之一，但是依然要遵守访问修饰符的访问权限
//        System.out.println("Class A ID :" + A.id ); //实例变量（非静态变量: private String name;）不能直接通过类名+属性进行调用
        A person1 = new A();
        System.out.println("Person1 :"+person1.name);

        System.out.println("\nWhen person2 change the name");
        A person2 = new A();
        person2.name = "HoHo";//当该类的某个对象更改了静态变量的值后，其他对象也会变
        System.out.println("Person2 : " + person2.name);
        System.out.println("Person1 : " + person1.name);
        System.out.println("Class A : " + A.name);
    }
}
