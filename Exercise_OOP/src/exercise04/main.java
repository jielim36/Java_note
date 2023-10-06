package exercise04;

public class main {

    public static void main(String[] args) {

        Employee person1 = new Admin("Lim Yee Jie",200,30);
        Employee person2 = new normalEmployee("Jie",200,30);

        person1.showInfo();
        person2.showInfo();

    }

}
