package Example02_Ways_of_Connect_Database;

/*
JDBC程序编写步骤：
前置工作：在Java项目下创建一个文件夹，把数据库如MySQL提供的Connector驱动文件复制到该文件下，右键点击add as Libary
1.注册驱动 - 加载Driver类
2.获取连接 - 得到Connection
3.执行增删改查 - 发送SQL给mysql执行
4.释放资源 - 关闭

Example02的ways Java文件里会提供五种连接方式
*/

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws SQLException {
//前置工作：在Java项目下创建一个文件夹，把数据库如MySQL提供的Connector驱动文件复制到该文件下,右键点击add as libary

//        1.注册驱动 - 加载Driver类
        Driver driver = new Driver();

//        2.获取连接 - 得到Connection(想要连接到哪里)
        String url = "jdbc:mysql://localhost:3306/java_database";
        //jdbc:mysql:// 这个部分是固定的，规定好的一个协议
        //localhost主机，也可以是一个IP地址，所以我们的数据库如果不在本机上，就需要写IP地址，而不是本机localhost
        //3306：MySQL是在3306端口监听的（意思是数据库连接Java其实就是Socket连接）
        //java_database ： 表示你要连接到哪个数据库，比如可以连接到我们之前创建的db01,java_database是我自己为了测试jdbc创建的
        //然后将数据库的用户名和密码放入到properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");//用户名,第一个user参数字符串是固定的，root则是我们要登入的mysql账号的user
        properties.setProperty("password","123456");//密码，第一个字符串参数password是固定的，第二个参数"123456"则是我们要登入的mysql账号密码

        //使用driver对象的connect方法进行连接，然后给Connection对象，这个connect对象可以视为一个网络连接了
        Connection connect = driver.connect(url, properties);//将我们的url字符串对象和properties对象放入其中


//        3.执行增删改查 - 发送SQL给mysql执行
        String sql = "insert into actor values(null,'jack','M','2002-08-13','0163333333')";
//        String sql = "delete from actor where `name` = 'jack' ";
        //通过一个对象来执行sql语句时，是需要创建一个Statement或PreparedStatement的
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //statement对象的executeUpdate方法可以放入我们要的sql语句
                                                //返回的int数据表示“受影响的行数”，前提是sql语句是一个dml语句
        System.out.println(rows > 0 ? "成功":"失败");//然后可以通过返回的值判断是否执行成功

//        4.释放资源 - 关闭
        statement.close();
        connect.close();

    }
}
