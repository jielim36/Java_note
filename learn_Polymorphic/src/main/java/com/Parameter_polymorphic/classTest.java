package com.Parameter_polymorphic;

public class classTest {

    public static void main(String[] args) {

        worker tom = new worker("Tom", 3500);
        Manager limYeeJie = new Manager("Lim Yee Jie", 30000, 10000);

        //想要把上面两个对象的参数传到这个类中的showEmpAnnual方法需要对这个类创建一个对象
        classTest classTest = new classTest();

        classTest.showEmpAnnual(tom);//在参数中传入上面的对象
        classTest.showEmpAnnual(limYeeJie);

        classTest.testWork(tom);
        classTest.testWork(limYeeJie);

    }




    public void showEmpAnnual(Employee employee){
        System.out.println("Employee Annual : " + employee.getAnnual());
    }

    public void testWork(Employee e){

        if(e instanceof worker){
            ((worker) e).work();//向下转型
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }else if(e instanceof Employee){
            System.out.println("");
        }else{
            System.out.println("Error Object, it is not employee");
        }

    }

}
