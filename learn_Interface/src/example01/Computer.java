package example01;

public class Computer {

    public void work(Usb_Interface usb){//这里模拟的是某个设备的处理器上的usb接口，而且这个方法的形参涉及到接口的多态，详细看example07
        usb.start();
        usb.end();
    }

}
