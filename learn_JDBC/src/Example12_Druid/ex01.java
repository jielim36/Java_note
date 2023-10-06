package Example12_Druid;

//使用Druid前的工作：把jar包放入该项目中，然后把配置文件druid.properties也放入该项目中

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ex01 {
    @Test
    public void tutorial() throws Exception{
        //读取配置文件druid.properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //创建一个指定参数的数据库连接池（数据源）
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);//需要放入读取到配置文件的properties，里面有写入各种参数如最大连接数等等

        //通过dataSource对象获取连接返回给connection对象
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功!");
        //关闭连接
        connection.close();
    }

    /**
     * 该方法用于测试Druid的速度，测试获取和关闭连接500000(五十万)次所需的时间
     * 测试结果：447毫秒左右（已知C3P0的速度是1495毫秒左右）
     * @throws Exception
     */
    @Test
    public void testing() throws Exception{
        //读取配置文件druid.properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //创建一个指定参数的数据库连接池（数据源）
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);//需要放入读取到配置文件的properties，里面有写入各种参数如最大连接数等等

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            //通过dataSource对象获取连接返回给connection对象
            Connection connection = dataSource.getConnection();
            //关闭连接
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end-start));//447毫秒
    }

}
