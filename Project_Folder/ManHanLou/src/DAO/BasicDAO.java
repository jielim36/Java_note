package DAO;

import Utility.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    //开发通用的增删改查方法

    /**
     * 该类负责修改数据库
     * 主要是DML(insert,update,delete)等操作
     * 该方法会返回一个int整数，该整数表示受影响的行数
     * @param sql 传入DML操作的sql语句
     * @param params 传入对sql语句中的占位符进行赋值
     * @return 返回一个int整数，该整数表示受影响的记录行数
     */
    public int update( String sql , Object... params ){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            int affectedRow = queryRunner.update(connection,sql,params);
            return affectedRow;
        } catch (SQLException e) {
            throw new RuntimeException(e);//将捕获到的编译异常转为运行异常
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    /**
     * 该类负责返回多个查询结果
     * @param clazz 传入class类型，也就是哪个Domain(JavaBean)
     * @param sql   sql语句
     * @param params    可变参数，对sql语句的占位符赋值
     * @return  返回一个List类型，该List存放着多个Domain类的对象
     */
    public List<T> queryMulti(Class<T> clazz , String sql , Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection , sql , new BeanListHandler<T>(clazz) , params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    /**
     * 该类负责返回单个查询结果
     * @param clazz 传入class类型，也就是哪个Domain(JavaBean)
     * @param sql   sql语句
     * @param params    可变参数，对sql语句的占位符赋值
     * @return  返回一个Domain对象，什么类调用该方法就返回该类的对象(因为泛型，所以多变)
     */
    public T querySingle(Class<T> clazz , String sql , Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection , sql , new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    /**
     * 该类负责返回一个单行单列的结果（比如：只返回name）
     * @param sql   sql语句
     * @param params    可变参数，对sql语句的占位符赋值
     * @return 返回一个Object类型，因为不确定返回的数据类型是什么。
     */
    public Object queryScalar(String sql , Object... params){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection , sql , new ScalarHandler() , params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

}
