package exercise09;

import javax.print.Doc;

public class Doctor {

    private String name;
    private int age;
    private String job;
    private String gender;
    private double salary;

    public Doctor(String name, int age, String job, String gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {//目的： 为了重写equals方法用于对比双方的属性是否相同，因为原本（Object类）的equals只能判断地址
        //思路，在真正开始对比双方的属性时，先使用 “过关斩将法”，意思是在对比前先找出所有错误的可能性，比如想要对比的对象其实根本不是这个对象的本类（Doctor）或其子类所以直接返回false然后就退出‘
        //如果过了设置的关卡，就可以真正开始对比了


        if(this == obj) { //关卡1 ： 先判断地址是否相同，如果地址相同就没有对比属性的必要，因为他们的属性一定相同（比如  person1.equals(obj)）
            return true;
        }
        if(!(obj instanceof Doctor)){ //关卡2： (注意条件中有感叹号 )判断想要对比的对象（obj）是否是Doctor类或者是Doctor的子类，如果不是的话直接返回false然后退出
            return false;
        }

        //确认了obj是的运行类型是Doctor的本类或其子类后，就可以开始对比属性了

        //第一步： 向下转型
        Doctor docObj  = (Doctor)obj;//这里把obj的属性赋值给doctor对象，然后就使用this和doctor对象进行对比(如果没有向下转型时，我们不能调用obj的属性（比如 obj.name 这些是不能调用的，需要进行向下转型）)

        return this.name.equals(docObj.name) && this.age == docObj.age && this.job.equals(docObj.job)
                 && this.gender.equals(docObj.gender) && this.salary == docObj.salary;
        //这里把双方的每一个属性都逐一对比，全部一样时才能返回true
        //值得注意的是，对比String类型时使用的是equals(系统中的Object类中的String子类也有重写equals，String的重写equals可以对比内容（字符串）)
        //然后我们对比基本数据类型(int,double,char等)时，使用的是 == 比较运算符




    }
}
