package com.mycompany.houserent.view;

import com.mycompany.houserent.domain.House;
import com.mycompany.houserent.service.HouseService;
import com.mycompany.houserent.utility.utility;

public class HouseView {
    /*
    1.显示界面
    2.接受用户的输入
    3.调用HouseService完成对房屋信息的各种调用
     */

    private boolean loop = true;//控制主菜单的循环
    private char key;//接受用户的选择
    private HouseService houseService = new HouseService();
    private int numberHouse=2;

    public void showList(){
        System.out.println("================房屋出租系统菜单================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.getList();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
    }

    public void addHouse(){
        System.out.println("================添加房屋================");
        int ID = houseService.getList().length+1;//现在array是3个格子-> 0 , 1 ,2 ,代表添加新的后id刚好是3
        System.out.print("姓名：");
        String name = utility.readString(10);
        System.out.print("电话： ");
        String phone = utility.readString(15);
        System.out.print("地址: ");
        String address = utility.readString(50);
        System.out.print("月租: ");
        int rent = utility.readInt();
        System.out.print("状态: ");
        String state = utility.readString(3);

        House newHouse = new House(ID,name,phone,address,rent,state);
        houseService.additionArray(newHouse);
    }

    public void delHouse() {
        System.out.println("===========删除房屋信息==========");
        System.out.print("请输入想要删除的房屋编号 ： ");
        int target = utility.readInt();

        if (target > houseService.getList().length || target <= 0) {
            System.out.println("无效的编号...");
        } else {
            House[] name = houseService.getList();//为了得到该数组的具体格子的房主名字
            System.out.println("你确定要删除 (编号 " + target + "，房主名字：" + name[target - 1].getName() + ")的房屋信息吗?");
            char option = utility.readConfirmSelection();

            if (option == 'Y') {
                houseService.delArray(target);
            } else {
                return;
            }


        }
    }

    public void searchHouse(){
        houseService.searchHouse();
    }

    public void editInfo() {
        House[] editArrayInfo = houseService.getList();

        System.out.println("目前已有" + editArrayInfo.length + "个房屋");
        System.out.print("输入想要修改的房间编号：");
        int option = utility.readInt();
        if (option < 0 || option > editArrayInfo.length) {
            System.out.println("错误的房屋编号");
        } else
         {

            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(editArrayInfo[option - 1]);

            for (; ; )
            {
                System.out.println("\n请问你想要修改什么信息呢？\n1.房主  2.电话  3.地址  4.月租  5.状态  6.取消修改\"");
                System.out.println("请输入 : ");
                int editInfoChoice = utility.readInt();
                if (editInfoChoice <= 0 || editInfoChoice > 6)
                {
                    System.out.println("错误的选项，请重新输入选项");
                } else if (editInfoChoice == 6)
                    {
                        break;
                    } else
                        {
                            houseService.edit_infoHouse(option - 1, editInfoChoice);
                            System.out.println("是否要继续修改？");
                            char choice = utility.readConfirmSelection();
                            if(choice == 'N')
                            {
                                break;
                            }
                        }
            }
         }
    }

    public void exit(){
        System.out.println("您确定要退出吗？");
        char option = utility.readConfirmSelection();
        if(option == 'Y'){
            loop = false;
        }
    }

    public void mainMenu(){

        do{
            System.out.println("================房屋出租系统菜单================");
            System.out.println("\t\t\t1.新 增 房 源");
            System.out.println("\t\t\t2.查 找 房 屋");
            System.out.println("\t\t\t3.删 除 房 屋");
            System.out.println("\t\t\t4.修 改 房 屋 信 息");
            System.out.println("\t\t\t5.房 屋 列 表");
            System.out.println("\t\t\t6.退  出");
            System.out.print("请输入你的选择(1-6)： ");

            key = utility.readChar();
            switch (key){
                case '1' :
                    System.out.println("新  增");
                    addHouse();
                    break;
                case '2' :
                    System.out.println("查  找");
                    searchHouse();
                    break;
                case '3' :
                    System.out.println("删  除");
                    delHouse();
                    break;
                case '4' :
                    System.out.println("修  改");
                    editInfo();
                    break;
                case '5' :
                    System.out.println("房 屋 列 表");
                    showList();
                    break;
                case '6' :
                    exit();
                    break;
                default:
                    System.out.println("请输入正确的选项");
            }

        }while(loop);

    }


}
