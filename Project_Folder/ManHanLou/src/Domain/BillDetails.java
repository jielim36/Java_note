package Domain;

import java.util.Date;

/**
 * 该表是一个Bill和Carte的组合表，目的是为了在显示账单时原本只能看到食物的编号变成可以看到食物的对应名称
 * 也就是查询的时候会以多表查询Bill和Carte两张表，并且通过这个BillDetails进行接收
 */

public class BillDetails {

    //这些属性是Bill类原有的属性
    private Integer id;
    private String bill_id;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billDate;
    private String state;
    //这些是新增的属性
    private String name;//菜品的名字 (提示：如果多表查询两个表有一样的列名，可以在查询语句时通过as创建一个别名，然后这里的属性使用那个别名)
    private Double price;//菜品的单价

    public BillDetails() {
    }

    public BillDetails(Integer id, String bill_id, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state, String name, Double price) {
        this.id = id;
        this.bill_id = bill_id;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                + money + "\t\t\t" + diningTableId + "\t\t" + billDate + "\t\t" + state + "\t\t" + name + "\t" + price;
    }
}
