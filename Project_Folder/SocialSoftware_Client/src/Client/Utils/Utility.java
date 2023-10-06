package Client.Utils;

import java.util.Scanner;

/**
 * 该类是一个工具类
 * 主要是一些针对用户输入的数据进行处理
 */
public class Utility {
    //在实际开发中，公司都会提供相应的工具类和开发库，可以提高开发效率，程序员也需要能够看懂别人写的代码，并能够正确的调用

    //工具类的作用： 处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入
    static Scanner input = new Scanner(System.in);

    //readMenuSelection功能： 读取键盘输入的一个菜单选项，值 1 - 5 的范围
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("选择错误，请重新输入");
            } else break;
        }
        return c;
    }

    //readChar 读取键盘输入的一个字符
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    //readChar(char a) 读取键盘输入的一个字符
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, false);
        return (str.length() == 0) ? defaultValue : str.charAt(0);//如果没有输入（输入长度为0），输出默认值，否则输出键盘输入的值
    }

    //    readInt 功能： 读取键盘输入的整型，长度小于二位
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            //异常处理
            try {
                n = Integer.parseInt(str);
                    break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }

    //readString功能：读取键盘输入的指定长度的字符串
    //limit = 限制的长度
    public static String readString(int limit) {
        return readKeyBoard(limit, false);

    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    public static char readConfirmSelection() {
        System.out.println("请输入你的选择（Y/N）");
        char c;
        for (; ; ) {
            //在这里接收的字符都会转成大写字母
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，请重新输入： ");
            }
        }
        return c;
    }

    //读取字符串
    public static String readKeyBoard(int limit, boolean blankReturn) {

        String line = "";

        //scanner.hasNextLine() 判断有没有下一行
        while (input.hasNextLine()) {
            line = input.nextLine();//读取这一行

            //如果line.length = 0 , 即用户没有输入任何内容，直接回车
            if (line.length() == 0) {
                if (blankReturn)
                    return line;//如果blankReturn = true;，可以返回字串（可以输入空的字符串）
                else {
                    continue;
                    //如果blankReturn false，不接受空的字符串，必须输入内容
                }
            }
            if (line.length() < 0 || line.length() > limit) {
                System.out.println("输入长度（不能大于" + limit + ")错误，请重新输入 ： ");
                continue;
            }
            break;
        }
        return line;
    }

}
