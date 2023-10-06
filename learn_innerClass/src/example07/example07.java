package example07;
/*
匿名内部类的练习题：
 */
public class example07 {
    public static void main(String[] args) {
        //第一种方式
        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了!");
            }
        });

        CellPhone phone = new CellPhone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课啦!");
            }
        });
    }
}

interface Bell{
    void ring();
}
class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
        System.out.println("该对象的运行类型： "+bell.getClass());
    }
}
