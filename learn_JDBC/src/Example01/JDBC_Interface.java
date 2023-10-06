package Example01;

/**
 * 这个Interface会模拟一个 JDBC接口
 */
public interface JDBC_Interface {

    //连接数据库
    public Object getConnection();

    //CRUD
    public void crud();

    //关闭连接
    public void close();

}
