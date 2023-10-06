package Example13_ApDBUtils;

import Example12_Druid.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 演示正式的ApDBUtils(Apache DataBase Utils)
 * 查询操作
 */

/*
Apache - DBUtils
1.commons-dbutils 是 Apache组织提供的一个开源JDBC工具类，它是对JDBC的封装，使用dbutils能极大简化jdbc编码的工作量

-DBUtils类
1.QueryRunner类：该类封装了SQL的执行，是线程安全的。可以实现增删改查和批处理
2.使用QueryRunner类实现查询
3.ResultSetHandler接口：该接口用于处理java.sql.ResultSet, 将数据按要求转换成另一种形式。

常用：
ArrayHandler：把结果集中的第一行数据转成对象数组。
ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。ColumnListHandler：将结果集中某一列的数据存放到List中。
KeyedHandler（name）：将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key。 MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List

 */

public class ex02 {

    @Test
    public void testQueryMany() throws SQLException { //返回结果是多行的情况

        //1. 先得到一个连接
        Connection connection = JDBCUtils_Druid.getConnection();

        //2. 使用DBUtils类和接口，先引入DBUtils的jar包

        //3.创建一个QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4.现在就可以执行相关的方法，然后返回ArrayList结果集
        String sql = "select * from actor where id >= ?";//查询actor表的全部信息

        /*
        queryRunner的query方法会返回一个结果集，所以我们需要使用List来接收返回的结果集
        步骤1：query方法就是执行传入的sql语句
        步骤2：query方法得到了resultSet 封装到 ArrayList集合，然后返回
        步骤3：然后通过List对象接收返回的数据
        query方法中需要传入的对象：1.connection  ； 2.sql语句 ； 3. BeanListHandler  4. sql语句如果有占位符需要赋值就写上，多个占位符就用逗号隔开(该案例只有一个占位符，想要对占位符赋值为1)
        */
        List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class),1);
        /*
        解析：new BeanListHandler<>(Actor.class)

        底层中会通过反射机制把我们传入的Actor类，去获取我们的Actor类里的属性（id,name,gender）
        然后系统才能通过这些属性进行封装

        注意:
        1.如果我们的Actor类的属性和我们sql获取的属性不一致，会报错或null
           比如：Actor类只有id,name,gender三个属性，但是sql语句却返回了id,name,gender,bornDate,phone五个属性
        2.Actor类必须是public类，也就是说要单独创建一个class给Actor类
         */

        for ( Actor actor : query){ //这个query是List对象的变量名
            System.out.println(actor);
        }

        //释放资源
        JDBCUtils_Druid.close(null,null,connection);
    }

}

/*
query方法的源码

public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        return this.query(conn, false, sql, rsh, params);
    }
解析：
 1.conn 是我们传入的Druid类型的连接
 2.rsh 是传进去的BeanListHandler对象
 3.params是一个Object类型的可变参数，也就是可以放入多个参数然后变成一个数组，
   如果我们有多个占位符，这里就会接收多个占位符然后形成一个数组，
   之所以是可变参数是因为我们的占位符是根据自身需求的，没有固定的数量，所以使用可变参数


解析 return this.query(conn, false, sql, rsh, params);

会去到这里：
private <T> T query(Connection conn, boolean closeConn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        if (conn == null) {  //判断conn，sql和rsh是否为空，如果为空就报错
            throw new SQLException("Null connection");
        } else if (sql == null) {
            if (closeConn) {
                this.close(conn);
            }

            throw new SQLException("Null SQL statement");
        } else if (rsh == null) {
            if (closeConn) {
                this.close(conn);
            }

            throw new SQLException("Null ResultSetHandler");
        } else {  //如果conn,sql,和rsh都不为空表示通过，开始正式处理数据
            PreparedStatement stmt = null; //由于需要try-catch，所以提前创建对象且指向null（不提前创建对象直接在try-catch里面创建，try-catch的外面无法调用这些对象，因为作用域问题）
            ResultSet rs = null;
            T result = null; //之后返回数据就是返回这个result对象，这里的T是泛型，我们传入的Actor类就会对应这里的泛型(应该)

            try {
                stmt = this.prepareStatement(conn, sql); //创建一个prepareStatement对象（可以有占位符）
                this.fillStatement(stmt, params);  //该方法对sql的占位符进行赋值，赋值的数据是通过我们传入的params数组，里面有我们对占位符进行赋值时的数据
                rs = this.wrap(stmt.executeQuery()); //stmt.executeQuery方法执行我们的sql语句并且返回resultSet结果集，然后通过返回的resultSet通过wrap方法进行一些复杂的处理/封装然后赋给rs对象
                result = rsh.handle(rs); //然后rsh在通过handle方法对rs对象进行处理，然后赋给result对象，完成这个操作后，表示通过sql访问数据库返回的所有数据都已经被result对象获取了，已经封装成一个Actor类型(原本是泛型), 而且是一个ArrayList
            } catch (SQLException var33) {
                this.rethrow(var33, sql, params);
            } finally {
                try {
                    this.close(rs);
                } finally {
                    this.close(stmt);
                    if (closeConn) {
                        this.close(conn);
                    }

                }
            }

            return result; //返回result对象
        }
    }

 */
