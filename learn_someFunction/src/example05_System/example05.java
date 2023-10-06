package example05_System;

import java.util.Arrays;

public class example05 {
    public static void main(String[] args) {

        // exit 退出当前程序
//        System.exit(0);


        //arraycopy 复制数组元素，比较适合底层调用，一般使用Arrays.copyOf
        System.out.println("arraycopy:");
        int [] arr1 = {2,5,1};
        int [] arr2 = new int[3];
        System.arraycopy(arr1 , 0 , arr2 , 0 ,3);//可以灵活控制每个参数：
        System.out.println(Arrays.toString(arr2));
        //第一个参数：被复制的数组（源数组） ，
        // 第二个参数srcPost：从源数组的哪个索引位置开始拷贝  ，
        // 第三个参数dest：被赋值的数组（目标数组）
        //第四个参数 destPos：被拷贝的元素从目标数组的哪个下标位置开始粘贴元素数据
        // 第五个参数：需要复制多少个元素
        /*
        官方文档解释：
        src – the source array.
        srcPos – starting position in the source array.
        dest – the destination array.
        destPos – starting position in the destination data.
        length – the number of array elements to be copied.
         */

        //currentTimeMillis:返回当前时间距离1970-1-1的毫秒数
        /*
            1.可以不用理会那个年份的时间，通常用于当作计时器（开头和结尾）
            2.返回的类型是long数据类型
         */
        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();//获取开始时间
        String name = "";
        for (int i = 0 ; i < 10000 ; i++){
            name += i ;
        }
        long end = System.currentTimeMillis();//获取结束时间
        System.out.println(end-start);//使用场景：计算器，计算执行某个代码的所需的时间


        //gc : 运行垃圾回收机制System.gc()  , 可以看回韩顺平java零基础的P327 : finalize

    }
}
