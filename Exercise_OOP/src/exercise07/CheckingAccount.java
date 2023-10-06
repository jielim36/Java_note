package exercise07;


//在父类的基础上扩展 新类CheckingAccount用于对每次存款和取款都收取1美元的手续费

public class CheckingAccount extends BankAccount{

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount-1); //存款需要1美元手续费
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount+1);//取款需要1美元手续费
    }
}
