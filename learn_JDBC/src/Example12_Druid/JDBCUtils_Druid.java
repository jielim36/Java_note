package Example12_Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils_Druid {
    private static DataSource ds;//数据源

    static { //初始化工作
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));//读取配置文件
            ds = DruidDataSourceFactory.createDataSource(properties);//创建数据源
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();//外部调用getConnection方法获取连接
    }

    /**
     * 该方法用于关闭资源，下面的三个参数其实都是通过Druid的来的，所以运行类型都是按照Druid，而不是JDBC
     * @param resultSet
     * @param statement Statement是一个接口，可以传入statement或者PreparedStatement对象都可以，因为都实现了Statement接口
     * @param connection Connection是一个接口，当我们使用的是Druid类型时，这里的connection.close方法也是Druid的，表示放回连接池，而不是真正意义上的关闭资源
     */
    public static void close(ResultSet resultSet , Statement statement , Connection connection) {
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();//注意：对于数据库连接池而言，close不代表真正意义上的关闭，而是把connection对象放回连接池
                                  // MySQL的原生Connection的close方法是直接关闭资源的。但是线程池如C3P0或Druid等的close方法都是放回连接池
                                    // （线程池的效率较高的原因就是因为连接并没有彻底关闭而是放回且可以循环使用）
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
