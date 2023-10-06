package example04;
/*
enum关键字实现枚举注意事项：
1.当我们使用enum关键字开发一个枚举类时，默认会继承Enum类，而且是一个final类，证明方式：可以对该enum的.class文件使用javap进行反编码，然后观看代码
2.传统的public static final xxx("xxx") = new xxx 简化成  xxx("xxx")必须知道它调用的是哪一个构造器（如果有重载构造器时，可以看有多少个实参判断它调用的是哪个构造器）
3.如果使用无参构造器创建枚举对象时，则实参列表和小括号都可以省略
4.如果我们创建枚举对象时，必须创建在枚举类的第一行（如果是自定义枚举类example02就不需要，只有enum关键字的class需要）
 */

/*
使用javap对example03的Season枚举类进行反编码后得到的结果：

C:\Users\jieli\Desktop\Java\learn_enum\out\production\learn_enum\example03>javap Season.class
Compiled from "example03.java"
final class example03.Season extends java.lang.Enum<example03.Season> {
  public static final example03.Season SPRING;
  public static final example03.Season WINTER;
  public static final example03.Season SUMMER;
  public static final example03.Season AUTUMN;
  public static example03.Season[] values();
  public static example03.Season valueOf(java.lang.String);
  public java.lang.String getName();
  public java.lang.String getDescription();
  public java.lang.String toString();
  static {};
}
 */


public class example04 {
    public static void main(String[] args) {

    }
}

enum Season{
    SPRING("春天","温暖"),
    WINTER("冬天","寒冷"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    exampleHaHa,//这个对象是使用重载的无参构造器，如果枚举对象是调用无参构造器，可以全部省略，只需要写枚举对象名
    EXAMPLE();//和上面的exampleHaHa都一样，意思是：调用无参构造器的枚举对象(常量对象)也可以写括号

    private String name;
    private String description;

    Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    Season() {//无参构造器
    }
}
