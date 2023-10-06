package xx;

public class xx {

    public static void main(String[] args) {
        person person1 = new person("Lim Yee Jie");
        person1.total_number_person++;
        person person2 = new person("On Wu Xu");
        person2.total_number_person++;

        System.out.println(person.total_number_person);

    }


}

class person{

    private String name;
    public static int total_number_person=0;



    public person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}