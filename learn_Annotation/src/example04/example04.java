package example04;
/*
@SuppressWarnings : 可以抑制编译器的警告

1.  @SuppressWarnings({"all"})是将所有警告都去除，可以指定去除某个类型的警告，但是需要去查具体名词
    比如：
    boxing:抑制与封装/拆装作业相关的警告
    fallthrough: 抑制与switch陈述式中遗漏的break相关的警告
    有需求自己查

2.  @SuppressWarnings({"内容","内容"}) ， 可以用逗号隔开每一个需求

3. @SuppressWarnings Annotation的作用范围和防止的位置有关，比如在某个方法的上面那行注解然后使用"all",只会抑制它下面那个方法内的所有警告,甚至可以只是抑制某个属性

4. 可以抑制的元素：几乎全部
 */
public class example04 {
    @SuppressWarnings({"unsed","all"})//使用all可以将所有警告都去除，但是即使all也要注意放置注解位置的问题，放在方法的上面all就只会抑制方法内的所有警告
    public static void main(String[] args) {
        A a = new A();
        a.hi();
        System.out.println(a.n1);

    }
}
@SuppressWarnings({"all"})//对下面的class A使用SuppressWarnings Annotation
@Deprecated
class A{
    @Deprecated
    public static int n1 = 10;
    @Deprecated
    public void hi(){
        System.out.println("hi");
    }
}