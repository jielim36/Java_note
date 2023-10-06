package exercise07;

public class SavingsAccount extends BankAccount{

    private int freeTimes=3;
    private double interest = 0.05;
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if(freeTimes>0){
            freeTimes--;
            super.withdraw(amount);
        }else{
            super.withdraw(amount+1);
        }
    }

    @Override
    public void deposit(double amount) {
        if(freeTimes >0){
            freeTimes--;
            super.deposit(amount);
        }else{
            super.deposit(amount-1);
        }
    }

    public void earnMonthlyInterest(){ //每个月初需要处理的东西
        freeTimes = 3;//重置每个月的取款存款的免手续费次数
        super.deposit(getBalance()*interest);//增加银行的余额的利息
    }

}
