package Domain;

/**
 * 该类是对应了数据库中的carte表，该表是一个菜单，供顾客点餐
 *
 * CREATE TABLE carte(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	`name` VARCHAR(50) NOT NULL default '',
 * 	type VARCHAR(50) NOT NULL default '',
 * 	price DOUBLE NOT NULL default 0
 * )charset=utf8
 */
public class Carte {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    public Carte() {
    }

    public Carte(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + type + "\t\t" + price;
    }
}
