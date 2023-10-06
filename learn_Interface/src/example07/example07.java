package example07;
/*
接口体现多态的特性
看 Computer类
 */

public class example07 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();

        Computer computer = new Computer();
        computer.work(phone);//将该设备传入计算机（处理器）中
        System.out.println("====================");

        computer.work(camera);




    }
}
