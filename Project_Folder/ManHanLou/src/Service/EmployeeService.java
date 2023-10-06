package Service;

import DAO.EmployeeDAO;
import Domain.Employee;

/**
 * 该类完成对employee表的各种操作（通过调用EmployeeDAO对象完成）
 */
public class EmployeeService {

    //定义一个EmployeeDAO对象，通过这个对象调用该类的方法
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法：根据empId和empPass返回一个Employee对象(有很多个员工，每个员工都有自己的账号信息，所以输入对应的id密码返回对应的员工用户)
    public Employee getEmployeeUser(String empId,String empPass){
        return employeeDAO.querySingle(Employee.class , "select * from employee where empId = ? and empPass = md5(?)",empId,empPass);
        //md5是密码加密，数据库的用户密码已经经过md5加密，所以我们匹配密码时也需要跟着使用md5，如果不使用md5是找不到的
        //如果id和pass不匹配任何一条记录，表示id或密码不正确，这时数据库找不到记录就会返回null。
    }

}
