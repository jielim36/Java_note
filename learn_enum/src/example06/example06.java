package example06;
/*
Enum类（源代码）的成员方法
1. toString：Enum类的方法，返回的是当前对象的名称(我们定义的对象变量名)，子类可以重写该方法，用于返回对象的属性信息，如果我们在枚举类中重写了toString,就会调用我们自己的toString方法了
2. ordinal()方法：可以输出该枚举对象的次序/编号，从0-x，类似于数组，比如这个案例我们有四个季节，我们第一个创建的SPRING是编号0，最后一个创建的对象AUTUMN是编号3。
3. values()方法：可以返回一个含有所有枚举对象的数组 ->注意:Enum类的源代码中找不到这个方法，Java编译器会自动咋enum类型中插入values方法，Enum类里面没有
4. valueOf()方法：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
5. compareTo()方法：比较两个枚举常量，比较的是它们的 位置号 （ordinal输出的那个编号）, 比较方式：左边 - 右边;

 */
public class example06 {
    public static void main(String[] args) {
        //成员方法1：toString()
        System.out.println("\n\n成员方法1： toString方法：");
        System.out.println("Season.AUTUMN toString :"+Season.AUTUMN);//成员方法1：toString：可以返回对象的名称(Enum类的toString)
        Season haha = Season.SPRING;
        System.out.println("haha.name() : "+haha.name());//name属性也可以返回对象的名称，但是建议优先使用toString方法

        //成员方法2: ordinal() ：
        System.out.println("\n\n成员方法2： ordinal()方法：");
        System.out.println("AUTUMN ordinal : "+Season.AUTUMN.ordinal());//3 , 成员方法2 : ordinal()可以输出该对象定义时是第几个对象
        System.out.println("SPRING ordinal : "+Season.SPRING.ordinal());//0

        //成员方法3：values() ->注意:Enum类的源代码中找不到这个方法，Java编译器会自动咋enum类型中插入values方法，Enum类里面没有
        //从反编译可以看出values方法可以返回 Season[]
        //含有定义的所有枚举对象
        System.out.println("\n\n成员方法3： values()方法：");
        System.out.print("Values方法创建数组后遍历显示：");
        Season [] values = Season.values();
        //普通for循环
//        for (int i = 0; i < values.length; i++) {
//            System.out.print(values[i] + " , ");
//        }
        //增强for循环 , 原理：每一次循环都将values[每次循环]的值赋予for循环创建的Season对象hahaTest[每一次循环],然后输出，下一次循环又重新赋值,以此类推...
                  //换句话说：依次从values数组中去除数据赋给hahaTest，如果取出完毕，则退出
        for (Season hahaTest : values){
            System.out.print(hahaTest + " , ");
        }
        System.out.println("");


        //成员方法4: ValueOf: 将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        System.out.println("\n\n成员方法4： valueOf方法：");
        Season obj = Season.valueOf("AUTUMN");//"AUTUMN"是我们在枚举类中已经定义的枚举对象，不是随便写的
        System.out.println(obj.showInfo());//可以发现obj对象已经获得AUTUMN枚举对象的所有属性
        System.out.println(obj == Season.AUTUMN);//true obj和AUTUMN现在是一样的地址了
        Season obj2 = Season.AUTUMN;
        System.out.println(obj == obj2);//true，因为他们都是指向了Season.AUTUMN对象的地址（而且是static）

        //成员方法5：compareTo()方法：比较两个枚举常量，比较的是它们的 位置号 （ordinal输出的那个编号）
        //比较方式：Season.SUMMER.compareTo(Season.SPRING) = SUMMER的编号 - SPRING的编号
        System.out.println("\n\n成员方法5: compareTo()：");
        System.out.println("SUMMER[2] - SPRING[0] : "+Season.SUMMER.compareTo(Season.SPRING));//SUMMER编号 - SPRING编号 = 2 - 0 = 2
        System.out.println("SUMMER[2] - WINTER[1] : "+Season.SUMMER.compareTo(Season.WINTER));
    }
}

enum Season{
    SPRING("春天","温暖"),//ordinal方法输出0
    WINTER("冬天","寒冷"),//ordinal方法输出1
    SUMMER("夏天","炎热"),//ordinal方法输出2
    AUTUMN("秋天","凉爽");//ordinal方法输出3

    private String name;
    private String description;

    Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String showInfo() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
