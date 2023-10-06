package com.mycompany.houserent.service;

import com.mycompany.houserent.domain.House;
import com.mycompany.houserent.utility.utility;
import com.mycompany.houserent.view.HouseView;

/*
定义house数组用于保存house对象数据
1.响应HouseView的调用
2.完成对房屋信息的各种操作（增删改查）
 */
public class HouseService {

    private House[] houses;

    public HouseService() {
        houses = new House[1];
//        为了配合测试列表信息
        houses[0] = new House(1,"jack","112","KL",2000,"未出租");

    }

    //list方法，返回houses
    public House [] getList(){
        return houses;
    }

    public void additionArray(House obj){
        House [] arrayNew = new House[houses.length + 1 ];

        for (int index = 0 ; index < houses.length ; index++){
            arrayNew[index] = houses[index];
        }

        arrayNew[arrayNew.length-1] = obj;
        houses = arrayNew;
    }

    public void delArray(int target){

        int indexDel = target-1;

        House [] delArr = new House[houses.length-1];

        int i = 0;
        for (i = 0; i < houses.length; i++) {
            if(i == indexDel){
                break;
            }
            delArr[i]=houses[i];
        }
        for (; i < houses.length-1; i++) {
            delArr[i] = houses[i+1];
            delArr[i].setId(delArr[i].getId()-1);
        }

        houses = delArr;

    }

    public void searchHouse(){
        System.out.println("目前已有"+houses.length+"个房屋");
        System.out.print("输入房间编号：");
        int option = utility.readInt();
        if(option < 0 || option > houses.length){
            System.out.println("错误的房屋编号");
        }else {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(houses[option-1]);
        }
    }

    public void edit_infoHouse(int idArray ,int editInfoChoice){

            switch (editInfoChoice) {
                case 1: //name
                    System.out.print("姓名：");
                    houses[idArray].setName(utility.readString(10));
                    break;
                case 2:
                    System.out.print("电话 : ");
                    houses[idArray].setPhone(utility.readString(15));
                    break;
                case 3:
                    System.out.print("地址 ：");
                    houses[idArray].setAddress(utility.readString(50));
                    break;
                case 4:
                    System.out.println("月租: ");
                    houses[idArray].setRent(utility.readInt());
                    break;
                case 5:
                    System.out.println("状态: ");
                    houses[idArray].setState(utility.readString(5));
                    break;
                default:
                    System.out.println("无效的选项...");
                    break;
            }

        }
    }


