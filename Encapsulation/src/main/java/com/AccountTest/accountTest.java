package com.AccountTest;

public class accountTest {

    public static void main(String[] args) {

        accountObject person1 = new accountObject();

        person1.setName("Jie");
        person1.setBalance(2000);
        person1.setPassword("123456");

        person1.showInfo();

        accountObject person2 = new accountObject("HoHo" , 60 , "123456");
        person2.showInfo();

    }

}
