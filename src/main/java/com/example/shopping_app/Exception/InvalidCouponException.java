package com.example.shopping_app.Exception;

public class InvalidCouponException extends RuntimeException {

    public InvalidCouponException(String message) {
        super(message);
    }
}
