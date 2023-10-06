package example00;

public class User {
    private int age = 2;
    private String name = "小明";

    private User(int age, String name) { //private构造器
        this.age = age;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
