package com.debug02;

public class debug02 {

    public static void main(String[] args) {

        int [] arr = {1,10,-1};

        for(int i = 0 ; i <= arr.length ; i++){ //这里故意写一个数组的超出范围异常并且使用debug来查看细节
            System.out.println(arr[i]);
        }
        System.out.println("End loop");

    }

}
