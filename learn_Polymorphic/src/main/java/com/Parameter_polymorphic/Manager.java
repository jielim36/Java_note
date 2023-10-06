package com.Parameter_polymorphic;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println(getName()+"经理" + "is managing...");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
