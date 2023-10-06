package com.hashcode;

public class learn_toString {

    public static void main(String[] args) {

        human test = new human("Jie" , "kill" , 100);
        System.out.println(test.toString());

        /*
        默认情况(该对象没有重写toString)下的 toString的源代码：


        public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
        1. getClass().getName()  类的全类名（包名+类名）
        2. Integer.toHexString(hashCode() 将对象的hashCode值传换成16进制的字符串

         */


        //如果该对象有重写toString的情况下 :
        monster monster = new monster("Lim Yee Jie", "Programmer", 100000);
//        System.out.println(monster.toString());
        System.out.println(monster); //直接写monster  System.out.println(monster.toString());
    }



}

class monster{

    private String name;
    private String job;
    private double salary;

    public monster(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    //重写toString的方法，输出对象的属性
    //使用alt + insert快捷键然后选择 toString()


    @Override
    public String toString() {
        return "monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class human{

    private String name;
    private String job;
    private double salary;

    public human(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }
}