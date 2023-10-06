package example07;
/*
接口的多态特性

解读：
1.work方法的形参是Usb_Interface接口类型(接口不能实例化对象，但是可以在形参中有创建对象去进行多态，也就是接收实现了该接口的类实例化对象)
2.该形参可以接收：看到，接收实现了该接口的类的对象实例（比如Camera和Phone的实例对象）
小结：Usb_Interface usb 即可以接收手机对象，又可以接收相机对象，就体现了接口，多态（接口引用可以指向实现了接口的类的对象）
 */
public class Computer {

    public void work(Usb_Interface usb){//形参是UsbInterface接口类型
        usb.start();
        usb.end();



    }

}