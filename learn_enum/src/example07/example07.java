package example07;
/*
练习题：
声明Week枚举类，包含星期一至星期日的定义
2.使用values,返回所有的枚举数组，并且遍历
 */
public class example07 {
    public static void main(String[] args) {
        Week [] array = Week.values();

        for (Week showSomething : array){
            System.out.println(showSomething);//Week类中有重写toString方法
        }
    }
}

enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String desc;
    Week() {
    }

    Week(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name() + " is " + desc;//name()是Enum类特有的
    }
}
