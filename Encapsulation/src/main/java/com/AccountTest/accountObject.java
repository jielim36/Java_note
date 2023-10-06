package com.AccountTest;

public class accountObject {

    private String name;
    private double balance;
    private String password;

    public accountObject() { //default constructor
        this.name = "Invalid name";
        this.balance = -1;
        this.password = "Invalid Password";
    }

    public accountObject(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public void setName(String name) {
        if(name.length() >=2 && name.length() <=4){
            this.name = name;
        }else{
            System.out.println( "please enter the name in 2-4 digit character");
        }

    }

    public void setBalance(double balance) {
        if(balance < 20){
            System.out.println("Your balance at least are RM20");
            return;
        }
        this.balance = balance;
    }

    public void setPassword(String password) {
        if(password.length() == 6){
            this.password = password;
        }else{
            System.out.println("Your password must 6 digit");
        }
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getPassword() {
        return this.password;
    }

    public void showInfo(){
        System.out.println("Name: " + this.getName() + "\nBalance : " + this.getBalance() + "\nPassword : " + this.getPassword());
    }

}
