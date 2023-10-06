package example01;
/*
Interface : 接口
接下来的例子是利用了现实世界的思维做的一个例子

接口可以把他当作一个usb插槽，你可以把手机和相机都插在usb上，而且不用担心那个插槽是专门插哪个设备的
原因是做usb插槽的厂家和各种设备的厂家都遵守了统一的规定包括尺寸，排线等。

这里我们的程序变成思想是:
先创造一个usb接口（Usb_Interface）
然后让Phone和Camera接入该接口并且实现该接口里的方法
然后再将该usb插入设备的计算机（处理器）中

观看顺序：
1. Usb_Interface接口
2. Phone
3.Camera
4. Computer
5. example01(main方法)
 */
public class example01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();

        Computer computer = new Computer();
        computer.work(phone);//将该设备传入计算机（处理器）中
        System.out.println("====================");

        computer.work(camera);
    }
}