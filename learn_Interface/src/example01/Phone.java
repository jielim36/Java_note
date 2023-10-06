package example01;

public class Phone implements Usb_Interface{ //如果没有实现这个接口的方法就会报错


    @Override
    public void start() {
        System.out.println("手机开始工作...");
    }

    @Override
    public void end() {
        System.out.println("手机结束工作...");
    }
}
