package exercise02;

import java.sql.SQLOutput;

public class exercise02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        System.out.println("===============");

        Frock one = new Frock();
        System.out.println(one.getSerialNumber());

        Frock two = new Frock();
        System.out.println(two.getSerialNumber());

        Frock three = new Frock();
        System.out.println(three.getSerialNumber());
    }
}

class Frock{
    private static int currentNum = 100000;//衣服出厂的序列号初始值
    private int serialNumber;

    public static int getNextNum(){
        return currentNum += 100;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }
}
