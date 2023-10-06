package exercise03;

public class main {

    public static void main(String[] args) {

        Teacher person1 = new Professor("Lim Yee Jie",19,"Professor",100000);
        Teacher person2 = new Asc_Professor("Sonia",18,"Asc Professor",100000);
        Teacher person3 = new Lecturer("Kaiyang",20,"Lecturer",100000);

        person1.introduce();
        person2.introduce();
        person3.introduce();

    }

}
