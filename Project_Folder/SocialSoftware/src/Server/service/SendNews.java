package Server.service;

import Common.Message;
import Common.MessageType;
import Utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

/**
 * 该类是为了实现推送新闻，把新闻发给每一个在线用户
 * 该类有一个独立线程
 */
public class SendNews implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("请输入服务器要推送的新闻[输入!exit退出推送新闻模式]:");
            String NewsContent = Utility.readString(150);
            if (NewsContent.equals("!exit")){
                break;
            }
            //构建一个消息，群发消息
            Message message = new Message();
            message.setSender("服务器");//设置发送消息者为 服务器， 接收者receiver不需要写，因为要给全部人看
            message.setContent(NewsContent);
            message.setSendTime(new Date().toString());
            message.setMessageType(MessageType.MESSAGE_NEWS_MES);

            System.out.println("\n服务器推送新闻给所有用户：");//这个是给服务器控制面板看的
            System.out.println(NewsContent);

            //遍历每一个客户端线程发送消息
            Set<String> clientName = ManageClientThread.getServerThreadHashMap().keySet();
            for (String name : clientName){
                ServerConnectClientThread serverConnectClientThread = ManageClientThread.getServerThreadHashMap().get(name);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        System.out.println("已退出推送模式...");
    }
}
