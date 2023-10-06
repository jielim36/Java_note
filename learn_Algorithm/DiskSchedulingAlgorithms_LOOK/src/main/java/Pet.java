public class Pet {

    private String name;
    private Double price;
    private int Stock;

    public Pet(String name, Double price, int stock) {
        this.name = name;
        this.price = price;
        Stock = stock;
    }

    public Pet(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return (this.getName()+"(RM "+getPrice()+")    Stock:"+this.getStock());
    }
}
