package Client.Service;

import Common.Message;
import Common.MessageType;

import java.io.*;

public class clientFileService {


    /**
     * 该方法用于传文件给另一个用户
     * @param src 源文件的路径
     * @param dest 传文件到对方的哪个路径
     * @param sender 发送方的userID
     * @param receiver 接收方的userID
     */
    public void sendFileToOne(String src , String dest , String sender , String receiver){

        //读取src文件 -> 封装到messsage对象
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件进行处理(从电脑读取文件数据到该java程序中)
        File file = null;
        FileInputStream fis = null;
        try {
            file = new File(src);

            //判断该文件是否真的存在
            if (file.exists()){//如果src路径下确实有这个文件
                fis = new FileInputStream(src);
                byte[] fileByte = new byte[(int)file.length()];

                fis.read(fileByte);

                //将文件对应的字节数组设置message
                message.setFileByte(fileByte);

            }else {
                System.out.println("路径错误...无法找到该文件!");
                return;//直接返回
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("\n\n");//先空行（美观）
        System.out.println(sender+" 发送文件给 "+receiver+"...\n发送文件路径："+src +"到对方的"+dest +"路径");

        //发送
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
