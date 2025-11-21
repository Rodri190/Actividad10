package com.cellstore.model;

/**
 * Modelo simple para un celular.
 */
public class CellPhone {
    private final String id;
    private final String brand;
    private final String model;
    private final double price;
    private int stock;

    public CellPhone(String id, String brand, String model, double price, int stock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }

    public int getStock() { return stock; }
    public void setStock(int s) { this.stock = s; }
    public void decrementStock(int qty) { this.stock -= qty; }

    @Override
    public String toString() {
        return String.format("%s | %s %s | $%.2f | stock=%d", id, brand, model, price, stock);
    }
}
