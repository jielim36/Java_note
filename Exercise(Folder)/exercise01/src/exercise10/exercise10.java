package exercise10;
/*
创建一个可以对某个号码自定义更改保留小数点的计算机
和一个可以对某个号码转换成整数的计算机

需要用接口和匿名内部类
 */
public class exercise10 {
    public static void main(String[] args) {

        cal obj1 = new cal();

        obj1.Float(new HandleAble() {
            @Override
            public void HandleString(double num) {
                System.out.println(num);
            }
        },114.514);

        calIntegerNumber obj2 = new calIntegerNumber();
        obj2.cal(new itfInteger() {
            @Override
            public int convertIntegerNumber(double number) {
                return (int)number;
            }
        },114.514);

    }
}

class cal{
    public void Float(HandleAble obj,double number){//number是想要转换的号码
        String str = String.format("%.2f",number);//控制多少个小数点
        double result = Double.parseDouble(str);
        obj.HandleString(result);
    }
}

interface HandleAble{
    void HandleString(double num);
}


class calIntegerNumber{
    public void cal(itfInteger obj,double number){
        int result = obj.convertIntegerNumber(number);
        System.out.println(result);
    }
}

interface itfInteger{
    int convertIntegerNumber(double number);
}