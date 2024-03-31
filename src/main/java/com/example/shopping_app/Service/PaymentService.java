package com.example.shopping_app.Service;

import com.example.shopping_app.Exception.PaymentFailedException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public String makePayment(int userId, int orderId, int amount) {
        // Simulate random success or failure
        boolean paymentSuccess = simulatePaymentSuccess();

        if (paymentSuccess) {
            String transactionId = generateTransactionId();
            return transactionId;
        } else {
            throw new PaymentFailedException("Payment failed");
        }
    }

    // Simulate payment success or failure
    private boolean simulatePaymentSuccess() {
        // Simulate 90% success rate
        return new Random().nextInt(10) != 0;
    }

    // Generate a random transaction ID
    private String generateTransactionId() {
        // Generate a random alphanumeric transaction ID
        StringBuilder transactionIdBuilder = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 12; i++) {
            transactionIdBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return transactionIdBuilder.toString();
    }
}

