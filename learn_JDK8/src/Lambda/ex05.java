package Lambda;

import java.util.function.IntConsumer;

public class ex05 {
    public static void main(String[] args) {
        //传统方法
//        forEachArr(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);//打算把传入的value进行输出
//            }
//        });

        //Lambda
        forEachArr((int value)-> System.out.println(value +"哈哈"));//由于只有一行代码，可以省略{}符号
    }

    public static void forEachArr(IntConsumer consumer){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);//把数组的每个元素都传入accept方法，我们只需要重写accept方法时对传入的数据进行操作
        }
    }

    /*
    IntConsumer接口内的唯一抽象方法：
        void accept(int value);
     */
}
