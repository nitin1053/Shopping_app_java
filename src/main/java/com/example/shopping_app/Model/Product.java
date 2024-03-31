package com.example.shopping_app.Model;
public class Product {
    private String productId;
    private String name;
    private int price;
    private int availableQuantity;

    public Product() {
    }

    public Product(String productId, String name, int price, int availableQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}