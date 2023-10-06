package com.mycompany.houserent;

import com.mycompany.houserent.view.HouseView;

public class HouseRentApp {
    //创建HouseView对象，并且显示主菜单，是整个程序的入口

    public static void main(String[] args) {

        new HouseView().mainMenu();
        System.out.println("===你退出了房屋出租系统===");
    }

}
