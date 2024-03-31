package com.example.shopping_app.Model;
public class Order {
    private String orderId;
    private int userId;
    private Product product;
    private int quantity;
    private int amount;
    private String coupon;
    private User user;
    public Order() {
    }

    public Order(String orderId, int userId, Product product, int quantity, int amount, String coupon,User user) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.coupon = coupon;
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}