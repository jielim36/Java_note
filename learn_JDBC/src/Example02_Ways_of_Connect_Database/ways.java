package Example02_Ways_of_Connect_Database;




import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 获取数据库连接的五种方式和它的优缺点
 * 注意：只演示连接操作，不包括执行语句等操作
 */
public class ways {
    public static void main(String[] args) {

    }

    @Test
    public void method1() throws SQLException {
        /**
         * 方法1： 获取Driver实现类对象 （也就是Example02的main文件展示的方法）
         * 问题：会直接使用com.mysql.jdbc.Driver()，属于静态加载，灵活性差，依赖强
         *
         * 解释：
         * 类加载分为动态和静态：
         * 静态加载：编译时加载相关的类(这里指的Driver类)，如果没有则报错，依赖性太强
         * 动态加载：运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性
         */
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/java_database";

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void method2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        /**
         * 方法2：通过反射的方式加载Driver
         * 好处：通过反射加载Driver类，属于动态加载，更加灵活，减少依赖性；
         *      通过反射可以直接把driver，user,password写入配置文件然后直接读取
         */
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");//这里的字符串也可以通过读取配置文件来获取，但是这里直接用写的方式
        Driver o = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/java_database";//数据库的地址

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Connection connection = o.connect(url,properties);
        System.out.println(connection);

        connection.close();//关闭/释放资源

    }

    public void method3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        /**
         * 方式3：使用DriverManager替换Driver进行统一管理
         *
         */

        //首先还是使用反射加载
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //还是写好url数据库地址
        String url = "jdbc:mysql://localhost:3306/java_database";
        //在DriverManager里可以用properties写user和password，也可以使用字符串
        String user = "root";
        String password = "123456";

        //使用DriverManager注册Driver驱动
        DriverManager.registerDriver(driver);

        DriverManager.getConnection(url,user,password);//这个getConnect方法接受平时的properties写user和password，也接受通过String字符串写的user和password


    }

    @Test
    public void method4() throws SQLException, ClassNotFoundException {

        /**
         * 方式4： 使用Class.forName 自动完成注册驱动，简化代码
         *
         */

        //使用反射加载了Driver类；当加载Driver类时会自动完成注册
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
/*
com.mysql.jdbc.Driver ， 这里跳进Driver看源码：

static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeExcepntion("Can't register driver!");
        }
    }
    可以发现源码中有一个Static代码块，意味着当加载该类时就会加载该代码块。
    该代码块中执行了：通过DriverManager注册Driver驱动，源码：DriverManager.registerDriver(new Driver());

    注意：
    即使不写Class<?> aClass = Class.forName("com.mysql.jdbc.Driver"); ，这行代码也能自动注册并连接
    原因：
    1.mysql驱动5.1.6以后可以无需Class.forName("com.mysql.jdbc.Driver");
    2.从jdk1.5以后使用了jdbc4，不再需要显示调用class.forName()注册驱动
      而是自动调用驱动jar包下META-INF\services\java.sql.Driver文本中的类名称去注册
    3.但还是了建议写上Class.forName("com.mysql.jdbc.Driver") ,因为比较清晰
 */



//        Driver driver = aClass.newInstance(); 方式4可以直接省略这个实例化成一个Driver对象

        //依旧准备好 数据库地址 和 账号名+密码
        String url = "jdbc:mysql://localhost:3306/java_database";
        String user = "root";
        String password = "123456";

        //可以直接省略使用DriverManager注册Driver驱动
//        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url,user,password);

        System.out.println("方式4：" + connection);

        connection.close();//关闭
    }

    @Test
    public void method5() throws SQLException, ClassNotFoundException, IOException {
        /**
         * 方式5：使用配置文件，连接数据库更灵活（在方式4的基础上改进）,建议使用这个方式
         */

        //和方式4的区别在这里，把Driver,user,password都写入在Example02的mysql.properties文件中
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Example02\\mysql.properties"));
        //把properties对象从配置文件中读取到的信息每个提取出来: url,user,password和driver
        String url = properties.getProperty("url");//这里的字符串是写入key值，然后就会得到value值："jdbc:mysql://localhost:3306/java_database"
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);


        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("方式5："+connection);

        //尝试执行语句：
        Statement statement = connection.createStatement();

        String sql = "insert into actor values(null,'kaiyang','M','2004-01-01','01110982345')";
        int row = statement.executeUpdate(sql);
        System.out.println(row > 0 ? "执行成功：影响了"+row+"条行数" : "执行失败...");


        statement.close();
        connection.close();//关闭/释放资源

    }

    }
