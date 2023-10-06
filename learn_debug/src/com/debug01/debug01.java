package com.debug01;

public class debug01 {

    public static void main(String[] args) {

        //使用debug和断点（红色那一行）来运行程序，可以清楚的了解程序是如何运行的
        //通过这个手段可以更容易修改bug和学习到程序的运作原理

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i = " + i);
            System.out.println("sum = " + sum);
        }
        System.out.println("End loop");
    }

}
