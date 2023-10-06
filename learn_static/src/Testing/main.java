package Testing;

public class main {
    public static void main(String[] args) {
        dog obj = new dog("大壮");
        System.out.println(obj.getName());
    }
}

class dog{
    String name;
    public dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
