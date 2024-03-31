package com.example.shopping_app.Exception;

public class OrderAlreadyPaidException extends RuntimeException {

    public OrderAlreadyPaidException(String message) {
        super(message);
    }
}