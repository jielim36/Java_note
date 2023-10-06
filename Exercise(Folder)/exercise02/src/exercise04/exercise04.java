package exercise04;
/*
题目：输入字符串，判断里面有多少个大写字母和小写字母和数字
用两种方式写
 */
public class exercise04 {
    public static void main(String[] args) {

        judgment("xSx1234@@");//char数组方法
        System.out.println("\n===================\n");
        judgment2("xxAA@@12");//String.charAt方法

    }

    public static void judgment(String something){
        char [] array = something.toCharArray();//有另外一种方式是不使用转换char数组，而是直接在循环中使用字符串.charAt(i)

        int Upper = 0;
        int lower = 0;
        int number = 0;
        int other = 0;
        for (int i = 0 ; i < array.length ; i++){
            if (array[i] >= 'A' && array[i] < 'Z'){//判断是否在大写字母的ASCII编码范围中，是的话执行Upper++;用于统计
                Upper++;
            }else if (array[i] >= 'a' && array[i] < 'z'){
                lower++;
            }else if (array[i] >= '0' && array[i] < '9'){
                number++;
            }else{
                other++;
            }
        }

        System.out.println("Upper Case : " + Upper);
        System.out.println("Lower Case : " + lower);
        System.out.println("Number : " + number);
        System.out.println("Other : " + other);
    }

    public static void judgment2(String something){

        int Upper = 0;
        int lower = 0;
        int number = 0;
        int other = 0;
        for (int i = 0 ; i < something.length() ; i++){
            if (something.charAt(i) >= 'A' && something.charAt(i) < 'Z'){//判断是否在大写字母的ASCII编码范围中，是的话执行Upper++;用于统计
                Upper++;
            }else if (something.charAt(i) >= 'a' && something.charAt(i) < 'z'){
                lower++;
            }else if (something.charAt(i) >= '0' && something.charAt(i) < '9'){
                number++;
            }else{
                other++;
            }
        }

        System.out.println("Upper Case : " + Upper);
        System.out.println("Lower Case : " + lower);
        System.out.println("Number : " + number);
        System.out.println("Other : " + other);
    }
}
