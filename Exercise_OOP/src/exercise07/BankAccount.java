package exercise07;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){//存款
        balance += amount;
    }
    public void withdraw(double amount){//取款
        balance -= amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void showInfo(){
        System.out.println("Balance : " + balance);

    }

}
