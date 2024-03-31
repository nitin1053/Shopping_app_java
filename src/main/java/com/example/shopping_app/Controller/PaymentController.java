package com.example.shopping_app.Controller;

import com.example.shopping_app.Exception.InvalidOrderException;
import com.example.shopping_app.Exception.OrderAlreadyPaidException;
import com.example.shopping_app.Exception.PaymentFailedException;
import com.example.shopping_app.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{userId}/{orderId}")
    public ResponseEntity<String> makePayment(@PathVariable int userId, @PathVariable int orderId, @RequestParam int amount) {
        try {
            String transactionId = paymentService.makePayment(userId, orderId, amount);
            return new ResponseEntity<>(transactionId, HttpStatus.OK);
        } catch (PaymentFailedException | InvalidOrderException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (OrderAlreadyPaidException e) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}

