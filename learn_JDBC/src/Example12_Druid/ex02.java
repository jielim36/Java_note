package Example12_Druid;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
测试使用Druid的工具类
 */
public class ex02 {
    public static void main(String[] args) throws SQLException {

        //先定义各种对象(因为要try-catch，所以没有直接创建，而是先定义，
        // 因为如果直接在try-catch里定义，try-catch外部无法调用该对象（作用域问题）)
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //获取连接
            connection = JDBCUtils_Druid.getConnection();//直接获取连接，不需要进行读取配置文件等操作了
            System.out.println("运行类型："+connection.getClass());//运行类型：class com.alibaba.druid.pool.DruidPooledConnection
                                                                  //如果是原生MySQL的connection的话，运行类型：class com.mysql.jdbc.JDBC4Connection
            String sql = "SELECT id,`name` FROM news WHERE ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,5);

            resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "\t" + name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            JDBCUtils_Druid.close(resultSet,ps,connection);
        }



    }
}
