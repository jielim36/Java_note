package example03;

public class B implements DataBase_Interface{
    @Override
    public void connect() {
        //实现Oracle的连接代码
        System.out.println("Oracle connect");
    }

    @Override
    public void close() {
        //实现Oracle的断开连接代码
        System.out.println("Oracle disconnect");
    }
}
