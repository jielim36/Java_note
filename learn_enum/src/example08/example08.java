package example08;
/*
Enumeration(Enum) 枚举的细节：
1.使用enum关键字的class，就不能再继承其他类了，因为enum枚举类会隐式继承Enum类，而java是单继承机制。
2.枚举类和普通类一样，可以实现接口： enum 类名 implements 接口名
 */
public class example08 {
    public static void main(String[] args) {

    }
}

enum AAA implements itf{
    ;//即使没有写枚举对象也需要写结束号

    @Override
    public void play() {//实现接口

    }
}

interface itf{
    void play();
}