package Domain;

import java.util.Date;

/**
 * 该类针对了数据库中的Bill表，该表用于生成账单
 *
 * CREATE TABLE Bill(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	bill_id VARCHAR(50) NOT NULL default '', #账单号可以按照自己的规则生成UUID
 * 	menuId INT not null default 0,#菜品编号
 * 	nums int not null default 0,#菜品数量
 * 	money double not null default 0,#金额
 * 	diningTableId int not null default 0,#餐桌
 * 	billDate DATETIME not null ,#订单日期
 * 	state VARCHAR(50) not null default '' #状态： Cash,DuitNow,Bad Debt烂账
 * )charset=utf8
 */
public class Bill {

    private Integer id;
    private String bill_id;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billDate;
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String bill_id, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state) {
        this.id = id;
        this.bill_id = bill_id;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + menuId + "\t\t\t" + nums  + "\t\t\t"
                + money + "\t\t\t" + diningTableId + "\t\t" + billDate + "\t\t" + state;
    }
}
