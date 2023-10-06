package exercise11;

public class main {
    public static void main(String[] args) {

        Person [] person = new Person[4];
        person[0] = new Student("Lim Yee Jie","M",19,2290025);
        person[1] = new Student("HoHo","F",20,2299999);
        person[2] = new Teacher("Suhaillah","F",30,4);
        person[3] = new Teacher("Tee","M",32,9);

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);//person[i].toString 可以直接写成toString
        }
//        ((Teacher) person[3]).getWork_age();  注意，如果要调用子类特有成员（属性和方法），必须要对 对象 进行向下转型downcasting ， 上面代码可以display是因为调用时子类里有间接调用，总之不能在其他地方直接调用（必须先向下转型）


        person = ageConvert(person);
        System.out.println("\n\nAfter Convert : \n");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }

        callMethod(person[0]);
        callMethod(person[2]);
        callMethod(person[1]);
        callMethod(person[3]);


    }

    public static Person [] ageConvert(Person[] person){ // 冒泡排序
//        Person []temp = new Person[1];  原本的想法
        Person temp = null; //可以这样写

        for(int i = 0; i < person.length - 1 ; i++ ){
            for (int j = 0 ; j < person.length - 1 - i; j++){
                if(person[j].getAge() < person[j+1].getAge()){
                    temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }


        }
        return person;
    }


    public static void callMethod(Person p){
        if(p instanceof Student){
            ((Student) p).study();//向下转型,如果没有转型无法调用子类特有方法
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        }else{
            System.out.println("不是Person对象");
        }
    }


}
