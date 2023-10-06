package Static_example01;

public class player {

    private String name;//这个name是没有共享的，所以每个对象都有自己独立的属性
    public static int numberPlayer = 0; //static （静态变量/类变量），可以让所有对象共享一个属性，
    // 然后之后如果要调用可以使用类名调用而不需要使用具体对象名
    //比如: player.numberPlayer();
    //而不是 person1.numberPlayer(); ，不过其实也能调用，只是更推荐使用类名调用
    //细节部分 ： static静态变量/类变量在 类加载的时候就生成了。
    // 也就是说，即使你没有创建对象，只要类加载了，就可以使用静态变量/类变量了
    //比如：直接在main里不创建对象并且直接使用类名调用 sout(player.numberPlayer)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNumberPlayer() {
        return numberPlayer;
    }

    public static void setNumberPlayer(int numberPlayer) {
        player.numberPlayer = numberPlayer;
    }

    //这是构造器
    public player(String name) {
        this.name = name;
    }
}
