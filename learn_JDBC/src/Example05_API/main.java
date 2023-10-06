package Example05_API;
/*
JDBC API:
1.DriverManager: 主要使用getConnect(url,user,password)方法
2.Connection接口：获取数据库连接，然后通过connection对象创建statement/preparestatement对象
3.Statement接口：用于执行SQL语句,执行executeUpdate(sql)方法然后会返回受影响的行数。（有SQL注入问题）
                执行executeQuery(sql)方法用于返回输出结果给ResultSet
4.PreparedStatement接口：该接口是Statement接口的子接口；
                        executeUpdate(); 括号内不需要再次放入sql字符串语句，因为已经经过预处理
                        executeQuery();查询，查询后接收返回的结果，并把结果给ResultSet
                        execute();执行任意SQL，并返回boolean值
                        setXxx(parameterIndex, content ); 对占位符？赋值
                        setObject(parameter,content) 一样，但按对象的方式赋值
 5.ResultSet（结果集）：next()方法，向下移动一行，并且返回boolean值，如果false表示没有下一行了
                      previous()方法，向上移动一行
                      getXxx(列的索引/列名)方法，比如getInt(1)/getInt(id);如果通过索引必须确保该索引的列和方法的数据类型一致，比如Int;推荐使用列名
                      getObject(列的索引/列名)：返回对应列的值，接收类型为Object
 */

public class main {
    public static void main(String[] args) {


    }
}
