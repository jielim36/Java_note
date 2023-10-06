package Example09_someIssue;

/*
传统JDBC连接的弊端分析:

Java程序连接数据库的步骤：
得到连接-->发送SQL语句到数据库-->关闭连接

目前的问题：
1. 连接数据库的底层其实还是通过网络连接socket实现的，网络连接都比较费时间。
2. 当连接数据库的数量变多时，数据库无法承受，因为数据库的同时连接数量有限。
3. 将来Java程序如果是并发，有许多个线程。而且每个线程的连接数量都很多，那么数据库有可能会瘫痪。

官方回答:
1.传统的JDBC数据库使用DriverManager来获取，每次向数据库建立连接的时候都要将Connection加载到内存中，再验证IP地址，用户名和密码（0.05s~1s时间）。
  需要数据库连接的时候，就向数据库要求一个，频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器的崩溃。
2.每一次数据库连接，使用完都得断开，如果程序出现异常而未能关闭，将导致数据库内存泄漏，最终将导致重启数据库。
3.传统获取连接方式，不能控制创建的连接数量，如连接过多，也可能导致内存泄露，MySQL崩溃。
4.解决传统开发中的数据库连接问题，可以采用数据库连接池技术（Connection Pool）。
 */


import Example06_Utils.JDBC_Utils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class main {

    @Test
    public void test01(){
        for (int i = 0; i < 5000; i++) {
            //使用传统的JDBC方式得到连接
            Connection connection = JDBC_Utils.getConnection();
            //做一些工作...比如得到PreparedStatement后发送SQL语句等操作。

            //没有关闭连接
        }
        /*
        出现报错：
        Exception in thread "main" java.lang.RuntimeException: com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Data source rejected establishment of connection,  message from server: "Too many connections"

        可以发现系统说：Too many Connection
         */
    }

    @Test
    public void test02(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //使用传统的JDBC方式得到连接
            Connection connection = JDBC_Utils.getConnection();
            //做一些工作...比如得到PreparedStatement后发送SQL语句等操作。

            //有关闭连接
            JDBC_Utils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时长："+(end-start));//花费了5716毫秒左右
        /*
        出现的问题：
        虽然没有报错，但是花费的时间太长了。
         */
    }

    }
