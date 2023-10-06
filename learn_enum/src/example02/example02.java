package example02;
/*
什么是枚举Enum(Enumeration)？
1.枚举是一组常量的集合
2.可以理解成：enumeration属于一种特殊的类，里面只包含一组有限的特定的对象

枚举的两种实现方式：
1. 自定义类实现枚举(example02)
2. 使用enum关键字实现枚举(example03)

下面将会使用自定义枚举演示
 */
public class example02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);//toString override
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//演示自定义枚举

/*
枚举类步骤:
1. 将constructor的访问权限写成private防止外部创建对象
2. 原本的setter and getter 方法，我们将setter去除，因为枚举类的特征是“只读”，不能更改内容
3. 在类中创建想要的固定的对象, 并且用public static修饰该对象，目的是为了让外部可以直接调用该对象
   如果更好的方式就再加上final(对枚举对象/属性使用final+static共同修饰，实现底层优化)
4. 枚举对象名：final static后该对象就是常量而不是变量，定义名称时建议使用大写（规范）
 */
class Season{
    private String name;
    private String description;

    //定义了四个固定的对象
    public final static Season SPRING = new Season("春天","温和");
    public final static Season WINTER = new Season("冬天","寒冷");
    public final static Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
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
