package example10;
/*
第二种异常处理方式：throws
基本介绍：
1.如果一个方法中的语句执行时可能发生某种异常，但是并不能确定如何处理这种异常，
  则此方法应显示地声明抛出异常，表明该方法将不对这些异常进行处理，而由该方法的调用者（比如调用该方法的方法）负责处理
2.在方法中声明用throws语句可以声明抛出异常的列表，throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类。
 */
public class example10 {
    public static void main(String[] args) {

        try {
            f1();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("程序继续执行...");

    }

    //throws可以指定某个异常子类，也可以直接写Exception类（父类）。
    //throws也可以是”异常列表“，即可以抛出多个异常
    public static void f1() throws ArrayIndexOutOfBoundsException,NullPointerException{ //throws也可以直接写Exception类（父类）
        int [] arr = new int[3];
        arr[3] = 3;//ArrayIndexOutOfBoundException
    }
}
