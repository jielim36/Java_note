package Example13_ApDBUtils;

/**
 * 该类用于接收Actor表的返回
 */
public class Actor{

    private Integer id;
    private String name;
    private String gender;
    private String bornDate;//java.util包下的Date类
    private String phone;

    public Actor(){ //一定要给一个无参构造器，因为底层可能会使用到映射/反射
    }

    public Actor(Integer id, String name, String gender, String bornDate, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bornDate = bornDate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nNews{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", bornDate=" + bornDate +
                ", phone='" + phone + '\'' +
                '}';
    }

}

