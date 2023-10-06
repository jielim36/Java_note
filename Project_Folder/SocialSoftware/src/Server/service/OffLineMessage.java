package Server.service;

import Common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static Server.service.softwareServer.OfflineUserMessage;

public class OffLineMessage implements Runnable {
    private String userID;


    public OffLineMessage(String userID){
        this.userID = userID;
    }

    @Override
    public void run() {
        Socket socket = new Socket();
        ArrayList<Message> getOfflineMessage = OfflineUserMessage.get(userID);//通过自己的userID找到对应的离线信息库
        if (getOfflineMessage.size() >0){
            Message OfflineMessage = getOfflineMessage.get(0);//获取ArrayList索引位置所处的Message对象
            ObjectOutputStream oos2 = null;
            try {
                oos2 = new ObjectOutputStream(socket.getOutputStream());
                oos2.writeObject(OfflineMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (oos2 != null){
                        oos2.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
