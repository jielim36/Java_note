package com.Parameter_polymorphic;

public class worker extends Employee{

    public worker(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("普通员工 " + this.getName() + " is working now...");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
