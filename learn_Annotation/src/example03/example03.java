package example03;
/*
Deprecated:表示某个程序元素（类，方法等）已经过时
可以修饰的元素： @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})

Deprecated的用处:
1.比如工作中时Java版本的过渡：一个项目的团队用jdk8，但是被升级到jdk11了，然后原本jdk8的一些方法有被优化，
  所以我们对这些方法用deprecated注解，可以提醒使用jdk11的人这个方法已经过时了，推荐使用更好的方法。
 */
public class example03 {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
        System.out.println(a.n1);

    }
}

//Deprecated ：修饰某个元素（比如类），表示该元素已经过时，注意：过时不代表不可以用，只是不推荐使用（比如：nokia已经过时了，推荐使用Apple，但是不代表不能用nokia）
//其他地方调用被deprecated修饰过的元素时，会有一条横线，但是不知道为什么我的IDEA IDE没有（现在的黄色highlighter是编译器的警告，在example04中学到的@SuppressWarnings注解可以解决）,
// 但是在辅助器（a.还没有打完hi()的时候自动出现的选择）的时候还是有横线
@Deprecated
class A{
    @Deprecated
    public static int n1 = 10;
    @Deprecated
    public void hi(){
        System.out.println("hi");
    }
}
