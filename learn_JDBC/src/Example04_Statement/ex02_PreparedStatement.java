package Example04_Statement;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示PreparedStatement
 */
/*
PreparedStatement基本介绍：
1. 它是Statement的子接口
2.

预处理好处:
1. 不再使用 + 拼接字符
2.有效的解决了SQL注入问题
3.大大减少了编译次数，效率较高
 */
public class ex02_PreparedStatement {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        dml2();
    }

    public static void query() throws IOException, ClassNotFoundException, SQLException {
        //Properties读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class<?> aClass = Class.forName(driver);//这行代码其实可以省略

        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);

        //执行SQL语句
        //假设让用户输入name和id
        Scanner input = new Scanner(System.in);
        System.out.print("输入user name: ");
        String name = input.nextLine();//测试SQL注入的话请输入：1' or
        System.out.print("输入ID: ");
        String id = input.nextLine();//测试SQL注入的话请输入: or '1' = '1

        //得到PreparedStatement
        String sql = "SELECT id,`name` FROM news WHERE `name` = ? AND id = ?";//必须提前写好sql语句；问好表示占位符
        PreparedStatement preparedStatement = connection.prepareStatement(sql);//和Statement不同的是需要提前放入sql语句

        //给？问号占位符进行赋值
        preparedStatement.setString(1,name);//parameterIndex表示第几个问号占位符
        preparedStatement.setInt(2, Integer.parseInt(id));//因为我们上面的input用户输入是String类型，要转换成int类型

        //这里executeQuery()的括号必须为空，因为上面已经给了sql语句，这里给的话会出bug；除非该sql语句是固定/写死的；该案例中是用户提供的name和id，而且已经预处理了这里就再写的话是写上了一个还未对占位符赋值的sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int outputId = resultSet.getInt(1);
            String outputName = resultSet.getString(2);//columnIndex表示输出的表的第几个列
            System.out.println(outputName + "\t" + outputId);
        }

        connection.close();
        resultSet.close();
        preparedStatement.close();
        /*
        在PreparedStatement里尝试卡Bug：SQL注入问题
        输入user name: 1' or
        输入ID: or '1' = '1'
        Exception in thread "main" java.lang.NumberFormatException: For input string: "or '1' = '1'"
            at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
            at java.base/java.lang.Integer.parseInt(Integer.java:665)
            at java.base/java.lang.Integer.parseInt(Integer.java:781)
            at Example04_Statement.ex02_PreparedStatement.main(ex02_PreparedStatement.java:52)

        成功抵挡了这个SQL注入bug
         */

    }


        /**
         * 演示dml语句（增删改）
         */
    @Test
    public static void dml() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);

        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);

        //用户输入
        Scanner input = new Scanner(System.in);
        System.out.print("输入ID：");
        String id = input.nextLine();
        System.out.print("输入name：");
        String name = input.nextLine();

        //执行语句
        String sql_dml = "update news set id = ? where `name` = ?";
        PreparedStatement ps = connection.prepareStatement(sql_dml);
        ps.setInt(1,Integer.parseInt(id));
        ps.setString(2,name);

        int row = ps.executeUpdate();
        if (row > 0){
            System.out.println("执行成功！共影响了"+row+"行...");
        }else {
            System.out.println("执行失败...");
        }

        connection.close();

    }

    public static void dml2() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);

        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);

        //执行语句
        Scanner scanner = new Scanner(System.in);
        System.out.print("请问修改谁的名字，输入ID：");
        String id = scanner.nextLine();
        System.out.print("输入修改成什么名字：");
        String name = scanner.nextLine();

        //执行语句
        String update = "update news set name = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(update);
        ps.setInt(2,Integer.parseInt(id));
        ps.setString(1,name);

        int row = ps.executeUpdate();
        if (row > 0){
            System.out.println("执行成功，共影响了"+row+"行...");
        }else {
            System.out.println("执行失败...");
        }

        connection.close();
        ps.close();
    }


    }
