package Domain;

/**
 * 该类是一个对应了数据库中的employee表的类
 *
 * 数据库的 employee表：
 * CREATE TABLE employee(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	empId VARCHAR(32) UNIQUE NOT NULL default '',
 * 	`name` VARCHAR(32) NOT NULL DEFAULT '',
 * 	empPass VARCHAR(32) NOT NULL DEFAULT '',
 * 	job VARCHAR(32) NOT NULL DEFAULT ''
 * ) CHARSET=utf8
 */
public class Employee {

    private Integer id;
    private String empId;
    private String name;
    private String empPass;
    private String job;

    public Employee(){ //必须要有无参构造器，因为apache-DBUtils会使用反射机制，反射机制需要无参构造器

    }

    public Employee(Integer id, String empId, String name, String empPass, String job) {
        this.id = id;
        this.empId = empId;
        this.name = name;
        this.empPass = empPass;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpPass() {
        return empPass;
    }

    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
