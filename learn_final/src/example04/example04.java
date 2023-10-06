package example04;

public class example04 {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        //这时NUM也被称为 “局部常量”：某个方法里定义的常量 ， 常量通常用全大写（这是规范，不是规则）
        final double NUM = 0.5;
//        NUM = 0.7; 不能更改
        System.out.println("NUM : " + NUM);

    }


}
