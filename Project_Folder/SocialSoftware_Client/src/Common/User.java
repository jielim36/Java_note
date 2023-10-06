package Common;

import java.io.Serializable;

/**
 * @author jielim36
 * @version 1.0
 * 该类用于管理用户信息/客户信息
 * 1.实现Serializable的原因：由于我们的用户信息将来会在使用“对象流”网络上传输，所以我们需要实现该接口才能“串行化”，
 *
 *
 */
public class User implements Serializable { //序列化的类的包（Common）。服务器端和客户端都必须一样（包名+类名 -> Common , User）
    private static final long serialVersionUID = 1L; //用于增强兼容性，如果该类的有进行修改比如：字段field的类型。
                                            // 如果该类发生了变化后那么修改前序列化出来的对象在反序列化时就会失败
    private String userID;
    private String password;

    public User() {
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
