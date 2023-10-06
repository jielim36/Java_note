package Domain;

/**
 * 该类对应了数据库中的diningTable表
 *
 * CREATE TABLE `diningTable` (
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	state VARCHAR(20) not null default '',
 * 	orderName VARCHAR(32) not null default '' , #预定人的名字
 * 	orderTel varchar(20) not null default '' #预定人的手机号
 * ) CHARSET=utf8;
 */
public class DiningTable {

    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderTel='" + orderTel + '\'' +
                '}';
    }
}
