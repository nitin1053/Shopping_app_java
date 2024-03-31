package com.example.shopping_app.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Coupon {

    @Id
    private String id;
    private String name;
    private int discountPercentage;
    private String code;
    // Constructor, getters, and setters
    public Coupon() {}

    public Coupon(String name, int discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
