package example01;
/*
Enum(Enumeration) - 枚举
example01将会演示一个没有枚举类时导致的问题
example02将会对example01的案例使用enumeration

Enum枚举应用场景：
-我们创建的对象有时候想要有固定的对象且不能增加对象的数量和更改内容，
比如：季节类（该类的对象有四个：春夏秋冬），性别类（对象：男，女）
 */
public class example01 {
    public static void main(String[] args) {
        //在这个案例中，使用类创建四个季节，并且对每个季节都有一个描述
         Season spring = new Season("春天","温和");
         Season winter = new Season("冬天","寒冷");
         Season summer = new Season("夏天","炎热");
         Season autumn = new Season("秋天","凉爽");
         Season haha = new Season("红天","热");//问题：季节固定有四个，但是在对象中却可以随意的增加除了固定的四个季节对象以外的其他对象
         spring.setName("绿天");//发现的问题：季节有固定的名字，但是在对象中却可以随意更改季节的名字
         spring.setDescription("头上绿绿");
         /*
         这个时候我们会发现几个问题：
         -对于季节而言，他的对象（具体值）是固定四个（春夏秋冬），不会有更多
         -而且可以随意的对name和description更改
         这样的设计是不好的，所以引出了枚举类【枚：一个一个 ； 举：例举，即把具体的对象一个一个例举】
          */
    }
}

class Season{
    private String name;
    private String description;

    public Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
