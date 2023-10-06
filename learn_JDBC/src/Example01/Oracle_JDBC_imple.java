package Example01;

/**
 * 模拟一个Oracle数据库实现JDBC接口
 */

public class Oracle_JDBC_imple implements JDBC_Interface{
    @Override
    public Object getConnection() {
        System.out.println("得到Oracle的连接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成对Oracle的增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭Oracle的连接");
    }
}

