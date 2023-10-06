package example00;
/*
该类用于给其他类调用做示范
 */
public class Cat {
    private String name = "招财猫";
    public int age = 3;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void miao(){
//        System.out.println(name + "喵喵喵...");
    }

    public void cry(){
        System.out.println(name + "嘤嘤嘤");
    }
}
