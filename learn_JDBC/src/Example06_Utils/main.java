package Example06_Utils;
/*
封装 JDBC Utils
在JDBC操作中，获取连接和释放资源是经常使用到的，可以将其封装JDBC连接的工具类JDBC Utils

如果有三个线程操作数据库，分别进行增/改/查
线程1：连接数据库Connection --> 执行update语句 --> 释放资源close
线程2：连接数据库Connection --> 执行insert语句 --> 释放资源close
线程3：连接数据库Connection --> 执行Select语句 --> 释放资源close

可以发现三个线程中的连接数据库和释放资源操作是固定的。
此时就可以开发一个工具类（Utils），将连接数据库和关闭释放资源的代码封装起来，让每个线程都可以调用该工具类。
 */
public class main {
    public static void main(String[] args) {
//        JDBC_Utils.dml_insert("test",'M',2004,07,23,111111);
//        JDBC_Utils.dml_update(2,"jacky");
        JDBC_Utils.select(5);
    }
}