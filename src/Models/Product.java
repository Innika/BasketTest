package Models;

public class Product {
    public String name = "";
    public Double price = 0.00;

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

}