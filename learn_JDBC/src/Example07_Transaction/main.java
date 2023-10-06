package Example07_Transaction;

import Example06_Utils.JDBC_Utils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
事务的基本介绍：
1.JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务：
  即每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
2.JDBC程序中为了让多个SQL语句作为一个整体执行，需要使用事务
3.调用Connection的setAutoCommit(false)可以取消自动提交事务
4.在所有的SQL语句都成功执行后，调用Connection的commit();方法提交事务
5.在其中的某个操作失败或出现异常时，调用rollback();方法回滚事务
 */
public class main {
    public static void main(String[] args) {

    }

    /**
     * 演示尚未使用事务时的情况:
     * 情景：用户1账户上有3000块，用户2账户有10000块
     *      id=1的用户打算转账100块给id=2的用户。
     *      所以需要用户1 -100块，用户2 +100块
     *
     * 实验过程：用户1账户上有3000块，用户2账户有10000块
     *          未使用事务的情况下，执行两条sql语句
     *          第一条：用户1 -100块
     *          第二条：用户2 +100块
     *          但是我们在执行完第1条sql语句后故意制造一个异常，导致第二条sql语句无法执行
     *  实验结果：最终导致用户1的账户减少了100块，但是用户2的账户并没有增加100块。而且该事务已提交，不能回滚。
     *          用户1账户上剩下2900块，用户2账户上依旧是10000块。
     *
     *  问题：当两个有关联的语句必须同时执行成功确保没有问题才能提交数据。这就引出了事务的重要性。
     *       当我们执行这两条语句时，需要取消自动提交事务，并且开启事务再进行操作，当有错误时可以回滚。增加容错率。
     */
    @Test
    public void noTransaction() {
        Connection connection = null;
        PreparedStatement ps = null;

        String sql_1 = "update account set balance = balance - 100 where id = 1";
        String sql_2 = "update account set balance = balance + 100 where id = 2";
        try {
            connection = JDBC_Utils.getConnection();//通过example06自己写的工具类获取的connection
            ps = connection.prepareStatement(sql_1);//获取第一条sql语句
            ps.executeUpdate();//执行第一条语句

            int i = 1/0;//这里故意制造一个运行异常bug，让第二条语句无法执行

            ps = connection.prepareStatement(sql_2);//获取第二条sql语句 （把ps对象指向了第二条sql语句）
            ps.executeUpdate();//执行第二条语句

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JDBC_Utils.close(null,ps,connection);//关闭/释放资源
    }

    /**
     *  事务的重要性: 当两个有关联的语句必须同时执行成功确保没有问题才能提交数据。这就引出了事务的重要性。
     *  原因: 当我们执行这两条语句时，需要取消自动提交事务，并且开启事务再进行操作，当有错误时可以回滚。增加容错率。
     *  方法：
     *  步骤1：当我们通过getConnection获取连接之后，需要通过connection调用setAutoCommit(false);方法。表示取消自动提交事务，也表示开启了事务。
     *  步骤2：在try中的最后才提交事务commit，如果还未执行到提交事务时就已经发生异常，那么会直接被catch捕捉到，而不会运行到commit
     *  步骤3：我们的回滚操作可以在catch中执行，表示当捕捉到异常时回滚。
     *
     *  最终结果：
     *      有异常：当执行了第一条语句时发生错误，会直接报错并回滚，导致双方的余额都没有任何变化
     *      无异常：执行两条语句后依旧没有捕捉到异常，可以提交事务。最后双方的余额都改变了。
     */
    @Test
    public void Transaction(){
        Connection connection = null;
        PreparedStatement ps = null;

        String sql_1 = "update account set balance = balance - 100 where id = 1";
        String sql_2 = "update account set balance = balance + 100 where id = 2";
        try {
            connection = JDBC_Utils.getConnection();//通过example06自己写的工具类获取的connection
            connection.setAutoCommit(false);//取消自动提交事务，也表示开启了事务
            ps = connection.prepareStatement(sql_1);//获取第一条sql语句
            ps.executeUpdate();//执行第一条语句

//            int i = 1/0;//这里故意制造一个运行异常bug，让第二条语句无法执行

            ps = connection.prepareStatement(sql_2);//获取第二条sql语句 （把ps对象指向了第二条sql语句）
            ps.executeUpdate();//执行第二条语句

            //在执行完所有的操作后才执行提交事务，如果前面有发生异常，就直接去到catch区域而不会运行到这里的提交事务了
            connection.commit();

        } catch (Exception e){//这里的捕捉异常的范围更改成Exception表示任何异常都会导致回滚
            System.out.println("执行期间发生异常，将进行回滚操作...");
            try {
                connection.rollback();//回滚，即撤销所有执行的SQL语句
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            JDBC_Utils.close(null,ps,connection);//关闭/释放资源
        }

    }

}
