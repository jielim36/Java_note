package com.OOP_version;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class system {

    Scanner input = new Scanner(System.in);
    boolean menu_loop=true;
    char option;
    char askQuit;
    double money = 0; //入账
    String note = "";
    double balance = 0;
    Date date = null;
    String detail = "================零钱通明细=============";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");



    public void showMenu(){

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
                    this.detail();
                    break;
                case '2':
                    this.income();
                    break;
                case '3':
                    this.pay();
                    break;
                case '4':
                    this.quit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }


            System.out.println("是否退出?\nY/N :");

            for(;;){
                askQuit = input.next().charAt(0);
                if(askQuit == 'y' || askQuit == 'Y'){
                    menu_loop = false;
                    break;
                }else if (askQuit == 'n' || askQuit == 'N'){
                    menu_loop=true;
                    break;
                }else{
                    System.out.println("请输入正确的选项");
                }
            }

        }while(menu_loop);

    }

    public void detail(){
        System.out.println(detail);
    }
    public void income(){
        System.out.println("请输入 入账金额");
        money = input.nextDouble();
        balance += money;
        date = new Date();

        detail += "\n收益入账:" + money + "\t   " + sdf.format(date) +"   余额 ： " + balance;

    }

    public void pay(){
        System.out.println("3. 消费");
        System.out.println("请输入消费金额");
        money = input.nextDouble();
        System.out.println("请输入消费信息");
        note = input.next();

        balance -= money;
        detail += "\n"+note+" : -" + money + "\t   " + sdf.format(date) +"   余额 ： " + balance;

        return;
    }

    public void quit(){
        System.out.println("4. 退出");
        menu_loop = false;
        return;
    }




}
