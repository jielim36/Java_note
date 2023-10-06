package Example04_Statement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示statement的注入问题
 */
public class ex01_Statement {
    public static void main(String[] args) throws IOException, SQLException {

        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);

        //执行SQL语句,使用Statement演示SQL注入问题
        Statement statement = connection.createStatement();

        //假设让用户输入name和id
        Scanner input = new Scanner(System.in);
        System.out.print("输入user name: ");
        String name = input.nextLine();//测试SQL注入的话请输入：1' or
        System.out.print("输入ID: ");
        String id = input.nextLine();//测试SQL注入的话请输入: or '1' = '1

        //select name,id from news where name = 'x' and id = 'x';
        String sql = "SELECT `name`,id FROM news where name = '"+name+"' and id = '"+id+"'";

        ResultSet resultSet = statement.executeQuery(sql); //接收MySQL数据库返回的结果
        while(resultSet.next()){
            String outputName = resultSet.getString(1);
            int outputID = resultSet.getInt(2);
            System.out.println(outputName +"\t"+ outputID);
        }

        /*
        输入user name: 1' or
        输入ID: or '1' = '1
        jack	1
        kaiyang	2
        kelvin	4
        Issac	5

        可以发现使用这种方式即使不知道真正的id和name也可以获取全部人的数据，很危险，所以通常不使用Statement
         */

    }
}
