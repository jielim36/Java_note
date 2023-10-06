package Client.view;

import Client.Service.UserClientService;
import Client.Utils.Utility;

/**
 * 客户端的界面
 */
public class View {

    private boolean loop = true; //控制是否显示菜单
    private String key = "";
    private UserClientService userClientService = new UserClientService();//该对象是用于登录/注册的服务

    public static void main(String[] args) {
        new View().mainMenu();
    }

    private void mainMenu(){ //主菜单

        while (loop){
            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t1.登录系统");
            System.out.println("\t\t9.退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key){
                case "1":
                    System.out.println("登录系统");
                    System.out.println("请输入用户ID:");
                    String userID = Utility.readString(50);
                    System.out.println("请输入密码:");
                    String userPassword = Utility.readString(50);
                    //这里就需要将用户输入的ID和密码传输给服务器来判断是否有这个账号
                    //...这里先省略传输服务器的代码

                    if (userClientService.checkUser(userID,userPassword)){ //调用该对象的checkUser方法，该方法会将ID和密码传给服务器进行核实信息
                        System.out.println("登录成功!");
                        HomePage(userID);//登入成功后进入主页
                    }else { //登录失败的话...
                        System.out.println("登录失败...");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false; //loop属性设置成false就不会再次循环了
                    break;
                default:
                    System.out.println("错误的选择...");

            }


        }
        System.out.println("hhh");
    }

    public void HomePage(String userID){ //该方法主要负责登入后的Home页面，里面有显示在线用户列表等功能

        while (loop){
            System.out.println("==========网络通信系统主页(用户："+userID+")==========");
            System.out.println("\t\t1.显示在线用户列表");
            System.out.println("\t\t2.群发消息");
            System.out.println("\t\t3.私聊消息");
            System.out.println("\t\t4.发送文件");
            System.out.println("\t\t5.发送离线消息");
            System.out.println("\t\t9.退出主页面");
            System.out.print("请输入你的选择:");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    userClientService.onlineFriendList();
                    break;
                case "2":
                    userClientService.GroupChat();
                    break;
                case "3":
                    userClientService.PM();
                    break;
                case "4":
                    userClientService.sendFile();
                    break;
                case "5":
                    userClientService.offlineMessage();
                    break;
                case "9":
                    System.out.println("退出主页");
                    //由于直接退出客户端时main线程退出了，但是还有其他线程还在运行，所以我们需要想办法将这个客户端的线程和与该客户端连接的服务器端线程都关闭
                    //调用方法，给服务器端发送一个退出系统的message
                    userClientService.logOut();
                    loop = false;

                    break;
                default:
                    System.out.println("输入了无效的选择...");
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
