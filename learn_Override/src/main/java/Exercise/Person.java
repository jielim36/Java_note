package Exercise;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public void say() {
//        System.out.println("Name : " + name + "\nAge : " + age);
//    }

    public String say(){
        return ("Name : " + name + "\nAge : " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
