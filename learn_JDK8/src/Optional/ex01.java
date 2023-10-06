package Optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 Java程序时常因为 空指针异常 而导致程序失败。
 为了解决 空指针异常，JDK8类库引入了Optional类

 Optional 介绍：
 java.util.Optional ： Optional<T> 是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null。表示这个值不存在。
 类似于：Integer包装类中包装了int这个数据类型。而Optional则是包装了一个T类型。

 Optional提供了很多有用的方法，这样我们就不需要显式进行空值检测。

 创建Optional类对象的方法：
 1，static <T> Optional<T> empty; : 用于创建一个空的Optional实例
 2. static <T> Optional<T> of(T value); : 用于创建一个Optional实例，value不能为空
 3. static <T> Optional<T> ofNullable(T value); ：用于创建一个Optional实例，value允许为空。


 判断Optional容器中是否包含对象：
 1. boolean ifPresent() : 判断Optional容器的值是否存在
 2. void ifPresent(Consumer <Consumer<.? super T>consumer>) : 判断Optional容器中的值是否存在。
    如果存在，就对它进行Consumer指定的操作，如果不存在就不做。

 获取Optional容器的对象：
 1. T get() : 如果调用对象包含值，返回该值。否则抛出异常。T get() 与 of(T value) 配合使用
 2. T orElse(T other) : orElse(T other) 与 ofNullable(T value) 配合使用。
    如果Optional容器中非空，就 返回
 */
public class ex01 {
    @Test
    public void test01(){
        String str = "lim";//可以输出
        //str = null;//无法输出，空指针异常。

        System.out.println(str.toString());

        //解决方案：
        String str2 = null;
        Optional<String> optional = Optional.ofNullable(str2);//static <T> Optional<T> ofNullable(T value); ：用于创建一个Optional实例，value允许为空。

        //orElse(String s) 方法：取出Optional实例化对象的值，如果该值为null，则取出orElse方法传入的值(String s)
        //                      和ofNullable搭配使用。上面以一个str2字符串对象创建了Optional实例化对象
        //                      再以该实例化对象调用orElse方法并传入一个备用字符串(依照T数据类型)。然后取出该实例化对象的值。
        //                      当实例化对象的值为null时，会取出orElse方法传入的备用字符串
        String result = optional.orElse("Im backup");//当optional对象传入的str2=null时，result会接收到"Im backup" 字符串。
        System.out.println(result);

    }

    @Test
    public void test02(){
        String content = "hahaha";
        Optional<String> optional = Optional.ofNullable(content);
        System.out.println(optional.get());
    }
}
