package com.menu;

import com.sun.security.jgss.GSSUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu_loop=true;
        char option;
        double money = 0; //入账
        String note = "";
        double balance = 0;
        Date date = null;
        String detail = "================零钱通明细=============";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");


        //menu loop
        do{

            System.out.println("==============零钱通菜单==============");
            System.out.println("1. 零钱通明细");
            System.out.println("2. 收益入账");
            System.out.println("3. 消费");
            System.out.println("4. 退出");

            System.out.print("请选择1-4 :  ");
            option = input.next().charAt(0);

            switch (option){

                case '1':
                    System.out.println("1. 零钱通明细");
                    System.out.println(detail);

                    break;

                case '2':
                    System.out.println("请输入 入账金额");
                    money = input.nextDouble();
                    balance += money;
                    date = new Date();

                    detail += "\n收益入账:" + money + "\t   " + sdf.format(date) +"   余额 ： " + balance;

                    break;

                case '3':
                    System.out.println("3. 消费");
                    System.out.println("请输入消费金额");
                    money = input.nextDouble();
                    System.out.println("请输入消费信息");
                    note = input.next();

                    balance -= money;
                    detail += "\n"+note+" : -" + money + "\t   " + sdf.format(date) +"   余额 ： " + balance;

                    break;

                case '4':
                    System.out.println("4. 退出");
                    menu_loop = false;
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }


            System.out.println("是否退出?\nY/N :");

            for(;;){
                option = input.next().charAt(0);
                if(option == 'y' || option == 'Y'){
                    menu_loop = false;
                    break;
                }else if (option == 'n' || option == 'N'){
                    menu_loop=true;
                    break;
                }else{
                    System.out.println("请输入正确的选项");
                }
            }

        }while(menu_loop);

    }

}
