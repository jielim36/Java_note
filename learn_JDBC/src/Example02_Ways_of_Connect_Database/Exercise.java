package Example02_Ways_of_Connect_Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings("all")
public class Exercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        /*
        1.创建一个news表（在mysql完成此操作）
        2.使用jdbc添加5条数据
        3.修改id=1的记录，将content改成一个新的消息
        4.删除id=3的记录
         */

        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Example02\\mysql.properties"));
        //提取成字符串
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);

        //获取数据库连接
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("连接数据库：" + connection);//查看返回结果验证是否连接成功

        //添加五条记录
        //执行语句, ?问号是占位符
        //创建Statement对象
        Statement statement = connection.createStatement();
        String sql = "dele  te from news where id = 3";

        //这里的代码忽略，原本是尝试使用PreparedStatement的
        //给占位符赋值,第一个数值是表示第几个占位符（应该）
//        ps.setString(1,"null,'jack','M','2002-08-13','0163333333'");
//        ps.setString(2,"null,'kaiyang','M','2004-01-01','0111092345'");
//        ps.setString(3,"null,'limyeejie','M','2004-07-23','01116540123'");
//        ps.setString(4,"null,'kelvin','M','2004-02-09','0111055545'");
//        ps.setString(5,"null,'Issac','M','2003-09-02','0161222345'");

        int row = statement.executeUpdate(sql);
        System.out.println(row > 0 ? "执行成功：影响了"+row+"条行数" : "执行失败...");


        statement.close();
        connection.close();

    }
}
