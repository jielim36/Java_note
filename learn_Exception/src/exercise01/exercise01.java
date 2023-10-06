package exercise01;
/*
编写程序，接收命令行的两个参数（整数），计算两数的相除
计算两个数的相除，要求使用方法cal(int n1,int n2)
对数据格式不正确，缺少命令行参数，除0进行异常处理

注意：接收命令行的参数方法是在右上角的exercise01那里的一个comboBox向下箭头点击以下，然后选择Edit Configurations
    然后对Argument进行修改，每个参数以空格作为间隔
 */
public class exercise01 {
    public static void main(String[] args) {
        int n1=-1;
        int n2=-1;
        try {
            if(args.length != 2){
//                throw new argsWrong("命令行参数不等于2");这里是我做错的，我做成自定义异常，但是其实可以用ArrayIndexOutOfBoundException
                throw new ArrayIndexOutOfBoundsException("命令行参数不等于2！");
            }
            n1 = Integer.parseInt(args[0]);
            n2 = Integer.parseInt(args[1]);
            System.out.println(cal(n1,n2));
        } catch (NumberFormatException e) {//数据格式不正确
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
//    public static void cal(int n1,int n2){
//        int result=0;
//        try {
//            result = n1 / n2;
//        }catch (ArithmeticException e){ //对如果除于0进行异常处理
//            e.printStackTrace();
//        }
//
//        System.out.println("Number = "+result);
//    }
    //这里使用int返回，就可以把ArithmeticException异常写在main方法，而不需要像上面报废的cal方法那样分开写在里面
    public static int cal(int n1 , int n2){
        return n1/n2;
    }
}

class argsWrong extends RuntimeException{//自定义异常类，但是这个题目其实可以直接使用Arrray out of bound
    public argsWrong(String message) {
        super(message);
    }
}
