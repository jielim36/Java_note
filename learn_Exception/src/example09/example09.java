package example09;

import java.util.Scanner;

/*
练习题:
如果用户输入的不是一个数字，就提示它反复输入，直到输入一个整数为止
 */
public class example09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for(;;) {
            try {
                System.out.print("请输入一个数字 : ");
                String number = input.nextLine();
                double num = Double.parseDouble(number);
                System.out.println("Number = " + num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("您输入的不是一个数字！请重新输入...");
            }

        }//loop
    }
}
