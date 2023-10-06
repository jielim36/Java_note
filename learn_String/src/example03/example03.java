package example03;
/*
1.String是一个final类，代表不可变的字符序列
2.字符串是不可变的，一个字符串一旦被分配，其内容是不可变的
 */
public class example03 {
    public static void main(String[] args) {
        q4();
        q5();
        q6();
        q7();
        q8();

    }

    public static void q4(){
        //判断以下代码共创建了几个对象
        String s1 = "hello";
        s1 = "haha";

        //答案：2个，hello字符串常量对象和haha字符串常量对象
        //解析：s1 去常量池指向"hello"，但是没有这个字符串常量，所以创建了再指向hello字符串常量对象
        //     之后s2由去常量池指向"haha"，但是发现没有这个字符串，所以创建了haha然后指向它
        //     指向haha后便和hello字符串常量对象没有关系了，没人指向hello字符串常量对象，但是hello字符串常量对象并没有消失，它还在内存中
        //    注意这句话不确定对不对：final修饰的属性变成常量后，在常量池并不会消失（"xxx"字符串天生就是常量），（其他不是常量的属性叫变量，变量会被Java的回收机制回收）


    }
    public static void q5(){
        //问：下面代码创建了几个对象？
        String a = "hello" + "abc";

        //答案：一个，helloabc
        //解析：编译器读取我们的这串代码时，会自动优化成 String a = "helloabc"; 把两个字符串拼接后才变成一个字符串常量对象

    }
    public static void q6(){
        System.out.println("\n\nq6:");

        //创建了几个对象？
        String a = "hello";
        String b = "abc";
        String c = a+b;

        //答案：常量池有3个 hello , abc , helloabc,（但是全部对象超过三个，因为c执行过程中有创建其他对象）
        /*
        注意：下面的是java8版本的底层，现在的java不一样了
        解析：a指向了hello，b指向了abc，但是c并不是直接指向helloabc
             1.c 第一步去到了StringBuilder类的构造器，也就是说创建了一个 StringBuilder xx = new StringBuilder();
             2.然后调用了StringBuilder类里的public StringBuilder append(String str)方法,然后把hello传入str
             3.所以执行了 xx.append("hello")
             4.然后重复abc的步骤-> xx.append("abc")
             5.然后调用toString方法返回value数组（数组里是helloabc的char）和返回字符串字数（String c = xx.toString() ）
             6.最后其实是c指向了堆中的对象（String） value [] ，然后value[]又指向了池中的"helloabc"

             总结：a指向hello，b指向abc，c指向堆，堆里的value数组指向helloabc
         */
        String d = "helloabc";
        System.out.println(d == c);//false，因为d指向helloabc ，c指向的是堆
        System.out.println(d == c.intern());//true

        String e = "hello" + "abc";
        System.out.println(e == d);//true

    }
    public static void q7(){
        System.out.println("\n\nq7:");
        String s1 = "hspedu";
        String s2 = "java";
        String s5 = "hspedujava";
        String s6 = (s1 + s2).intern();
        System.out.println(s5 == s6);//true
        System.out.println(s5.equals(s6));//true
    }
    public static void q8(){
        System.out.println("\n\nq8");
        Test ex = new Test();

        ex.change(ex.str,ex.ch);

        System.out.println(ex.str + " and ");//hsp
        System.out.println(ex.ch);//hava

        /*
        解析：
        创建了一个Test类的对象ex
        里面有一个String str = new String("hsp");的 ->str创建并了String类对象，里面有一个value数组指向了hsp这个字符串常量对象
        里面还有final char [] ch = {'j','a','v','a'}; -> 在堆空间创建了一个数组（数组默认创建在堆空间）
        之后调用了change方法，并且传入了ex.str的地址和ex.ch的数组地址
        ex.change(String str,char [] ch)这个方法传入时：change(ex.str , ex.ch),此时传入这两个对象实际上是传入了这两个对象的地址，
        所以方法内接收的是他们的地址
        change方法内：
            方法内的str局部变量获得的ex.str全局变量的地址，所以str局部变量和ex.str成员变量都指向了"hsp"
            但是有将str局部变量指向了"java",所以str局部变量指向了"java",而ex.str成员变量还是指向"hsp"

            方法内的char[] ch数组局部变量获得了final char [] ch这个成员常量数组的地址，所以现在两个数组都指向了同一个数组空间
            ch局部变量数组更改了数组[0]下标的'j'变成了'h',同时ch成员常量数组的内容也随之改变，因为双方都“共享”同一个数组。（注意：final 数组可以更改内容，但是不能更改指向的地方，可以看回example01的细节部分）

            问题：为什么String的双方本来同一个地址结果其中一个改变了值另一个String方却没有改变呢？
                 为什么char数组双方同一个数组地址，某一方改变后另一方也会改变？
            答案：因为String数据指向的值其实是一个在常量池的字符串，
                例子： String a = "abc";
                             a = "haha";
            这个例子里a取消了指向abc，转而指向haha，这时候abc字符串依旧在常量池中
            所以再看回该案例就可以发现，原本str局部变量和str成员变量都指向"hsp",但是str局部变量取消指向hsp转而指向java
            但是此时str成员变量依旧指向hsp常量池字符串
            总结：常量池字符串并不是共享的，当str局部变量：str = hsp 里的hsp改变成java时，
                 实际上并不是改变值，而是依据我们程序员输入的java该单词在常量池创建了新的常量池字符串，然后str局部变量就指向java
                 所以hsp被更改后并不是更改，而是替换，hsp依然存在。

         */

    }
}

class Test{
    String str = new String("hsp");
    final char [] ch = {'j','a','v','a'};

    public void change(String str,char ch[]) {
        str = "java";//记住这个str是该方法的在实参中创建的String str局部变量，不是成员变量的那个str
        ch[0] = 'h';

    }
}
