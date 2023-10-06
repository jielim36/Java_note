package Example11_C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ex01 {

    //方式1：相关参数，在程序中指定user，url，password等（不推荐该方式，推荐方式2）
    @Test
    public void testC3P0() throws IOException, SQLException, PropertyVetoException {
        //记录时间（测试）
        long start = System.currentTimeMillis();

        //第一步：创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //第二步：通过配置文件mysql.properties获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");


//      如果使用连接池就不需要再使用传统方式获取连接  Connection connection = DriverManager.getConnection(url,user,password);
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

//      设置连接池的"初始化"连接数量
        comboPooledDataSource.setInitialPoolSize(10);//一开始有10个连接，如果不够用了再增加，直到最大连接数数
//      设置“最大”连接数
        comboPooledDataSource.setMaxPoolSize(50);//当最大连接数满了，剩下的连接需要等待/排队

        for (int i = 0; i < 5000; i++) {//重复连接5000次数据库，测试花费时间
            //获取连接
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();//关闭连接
        }
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("花费时间："+(end-start));//花费了560毫秒，传统方式花费5716毫秒（每次测试的成绩都不一致的）
        //传统方式是实实在在的重复连接了5000次
        // 连接池是最多50个连接数量重复使用
    }




    /**
     * 方式2：使用配置文件模板完成(将c3p0提供的c3p0.config.xml拷贝到src目录下)，该文件指定了连接数据库和连接池的相关参数
     * @throws SQLException
     */
    @Test
    public void testC3P0_2() throws SQLException {
        long start = System.currentTimeMillis();
        //通过对象指向配置文件获取参数，如：url,driver,user,password和initialPoolSize初始连接池大小等参数
        ComboPooledDataSource jielim36 = new ComboPooledDataSource("jielim36");//configName是在c3p0-config.xml里设置的

        for (int i = 0; i < 500000; i++) {//五十万次
            Connection connection = jielim36.getConnection();//不需要再写参数
            //关闭连接
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time:" + (end-start));//测试结果：执行五十万次需要1495毫秒
    }

}
