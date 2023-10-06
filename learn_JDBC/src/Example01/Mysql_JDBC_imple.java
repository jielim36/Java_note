package Example01;

/**
 * 这个class模拟一个 MySQL连接JDBC的实现接口部分
 */

public class Mysql_JDBC_imple implements JDBC_Interface{


    @Override
    public Object getConnection() {
        System.out.println("得到mysql的连接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成对mysql的增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql的连接");
    }
}
