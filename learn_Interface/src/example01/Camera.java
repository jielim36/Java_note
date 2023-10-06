package example01;

public class Camera implements Usb_Interface{

    @Override
    public void start() {
        System.out.println("相机结束工作");
    }

    @Override
    public void end() {
        System.out.println("相机结束工作");
    }
}
