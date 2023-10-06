package Service;

import DAO.DiningTableDAO;
import Domain.DiningTable;

import java.util.List;

public class DiningTableService {

    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回全部餐桌的id和状态
    public List<DiningTable> getDiningTable(){
        return diningTableDAO.queryMulti(DiningTable.class,"select id,state from diningtable");
    }

    //通过id查询餐桌的信息
    public DiningTable getDiningTableByID(int id){
        return diningTableDAO.querySingle(DiningTable.class , "select * from diningtable where id = ?" , id);
    }

    //如果餐桌为空，可以预定。那么调用该方法对该餐桌的状态等信息进行修改
    //返回boolean值是让调用者可以通过该值判断是否预定成功
    public boolean orderDiningTable( int id,String orderName,String tel ){
        int affectedRow = diningTableDAO.update("update diningtable set state = 'Ordered',orderName=?,orderTel=? where id=?", orderName, tel, id);
        return affectedRow > 0;//当受影响的行数大于0，表示修改成功，所以会返回true
    }

    //该方法主要是更新餐桌的状态
    public boolean updateTableState(String state , int tableId){
        int update = diningTableDAO.update("update diningtable set state = ? where id = ?", state, tableId);
        return update > 0;
    }
    //重载方法，该方法多出了可以修改orderName和orderTel的功能
    public boolean updateTableState(String state , int tableId , String orderName , String orderTel){
        int update = diningTableDAO.update("update diningtable set state = ? , orderName = ? , orderTel = ? where id = ?", state , orderName , orderTel , tableId);
        return update > 0;
    }
}
