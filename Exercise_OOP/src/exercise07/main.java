package exercise07;

public class main {

    public static void main(String[] args) {

        BankAccount person1 = new CheckingAccount(100000);
        person1.showInfo();
        person1.deposit(1000);
        person1.showInfo();
        person1.withdraw(999);
        person1.showInfo();

        System.out.println("\n\nSaving Account : ");

        BankAccount person2 = new SavingsAccount(1000);//其实目前用到的东西没有需要使用多态，可以直接SavingsAccount person2 = new SavingsAccount
        person2.deposit(100);
        person2.deposit(100);
        person2.deposit(100);
        person2.deposit(100);//第四次开始就需要手续费了
        person2.showInfo();
        person2.withdraw(98);
        person2.showInfo();

        SavingsAccount personSaving = (SavingsAccount) person2;//向下转型
        personSaving.earnMonthlyInterest();//每月进行一次重置免手续费次数和把利息存入账号

        person2.showInfo();//注意这里使用的是一样是person2，向下转型后也可以继续用这个对象，因为person2和personSaving是同一个地址了，可以看作这两个对象都是同一个对象


    }
}
