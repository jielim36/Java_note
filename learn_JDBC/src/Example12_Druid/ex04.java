package Example12_Druid;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ex04 {

    /**
     * apache DBUtils 完成DML (update,insert,delete)
     */
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtils_Druid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "update actor set name = ? where id = ?";

        int affectRow = queryRunner.update(connection,sql,"Rose", 6);
        /*
        进行update操作使用update方法，传入 connection , sql语句 , 可变参数(对每个占位符赋值)
        会返回一个整数，表示受影响的行数
         */
        System.out.println(affectRow >= 1 ? "修改成功!共影响了"+affectRow+"条记录" : "修改失败 或 执行没有影响到表");

        JDBCUtils_Druid.close(null,null,connection);
    }

    @Test
    public void testDML2() throws SQLException {
        Connection connection = JDBCUtils_Druid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "insert into actor values (null,?,?,?,?)"; //id是自增长，所以用null
//        String sql = "delete from actor where id = 6";

        int affectRow = queryRunner.update(connection,sql,"jack", "M" , "2004-07-29" , "0161121201");
//        int affectRow = queryRunner.update(connection,sql);
        /*
        insert,delete等dml操作都是通过update方法进行操作的
         */
        System.out.println(affectRow >= 1 ? "修改成功!共影响了"+affectRow+"条记录" : "修改失败 或 执行没有影响到表");

        JDBCUtils_Druid.close(null,null,connection);
    }

}
