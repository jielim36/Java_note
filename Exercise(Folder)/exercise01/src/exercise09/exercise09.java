package exercise09;

import java.util.Scanner;

/*
枚举类：
1.创建一个Color枚举类
2.有RED,BLUE,BLACK,YELLOW,GREEN这五个枚举值/对象
3.Color有三个属性redValue,greenValue,blueValue
4.创建构造器，参数包括这三个属性
5.每个枚举值都要给这三个属性赋值
6.red: 255,0,0 ; blue: 0,0,255 ;  black:0,0,0 ; yellow:255,255,0  ; green : 0,255,0
7.定义接口，里面有方法show，要求Color实现该接口
8.show方法中显示三属性的值
9.将枚举对象再switch语句中匹配使用
 */
public class exercise09 {
    public static void main(String[] args) {
        Color.RED.show();
    }
}

enum Color implements itf{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private double redValue,greenValue,blueValue;

    Color(double redValue, double greenValue, double blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(name()+" color value:\nRed:" + redValue + "\nGreen:" + greenValue + "\nBlue:"+blueValue);
    }
}

interface itf{
    void show();
}
