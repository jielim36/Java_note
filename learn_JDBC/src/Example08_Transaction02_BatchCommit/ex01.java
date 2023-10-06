package Example08_Transaction02_BatchCommit;

/*
批处理 基本介绍：
1.当需要批量插入或者更新记录时，可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理。
  通常情况下比单独提交处理更有效率。

2.JDBC批量处理华语剧包括下面方法：
  addBatch():添加需要批量处理的SQL语句或参数
  executeBatch();执行批量处理语句；
  clearBatch();清空批处理包的语句，当数据量较大时，需要多次的批量提交，比如每次提交100条数据，然后清空，再接着执行。
               类似于：巴士需要载送1000个学生去学校，每次“填充”100名学生进巴士,然后再送到学校“提交”，然后“清空”巴士，这个操作重复接送剩下的900名学生。

3.JDBC连接MySQL时，如果要使用批处理功能，请再url中加参数：?rewriteBatchedStatements=true
  例子：url=jdbc:mysql://localhost:3306/java_database?rewriteBatchedStatements=true

4.批处理往往和PreparedStatement一起搭配使用，可以同时减少编译次数，运行次数。效率大大提高.

 */

import Example06_Utils.JDBC_Utils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ex01 {

    /**
     * 测试不使用批量处理的情况下添加5000条记录需要多久
     *
     * 方法：对sql语句的占位符赋值完毕后原本是直接execute进行提交，但是批处理时变成了不要execute，而是调用 ps.addBatch();方法
     *       表示将该语句添加到批处理包中...
     *
     * 测试结果：执行5000条记录的花费时间为：2754毫秒，即2.754秒
     */
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBC_Utils.getConnection();

        String sql = "INSERT INTO testingTable VALUES (null,?,?)";//id,name,balance
        PreparedStatement ps = connection.prepareStatement(sql);

        System.out.println("开始时间：");
        long start = System.currentTimeMillis();//记录开始时间

        for (int i = 0; i < 5000 ; i++) {
            ps.setString(1,"jack"+i );
            ps.setInt(2,i*3);
            ps.executeUpdate();
        }

        JDBC_Utils.close(null,ps,connection);

        long end = System.currentTimeMillis();//记录结束时间
        System.out.println("执行时长：" + (end - start));//结束时间-开启时间 = 花费时间
    }

    /**
     * 测试使用批量处理5000条记录所花费的时间
     * 方法：对sql语句的占位符赋值完毕后原本是直接execute进行提交，但是批处理时变成了不要execute，
     *       而是调用 ps.addBatch();方法，表示将该语句添加到批处理包中...
     *       注意：需要在配置文件中更改url，添加?rewriteBatchedStatements=true
     *
     *  实验结果：添加5000条记录的花费时长 = 42毫秒
     */
    @Test
    public void Batch() throws SQLException {
        Connection connection = JDBC_Utils.getConnection();

        String sql = "INSERT INTO testingTable VALUES (null,?,?)";//id,name,balance
        PreparedStatement ps = connection.prepareStatement(sql);

        System.out.println("开始时间：");
        long start = System.currentTimeMillis();//记录开始时间

        int commitTimes = 0;//记录提交过多少次批处理包
        for (int i = 0; i < 5000 ; i++) {//提交5000条记录
            ps.setString(1,"jack"+i );
            ps.setInt(2,i*3);

            ps.addBatch();//将sql语句加入到批处理包中

            if ((i+1) % 1000 == 0){//每添加了1000条记录后就提交批处理包 （i+1的原因：因为i从0开始，4999就会结束循环，所以需要i+1）
                ps.executeBatch();//提交批处理包
                ps.clearBatch();//提交清理批处理包，然后再接着添加之后的数据
                commitTimes++;
            }
        }
        System.out.println("提交批处理包次数：" + commitTimes);

        JDBC_Utils.close(null,ps,connection);

        long end = System.currentTimeMillis();//记录结束时间
        System.out.println("执行时长：" + (end - start));//结束时间-开启时间 = 花费时间
    }
}

/*
addBatch 源码分析：

源码：
public void addBatch() throws SQLException {
        synchronized(this.checkClosed().getConnectionMutex()) {
            if (this.batchedArgs == null) {    //batchedArgs属性：protected List<Object> batchedArgs; 该属性是一个List
                this.batchedArgs = new ArrayList(); //当该List没有内容时创建一个ArrayList
            }

            for(int i = 0; i < this.parameterValues.length; ++i) {  //parameterValues是一个二维数组，每一个row都代表一个占位符，所以我们有两个占位符就表示二位数组长度为：[2][].比如我第一个占位符是jack,数组的row0上就几个column，里面对应着jack的ASCII编码，占位符2同理，int数据为0的整数变成了ASCII编码48
                this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);//这里不太懂：应该只是检查是否为null，顺便做一些预编译的操作
            }

            this.batchedArgs.add(new BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
        }
    }

batchedArgs ArrayList中存放着每一条SQL数据（注意：ArrayList初始元素大小为10，满了需要扩容时扩容1.5倍），一条SQL语句对应一个元素
每个元素内有两个重要的属性:
1.第一个是this$0,它存放了该元素的SQL语句，比如：INSERT INTO testingTable VALUES (null,'jack0',0)

2.第二个是parameterStrings二维数组,执行完上面的代码后，batchedArgs这个ArrayList就成功添加了一个元素(size=1),该ArrayList里的elementData中的parameterStrings二维数组里每个row存储了每个占位符的数据，一个row中的每个column对应一个字符，
  比如int整数0数值只有1个column，jack0字符串就有多个column。字符串大小/长度比如 jack0就是长度5，但是会有7个column，这是因为字符串的前后都有'符号，比如：'jack0'

然后我们添加了多个SQL语句后（自行决定，比如这个案例我们每1000条记录提交一次），可以使用executeBatch();方法提交。
批量处理会减少我们发送sql语句的网络开销，而且减少编译次数，因此效率提高。
批处理Batch和PreparedStatement搭配使用时，效率提高。因为原本需要执行五千次的SQL语句，通过批处理变成了每一千次提交一次，也就是只需要提交五次。
 */