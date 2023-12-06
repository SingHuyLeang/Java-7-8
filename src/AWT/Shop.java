package AWT;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private int id;
    private String name;
    private int qty;
    private double price;
    private double total;

    public Shop(int id, String name, int qty, double price, double total) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }

    static List<Shop> list = new ArrayList<>();
}
