package example09;
/*
接口和数组相结合的多态
 */
public class example09 {
    public static void main(String[] args) {
        //使用接口类型创建数组
        AAA [] array = new AAA[2];
        array[0] = new DDD();
        array[1] = new CCC();

        for (int i = 0; i < array.length; i++) {
            array[i].start();
            array[i].end();
            if(array[i] instanceof BBB){//判断该array[i]的运行类型是否是BBB或其子类
                ((BBB) array[i]).haha();//向下转型（因为这个方法是BBB类特有的方法，而array[i]的编译类型是AAA，体现了多态）
            }
        }
    }
}

interface AAA{
    public void start();
    public void end();
}

class BBB implements AAA{

    @Override
    public void start() {
        System.out.println("Class B start");
    }

    @Override
    public void end() {
        System.out.println("Class B end");
    }

    public void haha(){//class BBB特有方法
        System.out.println("only class BBB");
    }
}
class CCC implements AAA{

    @Override
    public void start() {
        System.out.println("class C start");
    }

    @Override
    public void end() {
        System.out.println("class C end");
    }

    public void hihi(){ //class CCC特有方法
        System.out.println("only class CCC");
    }
}

class DDD extends BBB{
    @Override
    public void haha() {
        System.out.println("here is class D");
    }
}