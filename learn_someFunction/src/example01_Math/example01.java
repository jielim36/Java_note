package example01_Math;

public class example01 {
    public static void main(String[] args) {
//        Math类常用的方法（都是静态方法,可以直接调用）

        //1. abs 绝对值  |a| = 0 之类的
        System.out.println("\n\nabs:");
        int n1 = Math.abs(-9); // |-9|
        System.out.println(n1);//输出9

        //2. pow 求幂(power)
        System.out.println("\n\npow:");
        double n2 = Math.pow(2,4); //2的四次方
        System.out.println(n2);//16

        //3. ceil 向上取整，返回>=该参数的最小整数   总结：往大的方面取整
        System.out.println("\n\nCeil:");
        double n3 = Math.ceil(3.1);
        double n4 = Math.ceil(-3.9);
        System.out.println(n3);//4.0   ，整数就会慢慢往上取整
        System.out.println(n4);//-3.0  ，负数就会慢慢往正数的方向取整

        //4. floor 向下取整，返回<=该参数的最大参数（转成double） 总结：往小的方向取整
        System.out.println("\n\nFloor:");
        double n5 = Math.floor(3.1);    //取整时逐渐往负数的方向取整
        double n6 = Math.floor(-3.9);  //取整时逐渐往负数的方向取整
        System.out.println(n5);
        System.out.println(n6);

        //5. round 四舍五入 （正常的近似值）
        System.out.println("\n\nround:");
        double n7 = Math.round(3.5);//4.0
        double n8 = Math.round(3.2);//3.0
        double n9 = Math.round(-3.5); //-3.0  负数的x.5和正数的x.5是相反的，负数会往下走
        double n10 = Math.round(-3.7); //-4.0  负数的x.6之后就和正数一样，继续往上走
        double n11 = Math.round(-3.2);//-3.0
        System.out.println(n7);
        System.out.println(n8);
        System.out.println(n9);
        System.out.println(n10);
        System.out.println(n11);

        //6.sqrt  (Square Root)  必须正数（普通数学也一样）
        System.out.println("\n\nSquare Root:");
        double n12 = Math.sqrt(9);
        System.out.println(n12);//3

        //7. random 求随机数(生成的随机数都是0.x的小数也就是生成：0 <= x < 1 的数字)
        System.out.println("\n\nRandom:");
        for (int i = 0; i < 4; i++) {
            System.out.println(Math.random());
        }
        //如果我们想要获取 a - b 之间的一个随机整数， a,b均为整数，比如a=2,b=7 (即返回 2 <= x <= 7)
        int a = 2;
        int b = 7;
        for (int i = 0; i < 10; i++) {
            System.out.println((int)(a + Math.random()*(b-a+1)));//这个算法可以获得7整数和2整数
        }


        //max / min 返回最大值和最小值
        System.out.println("\n\nMin and Max:");
        int min = Math.min(1,4);
        int max = Math.max(3,8);
        System.out.println("min:" + min);
        System.out.println("max:" + max);


    }
}
