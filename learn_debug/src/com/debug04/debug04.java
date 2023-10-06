package com.debug04;

public class debug04 {

    public static void main(String[] args) {

        //使用F9 Resume program (左边绿色箭头) 可以直接跳过过程前往下一个断点
        //可以在点击debug按钮后的debug期间动态的放断点(红色)来进行resume program
        //放断点也支持在java的源码中放断点
        // 如果有if-else等结构的话，如果程序没有条件允许跳进某个区域里，断点就无效

        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
        System.out.println("hello400");
        System.out.println("hello500");

    }

}
