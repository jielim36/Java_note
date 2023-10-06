package Service;

import DAO.BillDAO;
import DAO.BillDetailsDAO;
import Domain.Bill;
import Domain.BillDetails;

import java.util.List;
import java.util.UUID;

public class BillService {

    private BillDAO billDAO = new BillDAO();
    private CarteService carteService = new CarteService();//由于生成账单需要获取菜品的信息，所以需要借助该对象来调用相应的方法获取菜品信息
    private DiningTableService diningTableService = new DiningTableService();//因为需要修改餐桌状态，所以需要依赖该对象
    private BillDetailsDAO billDetailsDAO = new BillDetailsDAO();//生成账单时如果需要使用多表查询显示具体菜品名称

    //注意：该账单的计算方式是每一个账单表示一个菜品被哪个餐桌点了，而不是一个餐桌点的所有菜品
    //一旦顾客点餐成功后，需要生成一个账单
    //编写点餐的方法
    //1. 生成账单
    //2. 需要更新餐桌的状态
    //返回boolean值表示是否成功生成账单
    public boolean order(int menuId,int nums , int TableId , double price){
        //生成一个账单号, UUID
        String bill_id = UUID.randomUUID().toString();//该方法会随机生成一个UUID

        //将这个账单生成到我们的Bill表

        int update = billDAO.update("insert into bill values (null,?,?,?,?,?,now(), 'Unpaid')"
                , bill_id, menuId, nums, price * nums, TableId);

        //接下来要更改餐桌的状态，但是更改前需要确保账单生成成功/点餐成功，成功后才真正的修改状态
        if (update < 0){ //判断是否生成账单成功，如果失败就直接return回去
            return false;
        }

        //该方法会更改餐桌状态，然后返回boolean值，true表示受影响的行数>0
        return diningTableService.updateTableState("Dining" , TableId);
    }

    public List<Bill> getBillList(){
        return billDAO.queryMulti(Bill.class , "select * from bill");
    }

    public List<BillDetails> getBillDetailsList(){
        return billDetailsDAO.queryMulti(BillDetails.class,"select Bill.* , name , price from Bill,carte where menuId = carte.id");
    }

    //获取未付款的餐桌
    public List<Bill> getUnpaidBill(){
        return billDAO.queryMulti(Bill.class,"select * from bill where state = 'Unpaid' ");
    }


    /**
     * 结账代码分析：
     * 1. 选择要结账的餐桌（确认该餐桌是否在Dining或Ordered的状态才能买单）
     * 2. 选择结账方式（确保选择的号码在范围内）
     * 3. 确认结账(Y/N)
     * 4.结账后需要把DiningTable餐桌的状态更改为Empty,并且把orderName和orderTel更改成空值 ''
     * 5.结账后需要把Bill账单的State状态更改成对应的付款方式
     */
    //该方法用于结账
    public void payBill( int tableId , String payType){
        //修改Bill表的state，把Unpaid更改成对应的付款方式表示已结账
        int updateBill = billDAO.update("update bill set state = ? where diningTableId = ? AND state = 'Unpaid'", payType, tableId);

        if (updateBill <= 0){
            System.out.println("结账失败!");
            return;
        }
        //确认结账成功后才开始更改Table的状态
        //修改DiningTable的状态，把Dining或者Ordered状态的餐桌更改成Empty
        boolean updateTableState = diningTableService.updateTableState("Empty", tableId , "" , "");

        if (updateTableState){
            System.out.println("结账成功，共结了" + updateBill + "个单");//由于我们的账单是每一个菜品一个账单，所以会统计共结账了多少个菜品
        }else {
            System.out.println("结账失败...");
        }

    }

}
