package exercise05;

public class main {

    public static void main(String[] args) {

        Employee person1 = new Worker();
        person1.setName("Person1");
        person1.setSalary(1000);

        Employee person2 = new Peasant("person2",1000);
        Employee person3 = new Waiter("person3",1000);
        Employee person4 = new Scientist("person4",100000,20000);
        Employee person5 = new Teacher("person5",1900,100,25);

        person1.showInfo();
        person2.showInfo();
        person3.showInfo();
        person4.showInfo();
        person5.showInfo();


    }

}
