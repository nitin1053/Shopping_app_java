package com.example.shopping_app.Controller;

import com.example.shopping_app.Exception.OrderNotFoundException;
import com.example.shopping_app.Model.Order; // Correct import statement for Order class
import com.example.shopping_app.Service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-orders")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable int userId) {
        List<Order> userOrders = userOrderService.getUserOrders(userId);
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int userId, @PathVariable int orderId) {
        try {
            Order order = userOrderService.getOrderDetails(userId, orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
