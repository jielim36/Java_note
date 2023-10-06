package Exercise;

public class main {

    public static void main(String[] args) {
        System.out.println("\nObject Person:");
        Person person = new Person("HoHo" , 18);
        System.out.println(person.say());

        System.out.println("\nObject Student:");
        Student student = new Student("Lim Yee Jie",18,2290025, 99.9);
        System.out.println(student.say());
    }

}
