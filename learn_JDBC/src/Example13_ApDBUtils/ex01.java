package Example13_ApDBUtils;

/*
ApDBUtils 的使用场景引出：

现在的ResultSet有一个问题就是：
1. 当connection关闭之后，resultSet就无法使用。Java程序得到connection连接,发送select语句，然后返回resultSet。所以connection和resultSet是有关联的，即：connection关闭，resultSet就无法使用。
2. resultSet 不利于数据的管理。因为第一种情况的发生表示resultSet只能使用一次，当connection关闭后resultSet就不能再使用.
3. 使用返回的信息也不方便，因为我们获取resultSet返回的信息需要 resultSet.getString(xxx) ， 非常的麻烦

所以我们的优化方案就是：

第一步：将一个表变成一个实体类
       比如我们数据库的news表中有几个列：id,name,gender,borndate,phone。
       那么我们就可以创建一个类，类名：news , 里面的属性对应了news表的几个列
这种方法/方案被称为：JavaBean,PoJO,Domain

第二步：将resultSet封装到ArrayList中 （ ArrayList<news> 一个只专属给news类的ArrayList）
        然后一个news类对象代表一个news表的记录

 */

import Example12_Druid.JDBCUtils_Druid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * ex01会先使用一个自己写的“土方法”来演示原理，之后ex02再演示Apache的DBUtils的使用方法
 */
public class ex01 {

    /**
     * 该方法用于将select语句返回的news表存入ArrayList中
     */
    @Test
    public void testSelectToArrayList(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<News> newsList = new ArrayList<>();

        try {
            //获取连接
            connection = JDBCUtils_Druid.getConnection();//直接获取连接，不需要进行读取配置文件等操作了
            String sql = "SELECT * FROM news WHERE ID >= ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,1);

            resultSet = ps.executeQuery();
            while(resultSet.next()){
                //通过resultSet获取了每条记录的每个列
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Date date = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");

                //然后放入到ArrayList中
                newsList.add(new News(id,name,gender,date,phone));

            }//当整个while循环结束后，我们的arraylist就存放了所有返回的数据

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            JDBCUtils_Druid.close(resultSet,ps,connection);
        }

//        System.out.println("newsList集合："+newsList); //可以直接输出

        //也能针对某个列输出
        for (News news : newsList){//因为newsList是<News>的，可以直接增强for循环
            System.out.println( news.getId() + "\t" + news.getName() );//getId等方法都是News类的getter
        }

    }

}

/**
 * News类其实就是数据库中的news表，把这个表转换成一个实体类用于存放数据，一个News对象表示一条记录
 */
class News{
    private Integer id;
    private String name;
    private String gender;
    private Date bornDate;//java.util包下的Date类
    private String phone;

    public News() { //一定要给一个无参构造器，因为底层可能会使用到映射/反射
    }

    public News(Integer id, String name, String gender, Date bornDate, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bornDate = bornDate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nNews{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", bornDate=" + bornDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}