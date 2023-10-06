package example05;
/*
元注解 Meta Annotation的基本介绍：

JDK的元注解用于修饰其他的注解Annotation
元注解：本身作用不大，讲这个的原因是为了以后看源码时可以知道它是干什么的，可以在注解annotation的源代码中找到这些元注解

1.Retention //指定注解的作用范围，三种：SOURCE,CLASS,RUNTIME
2.Target //指定注解可以在那些地方使用
3.Documented //指定该注解是否会在javadoc体现
4.Inherited //子类会继承父类注解

  说明：实际应用中，使用较少，了解即可。
 */



/*
1.Retention (翻译：保留)
-用于修饰一个Annotation定义，用于指定该Annotation可以保留多长时间，
 @Retention包含一个RetentionPolicy类型的成员变量，使用@Retention时必须为该value成员变量指定值
-Retention的三种值：
i)RetentionPolicy.SOURCE : 编译器使用后，直接丢弃这种策略的注解（在转换成class文件之前就丢弃了）
ii)RetentionPolicy.CLASS : 编译器将会把注解记录在class文件中，当运行java程序时，JVM不会保留注解，这是默认值
iii)RetentionPolicy.RUNTIME : 编译器将会把注解记录在class文件中，当运行Java程序时，JVM会保留注解，程序可以通过反射获取该注释
运行程序流程： java源代码 --javac--> class文件 --java-->  JVM(加载运行)
例子：Override的作用域在SOURCE，当编译器编译时生效，不会写入class文件中，不会在runtime（运行时）生效

2.Documented:用于指定被该元注解修饰的Annotation类将会被javadoc工具提取成文档，
  即在生成文档时，必须设置Retention值为RUNTIME

3.Inherited annotation：被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解
 */

public class example05 {
}
