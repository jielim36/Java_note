package View;

import Domain.*;
import Service.BillService;
import Service.CarteService;
import Service.DiningTableService;
import Service.EmployeeService;
import Utility.Input_Utils;

import java.util.ArrayList;
import java.util.List;

public class MHLview {

    private boolean loopMenu = true;//控制是否退出菜单，默认为true表示默认死循环
    private String key = "";//接收用户的选择


    //定义每个Service类的对象，方便调用其方法
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private CarteService carteService = new CarteService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLview().mainMenu();
    }

    public void mainMenu(){
        String empId;
        String empPass;

        while(loopMenu){

            System.out.println("==========满汉楼==========");
            System.out.println("\t\t 1.登录满汉楼\n\t\t 2.退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Input_Utils.readString(1);//最多一个字符
            switch (key){
                case "1" :
                    System.out.println("==登录满汉楼==");
                    System.out.print("输入员工号: ");
                    empId = Input_Utils.readString(32);
                    System.out.print("输入密  码: ");
                    empPass = Input_Utils.readString(32);
                    //使用getEmployeeUser方法验证并返回一个Employee类对象
                    Employee employee = employeeService.getEmployeeUser(empId, empPass);
                    if(employee == null ){//当id和密码在数据库查询时没有匹配的记录，数据库会返回null,可以通过null来判断成登入失败
                        System.out.println("登录失败...");
                    }else {
                        System.out.println("登录成功[ "+ employee.getName() +" ]");
                        secondMenu();
                    }

                    break;
                case "2" :
                    System.out.println("退出满汉楼");
                    loopMenu = false;
                    break;
                default:
                    System.out.println("无效的选择...");
            }
        }
    }

    public void secondMenu(){
        while(loopMenu){

            System.out.println("==========满汉楼主页==========");
            System.out.println("\t\t 1.显示餐桌状态");
            System.out.println("\t\t 2.预定餐桌");
            System.out.println("\t\t 3.显示所有的菜品");
            System.out.println("\t\t 4.点餐服务");
            System.out.println("\t\t 5.查看账单");
            System.out.println("\t\t 6.结账");
            System.out.println("\t\t 9.退出满汉楼");
            System.out.print("请输入选择: ");
            key = Input_Utils.readString(1);

            switch (key){
                case "1" : //显示所有餐桌
                    System.out.println("\n====显示餐桌状态====");
                    showDiningTableState();
                    break;

                case "2" : //预定餐桌
                    orderDiningTable();
                    break;

                case "3" : //显示菜单
                    showCarte();
                    break;

                case "4" : //点餐
                    orderFood();
                    break;

                case "5" :
//                    showBillList();
                    showBillDetails();
                    break;

                case "6" :
                    payBill();
                    break;


                case "9" :
                    System.out.println("退出满汉楼");
                    loopMenu = false;
                    break;

            }
        }
    }

    //该方法负责显示所有餐桌的ID和状态
    public void showDiningTableState(){
        List<DiningTable> tableList = diningTableService.getDiningTable();//getDiningTable会向数据库查询所有餐桌并且返回一个list，所以用list接收
        System.out.println("餐桌号\t 状态");
        for (DiningTable diningTable : tableList) {
            System.out.println("  "+diningTable.getId() + "\t\t" + diningTable.getState());
        }
    }

    public void orderDiningTable(){
        System.out.println("=====预定餐桌=====");
        showDiningTableState();//显示给用户当前的餐桌状态
        System.out.print("请选择餐桌(-1取消预定):");
        int orderID = Input_Utils.readInt();
        if (orderID==-1){
            System.out.println("取消预定餐桌...");
            return;
        }

        System.out.print("确定预定餐桌？(Y/N): ");
        char option = Input_Utils.readConfirmSelection();
        if (option != 'Y'){
            System.out.println("取消预定餐桌...");
            return;
        }

        //开始验证输入的餐桌是否为空或者已被预定
        //验证前需要通过用户输入的id查询对应的餐桌对象来获取信息
        DiningTable diningTable = diningTableService.getDiningTableByID(orderID);
        if (diningTable == null){
            System.out.println("该餐桌不存在");
            return;
        }

        if (!(diningTable.getState().equals("Empty"))){ //如果餐桌不为空表示已被预定，直接return返回
            System.out.println("该餐桌已被预定...");
            return;
        }

        //确定了该餐桌是可以被预定的时候，才需要用户输入名字和手机号
        System.out.print("请输入名字:");
        String orderName = Input_Utils.readString(32);
        System.out.print("请输入手机号:");
        String orderTel = Input_Utils.readString(20);

        if(diningTableService.orderDiningTable(orderID,orderName,orderTel)) {  //调用方法更新餐桌的状态，并且返回一个boolean值
            System.out.println("预定成功!");

        }else {
            System.out.println("预定失败...");
        }
    }

    //该方法用于显示所有菜品
    public void showCarte(){
        System.out.println("===========显示所有的菜品==========");
        List<Carte> list = carteService.getCarte();
        System.out.println("ID\tName\tType\tPrice");
        for (Carte carte : list) {
            System.out.println(carte);
        }
    }

    /**
     * 该方法用于顾客点餐，然后将所有的点餐信息传给BillService类处理后生成账单
     * 点餐服务的问题分析：
     * 1. 点餐时会选择为餐桌(必须要是已被预定的餐桌)
     * 2. 选择菜品编号(需要验证该编号是否存在)
     * 3. 选择数量
     * 4. 成功点餐后，需要更新餐桌的状态（从Ordered变成 Dining 就餐中）
     * 5. 点餐成功后，需要生成一个对应的账单
     */
    //该方法用于点菜
    public void orderFood(){
        System.out.println("==========点菜服务========");
        showDiningTableState();//显示所有餐桌状态
        System.out.print("请输入点菜的桌号(-1退出): ");
        int tableId = Input_Utils.readInt();
        if (tableId == -1){ //输入-1退出
            return;
        }
        //验证餐桌状态是否可以点餐
        DiningTable diningTable = diningTableService.getDiningTableByID(tableId);
        if (diningTable == null){
            System.out.println("该餐桌不存在");
            return;
        }
        if (diningTable.getState().equals("Ordered") && diningTable.getState().equals("Dining")){ //只有已预定和就餐中的餐桌状态才能点餐
            System.out.println("该餐桌未预定...无法点餐!");
            return;
        }

        System.out.println("======菜单=====");
        System.out.println("ID\tName\tType\tPrice");
        showCarte();//显示所有菜品
        System.out.print("请输入菜品的编号(-1退出): ");
        int foodId = Input_Utils.readInt();
        if (foodId == -1){
            return;
        }
        Carte food = carteService.getFoodById(foodId);//单独创建一个对象，之后要获取菜品的价格传给BillService
        if (food == null){ //验证该菜品id是否存在
            System.out.println("没有这个菜品...");
            return;
        }
        System.out.print("请输入数量(-1退出): ");
        int nums = Input_Utils.readInt();
        if (nums == -1){
            return;
        }

        //所有验证都完成了，可以点餐了
        if (billService.order(foodId,nums,tableId,food.getPrice())){
            System.out.println("点餐成功!");
        }else {
            System.out.println("点餐失败!");
        }
    }

    public void showBillList(){
        System.out.println("==========查看账单==========");
        List<Bill> billList = billService.getBillList();
        System.out.println("ID | \tMenu ID | \tQuantity | \tTotal Money | \tTable ID | \t\t\tDate\t\t\t | \tState");
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }
    public void showBillDetails(){
        System.out.println("==========账单详细========");
        List<BillDetails> billDetailsList = billService.getBillDetailsList();
        System.out.println("ID | \tMenu ID | \tQuantity | \tTotal Money | \tTable ID | \t\t\tDate\t\t\t | \tState\t| Food Name\t| Per Price");

        for (BillDetails billDetails : billDetailsList) {
            System.out.println(billDetails);
        }
    }

    /**
     * 结账代码分析：
     * 1. 选择要结账的餐桌（确认该餐桌是否在Dining或Ordered的状态才能买单）
     * 2. 选择结账方式（确保选择的号码在范围内）
     * 3. 确认结账(Y/N)
     * 4.结账后需要把DiningTable餐桌的状态更改为Empty,并且把orderName和orderTel更改成空值 ''
     * 5.结账后需要把Bill账单的State状态更改成对应的付款方式
     */
    public void payBill(){
        System.out.println("==========结账服务==========");
        System.out.println("===未结账的餐桌===");
        List<Bill> unpaidBillList = billService.getUnpaidBill();
        System.out.println("ID | \tMenu ID | \tQuantity | \tTotal Money | \tTable ID | \t\t\tDate\t\t\t | \tState");
        for (Bill bill : unpaidBillList) {
            System.out.println(bill);
        }

        System.out.print("\n请选择要结账的餐桌编号(-1退出):");
        int tableID = Input_Utils.readInt();
        if (tableID == -1){
            System.out.println("取消结账...");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableByID(tableID);
        if (!(diningTable.getState().equals("Dining") || diningTable.getState().equals("Ordered"))){
            System.out.println("该餐桌无人使用...无法付款!");
            return;
        }
        System.out.println("选择付款方式\n1.Cash\t2.TnG");
        System.out.print("请输入付款选择(-1退出): ");
        int choose = Input_Utils.readInt();
        if (choose == -1){
            System.out.println("取消付款");
            return;
        }
        if (choose != 1 && choose != 2){
            System.out.println("无效的付款方式...");
        }
        String payType;
        if (choose == 1){
            payType = "Cash";
        }else{
            payType = "TnG";
        }

        System.out.print("确定是否结账(Y/N): ");
        char option = Input_Utils.readConfirmSelection();
        if (option == 'Y'){
            billService.payBill(tableID , payType);
        }
    }
}
