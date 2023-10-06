package exercise04;
/*
1.计算机接口具有work方法，功能是运算，有一个手机类Cellphone，定义方法testWork测试计算功能，调用计算机接口的work方法。
2.要求调用Cellphone对象的testWork方法，使用上 匿名内部类
 */
public class exercise04 {
    public static void main(String[] args) {

        Cellphone test = new Cellphone();
        test.testWork(new calculator() { //son.testWork(所有参数)，匿名内部类最经典的使用场景就是当作参数传入
            @Override
            public int work(int num1, int num2) {
                return num1 + num2;
            }
        },3,8);//这里的意思就是父类的方法的三个参数对应-> 接口对象,int num1,int num2

        //也可以重复运算
        test.testWork(new calculator() {
            @Override
            public int work(int num1, int num2) {
                return num1 * num2;//运算方法
            }
        },7,10);//运算的数值

    }
}

interface calculator {
    public int work(int num1,int num2);
}

class Cellphone { //这里没有实现该接口，但是有在方法的实参中创建接口对象，然后等待匿名内部类实现接口

    //当我们调用testWork方法时，直接传入一个实现了接口对象的匿名内部类即可
    public void testWork(calculator obj , int num1 , int num2){
        int result = obj.work(num1,num2);
        System.out.println("计算结果： " + result);
    }

}
