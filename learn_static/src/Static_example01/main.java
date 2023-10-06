package Static_example01;
@SuppressWarnings("all")
public class main {

    //static 静态变量/类变量 ： 是该类中的所有对象共享的变量，任何一个该类的对象去访问它时都是相同的值，
    //任何一个该类的对象去修改它时，修改的也是同一个变量，
    // 也就是说全部该类的对象都共享同一个变量的值，某个该类的对象修改了静态变量的值后其他该类的对象的也会更改
    public static void main(String[] args) {

        player person1 = new player("HoHo");
        person1.numberPlayer++;

        player person2 = new player("Jielim");
        person2.numberPlayer++;

        player person3 = new player("Kaiyang");
        person3.numberPlayer++;

        System.out.println("Total player: " + player.numberPlayer);//这里直接只用类变量，不需要使用person1.numberPlayer;

        System.out.println(person1.getName());//输出：HoHo
        System.out.println(person2.getName());//输出：Jielim
        System.out.println(person3.getName());//输出：Kaiyang

    }

}
