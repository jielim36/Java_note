package Lambda;

import java.util.function.IntConsumer;

/**
  Lambda的省略规则
 1.参数类型可以省略
 2.方法体只有一行代码时可以将 {}和;符号省略
 3.方法只有一个参数时小括号可以省略 (String s) -> s
 4.以上省略规则记不住也可以省略不记，因为没有影响
    而且我们可以写一个正常的匿名内部类，然后通过IDEA的alt+Enter快捷键然后再选择转换成lambda表达式，IDEA就会自动帮我们转换
 */
public class ex06_makeSense {
    public static void main(String[] args) {
        //传统方法
//        forEachArr(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);//打算把传入的value进行输出
//            }
//        });

        //Lambda
        forEachArr(value -> System.out.println(value));
        /*
        问题：
        1.参数类型可以省略不急：为什么不需要写 new IntConsumer(){} 这个匿名内部类
        答：因为我们的forEachArr只有这个接口(该接口也只有一个抽象方法)，所以系统可以推导出我们是正在写这个IntConsumer参数

        2.为什么不需要重写IntConsumer接口中的accept抽象方法呢？
        答：该接口只有一个抽象方法，所以可以推导出我们正要实现这个抽象方法

        3.为什么accept(int value)方法中的value也可以省略掉int这个数据类型只需写value呢？
        答：因为我们实现的这个方法已经有规范我们必须是一个int数据类型，所以lambda也可以推导出我们写的value变量名是对应了int数据类型的

        4.为什么(value) -> xxx中的()括号可以直接省略变成 value -> xxx 呢？
        答：当参数列表只有一个参数时，可以直接省略括号

        4.
         */
    }

    public static void forEachArr(IntConsumer consumer){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);//把数组的每个元素都传入accept方法，我们只需要重写accept方法时对传入的数据进行操作
        }
    }
}
