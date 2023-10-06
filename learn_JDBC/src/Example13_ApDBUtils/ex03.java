package Example13_ApDBUtils;

import Example12_Druid.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ex03 {
    /**
     * 演示 apache-dbutils + druid 完成返回结果是单行记录（单个对象）
     */
    @Test
    public void testQuerySingle() throws SQLException {

        //1. 得到连接
        Connection connection = JDBCUtils_Druid.getConnection();

        //2.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //3. sql语句
        String sql = "select * from actor where id = ?";

        //执行sql语句
        /*
        我们只是获取单行记录（我们的记录是一个对象，里面有各种属性）
        所以query方法内是传入 BeanHandler
        如果是之前的返回多个记录，就使用BeanListHandler，通过集合返回数据
         */
        Actor actor = queryRunner.query(connection,sql, new BeanHandler<>(Actor.class) , 2);

        System.out.println(actor);//如果我们填入的id找不到任何记录，返回null

        //释放资源
        JDBCUtils_Druid.close(null,null,connection);
    }

    /**
     * 演示查询结果是单行单列，返回的是Object对象
     */
    @Test
    public void testScalar() throws SQLException {//Scalar ：在java中指的是 单行单列，单一值

        Connection connection = JDBCUtils_Druid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select name from actor where id = ?";

        Object obj = queryRunner.query( connection , sql, new ScalarHandler<>() , 2 );
        /*
        这里的query方法内是传入了ScalarHandler , 而不是之前的Bean
        Bean的作用通常是我们自己创建的类，然后需要返回该类的时候使用
        如果是在该案例中，我们返回的仅仅是name这个值(可能是字符串), 就不需要在通过Actor类对象来接收数据，直接使用Object对象，使用Object对象是因为返回的数据类型不确定
         */

        System.out.println(obj);

        JDBCUtils_Druid.close(null,null,connection);
    }

}
