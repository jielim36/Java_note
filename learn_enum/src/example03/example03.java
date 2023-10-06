package example03;
/*
演示使用enum关键字实现枚举
 */
public class example03 {
    public static void main(String[] args) {
        System.out.println("Example03");
        System.out.println(Season.SPRING);//toString override
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

enum Season{
//    public final static Season SPRING = new Season("春天","温和");
//    public final static Season WINTER = new Season("冬天","寒冷");
//    public final static Season SUMMER = new Season("夏天","炎热");
//    public static final Season AUTUMN = new Season("秋天","凉爽");

/*
    使用enum关键字替代class关键字（变成枚举类）：
1.public final static Season SPRING = new Season("春天","温和"); 更改成 SPRING("春天","温和")
2.如果有多个常量对象，使用逗号隔开，而不是每个对象一行。
3.如果使用enum关键字实现枚举，要求定义常量对象时写在最前面（上面），如果定义在成员属性（name,description的下面会报错）
 */
    SPRING("春天","温暖"),WINTER("冬天","寒冷"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽");
    private String name;
    private String description;
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

