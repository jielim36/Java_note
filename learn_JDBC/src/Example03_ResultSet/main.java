package Example03_ResultSet;

/*
ResultSet 结果集
基本底层介绍：
1.表示数据库结果集的数据表，通常通过执行查询数据库的语句生成
2.ResultSet对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前
3.next方法将光标移动到下一行，并且由于ResultSet对象没有更多行时返回false，因此可以在while循环中使用循环来遍历结果集
 */

/*
ResultSet其实是一个接口，然后由其他数据库通过这个接口的规范做了一个实现类，然后当我们创建这个接口时，会返回一个实现类
比如：通过debugger调式工具查看后，发现执行完 ResultSet resultSet = statement.executeQuery(sql); 这行代码后：
     我们的resultSet对象的运行类型变成了 JDBC42ResultSet

resultSet内有一个重要的属性是 rowData，rowData里有一个rows属性，该属性就是查询后返回的结果的行，然后会用ArrayList储存
rows属性里有elementData,size和modCount属性
    size：如果我们的查询的表有5条记录，就表示size=5（行数）。
    elementData：我们表中真正的数据是存储在这里，该属性是个数组，里面有internalRowData数组存储了每条记录的详细数据
                 当我们的每行的记录有四个列，该internalRowData里也会有四个数据，每个数据对应每个列
                 比如id列在internal数组的0下标，当id=4时，这里的数据是4的ASCII码，也就是52
                 比如name列中有多少个字符数量就有多少个数据，每个数据也是转成ASCII码包括汉字
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        //先得到相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);
        //获取数据库连接
        Connection connection = DriverManager.getConnection(url,user,password);

        //得到Statement用于执行语句
        Statement statement = connection.createStatement();
        String sql = "select id,`name`,gender,borndate from news";

        //使用查询语句时，需要创建一个ResultSet对象来获取返回结果
        ResultSet resultSet = statement.executeQuery(sql);//dml语句用executeUpdate方法，现在是查询所以用Query

        //ResultSet的光标说明
        /*
                +----+---------+--------+---------------------+------------+
 -光标初始位置->  | id | name    | gender | borndate            | phone      |
                +----+---------+--------+---------------------+------------+
 -使用next方法-> |  1 | jack    | M      | 2002-08-13 00:00:00 | 0163333333 |
                |  2 | kaiyang | M      | 2004-01-01 00:00:00 | 0111092345 |
                |  4 | kelvin  | M      | 2004-02-09 00:00:00 | 0111055545 |
    -最后一行->  |  5 | Issac   | F      | 2003-09-02 00:00:00 | 0161222345 |
  -返回false->  +----+---------+--------+---------------------+------------+
             可以看到光标一开始的初始位置是在第一行之前的，然后如果使用next方法就可以下去下一行
             如果下到了最后一行再使用next则会返回false，所以这时候需要有终止条件终止取出数据
         */

        //实践：使用while循环取出数据
        while(resultSet.next()){//当next返回true，代表有下一行；相反返回false表示已经最后一行了
            int id = resultSet.getInt(1);//表示获取当前光标所在的行的第1列数据
            String name = resultSet.getString(2);//name在第二列，所以写2
            String gender = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            //我们的查询select中没有要求返回手机号，所以这里也没有写
            //输出
            System.out.println(id+"\t"+name+"\t"+gender+"\t"+date);
        }


        //关闭连接
        resultSet.close();//结果集也需要关闭
        statement.close();
        connection.close();
    }
}
