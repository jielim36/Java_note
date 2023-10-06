package Example01;

public class Test_JDBC {
    public static void main(String[] args) {

        //完成对mysql的操作 (这里的编译类型时JDBC接口，运行类型可以先用mysql，然后之后再更改成Oracle的)
        JDBC_Interface connectDatabase = new Mysql_JDBC_imple();
        connectDatabase.getConnection();//假装完成连接（由于多态的关系，这里是连接mysql的）
        connectDatabase.crud();//假装对mysql进行了一些增删改查的操作
        connectDatabase.close();//假装关闭了mysql的连接

        System.out.println("==================");

        connectDatabase = new Oracle_JDBC_imple();//现在把该对象更改成Oracle的实现接口
        connectDatabase.getConnection();//假装完成连接（由于多态的关系，这里是连接Oracle的）
        connectDatabase.crud();//假装对Oracle进行了一些增删改查的操作
        connectDatabase.close();//假装关闭了Oracle的连接

        //其他数据库以此类推


    }
}
