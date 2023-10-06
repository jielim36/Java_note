package com.debug03;
import java.util.Arrays;
public class debug03 {

    public static void main(String[] args) {
        //debug除了解决问题以外，也能够查看java的源代码来提升编程水平
        //这里我们看的是 sort ，一个可以将我们的数组从小到大排序的功能

        int [] arr = {1,5,2,99,2,3};

        Arrays.sort(arr); //这里使用快捷键F7 / Step into 用于跳入该方法

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
