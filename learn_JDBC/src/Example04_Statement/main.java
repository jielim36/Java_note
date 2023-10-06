package Example04_Statement;
/*
Statement 基本介绍：
1.Statement对象 用于执行静态SQL语句并返回其生成的结果的对象
2.在建立连接后，需要对数据库进行访问，执行命名或是SQL语句，可以通过：
    -Statement  缺点：存在SQL注入问题，所以实际开发中不会使用Statement
    -PreparedStatement 预处理
    -CallableStatement  存储过程
3.Statement对象执行SQL语句，存在“SQL注入“风险
4.SQL注入：利用某些系统没有对用户输入的数据进行充分的检查，而在输入数据中注入了非法的SQL语句段或命令，恶意攻击数据库
5.要防范SQL注入，只要用PreparedStatement（从Statement扩展而来）取代Statement就可以了

SQL注入（Example04的ex01有案例）：
SELECT * FROM news
    WHERE `NAME` = 'x' and id = 'x'

假如上面的table是一个重要且隐私的table比如账号，上面的name和id的'x'都是要我们填入来寻找某个记录
此时用户打算卡bug来获取数据，
他对name输入 1' or
他对id 输入 or '1' = '1'
导致最后的语句变成了: WHERE `NAME` = '1' OR 'AND PWD = ' OR '1' = '1'
解析：变成了三个条件：
条件1：name = '1'
条件2：'AND id = '   (注意：原本这里要求写入id的因为他放了一个'符号变成了字符串)
条件3： '1' = '1'  (这个条件一定成立：true)
于是该用户可以获取到该table的所有数据

 */

public class main {
}
