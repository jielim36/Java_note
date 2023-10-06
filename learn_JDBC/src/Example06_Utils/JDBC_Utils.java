package Example06_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC_Utils类是一个工具类。
 * 功能1：负责完成mysql的连接和关闭资源
 * 功能2：负责各种DML语句
 */
public class JDBC_Utils {
    //定义相关的属性，因为只需要一份。因此，我们做出static静态属性
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    /**
     * 静态代码块:
     * 负责通过Properties读取/初始化配置文件中的数据，获取连接mysql数据库的url,user,password和driver;
     */
    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //实际开发中，会把捕捉的“编译异常”，转换成一个运行异常"RuntimeException"。
            //这时调用者可以悬着捕捉该异常，也可以选择默认处理
            throw new RuntimeException(e);
        }
    }

    /**
     * getConnection方法负责连接数据库
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 负责关闭各种资源。
     * 该方法需要调用者传入三个参数：
     * 1.ResultSet结果集
     * 2.Statement（由于PreparedStatement是Statement的子接口，所以源码中直接是Statement类对象）
     * 3.Connection
     * 注意：当调用者在关闭资源时没有使用上述的某个类时，传入null。比如没有使用resultSet返回结果集时可以传入null。
     */
    public static void close(ResultSet resultSet , Statement statement,Connection connection){

        //如果ResultSet不等于空，表示需要关闭。因为如果没有使用resultSet，这里传入null
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * dml_update方法：可以进行update操作
     */
    public static void dml_update(int id , String name){
        //获取连接
        Connection connection = getConnection();

        //SQL语句
        String sql = "UPDATE actor SET `name` = ? WHERE id = ?";

        //创建PreparedStatement类对象ps
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);//PreparedStatement ps = connection.prepareStatement(sql);

            //对占位符进行赋值
            ps.setInt(2,id);
            ps.setString(1,name);

            int row = ps.executeUpdate();
            System.out.println("执行成功！共影响了"+row+"行...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        close(null,ps,connection);//第一个参数null表示没有使用resultSet

    }

    /**
     * dml_insert方法：
     * 对actor表进行insert操作
     */
    public static void dml_insert(String name, char gender , int Year , int month , int day , int phoneNumber){
        //处理传参数据
        String bornDate = Year + "-" + month + "-" + day;
        if (gender != 'M' && gender != 'F'){
            throw new RuntimeException("Invalid Gender...");//抛出异常后就会停止执行该方法
        }


        //获取连接
        Connection connection = getConnection();

        //SQL语句
        String sql = "INSERT INTO actor VALUES(null,?,?,?,?)";//(id,name,gender,bornDate,phone) ,id是自增所以null

        //创建PreparedStatement类对象ps
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);//PreparedStatement ps = connection.prepareStatement(sql);

            //对占位符进行赋值
            ps.setString(1,name);
            ps.setString(2,String.valueOf(gender));//char转成String
            ps.setString(3,bornDate);
            ps.setInt(4,phoneNumber);

            int row = ps.executeUpdate();
            System.out.println("执行成功！共影响了"+row+"行...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        close(null,ps,connection);//第一个参数null表示没有使用resultSet

    }


    public static void select(int id){
        Connection connection = getConnection();

        String sql = "SELECT id,`name`,gender FROM actor WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();

            //这里用for循环是为了只输出一次ID\tName\tGender,所以利用i的迭代机制来判断
            for (int i = 0 ; resultSet.next() ; i++) {
                if (i == 0){
                    System.out.println("ID\tName\tGender");
                }
                int getID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                System.out.println(getID + "\t" + name + "\t" + gender);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
