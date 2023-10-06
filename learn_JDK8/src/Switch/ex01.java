package Switch;

public class ex01 {
    public static void main(String[] args) {
        Integer a = 19;
        String b = "hi";
        original(a);//传统方式：
        Switch(b);
    }

    public static void original(Object o){
        System.out.println("传统方式：");
        if (o instanceof Integer){
            System.out.println("this is Integer");
        } else if (o instanceof String){
            System.out.println("this is string");
        }else {
            System.out.println("error class...");
        }
    }

    public static void Switch(Object o){
        /**
         switch新特性：用于 JDK17的preview模式（需要手动更改）
         */
        System.out.println("Switch表达式：");
        String format = switch (o){ //可以定义一个变量来接收switch的结果
            case Integer integer : //如果这里报错可以alt+enter 然后转换成preview模式
                yield "Integer " + integer; //yield 关键字：类似于return + break 的效果，在switch表达式中可以返回结果(如果有变量接收switch的话)并且跳出switch，同时也有break在swtich表达式中的效果(完成一个case后不会直接去到另一个case)
            case String str :
                yield "String : " + str;
            default:
                yield "error class" + o.toString();
        };
        System.out.println(format);
    }
}
