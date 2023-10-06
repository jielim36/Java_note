package Record;

import java.util.Objects;

/**
 用于对标 record类

 该类拥有：
 1.两个成员变量
 2.一个构造器
 3.equals和hashCode
 4. getter and setter method
 5. toString
 */
public class Original {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Original original = (Original) o;
        return id == original.id && Objects.equals(name, original.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Original(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Original{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
