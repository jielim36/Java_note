package example03;

public class A implements DataBase_Interface {

    @Override
    public void connect() {
        //实现MySQL的连接代码
        System.out.println("MySQL connect");
    }

    @Override
    public void close() {
        //实现MySQL的断开连接代码
        System.out.println("MySQL disconnect");
    }
}
