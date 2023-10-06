package Static_example03;

public class Static_Method {
    public static void main(String[] args) {

        Student person1 = new Student("Tom");
        person1.payFee(100);

        Student person2 = new Student("Tom");
        person2.payFee(200);

        Student.payFee(1000);//也可以直接类名+静态方法调用

        //display
        Student.showFee();
    }
}

class Student{

    private String name;
    private static double fee = 0;

    public Student(String name){
        this.name = name;
    }


    /*
    静态方法：
    1.当方法使用了static修饰后，该方法就是静态方法
    2.静态方法可以访问静态属性/变量。
     */
    public static void payFee(double fee){ //如果这里不使用static，就是每个对象都有自己的费用累加，
        Student.fee +=fee;                 //如果使用的是static方法，这里就是全部对象的费用累加
    }

    public static void showFee(){
        System.out.println("总学费有 ： " + Student.fee);
    }

}
