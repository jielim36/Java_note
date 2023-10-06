package Common;

import java.io.Serializable;

/**
 * @author jielim36
 * @version 1.0
 * 该类用于当作：客户端和服务器端通信时的消息对象
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sender;//发送方
    private String receiver;//接收方
    private String content;//内容
    private String sendTime;//发送时间
    private String messageType;//对消息的类型进行分类（发送信息，图片，视频等...）,可以在接口中定义已知的消息类型

    //对文件相关的属性进行扩展
    private byte[] fileByte;
    private int fileLen = 0;

    public byte[] getFileByte() {
        return fileByte;
    }

    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String dest;//文件传输到哪个目的地路径
    private String src;//源文件的路径

    public Message(String sender, String receiver, String content, String sendTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sendTime = sendTime;
    }
    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


}
