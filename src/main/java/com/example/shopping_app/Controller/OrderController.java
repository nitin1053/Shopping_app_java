package com.example.shopping_app.Controller;

import com.example.shopping_app.Exception.InvalidCouponException;
import com.example.shopping_app.Exception.InvalidQuantityException;
import com.example.shopping_app.Exception.OrderNotFoundException;
import com.example.shopping_app.Model.Order;
import com.example.shopping_app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable int userId, @RequestParam int qty, @RequestParam String coupon) {
        try {
            Order order = orderService.placeOrder(userId, qty, coupon);
            return ResponseEntity.ok(order); // Return the created order with OK status
        } catch (InvalidQuantityException | InvalidCouponException e) {
            return ResponseEntity.notFound().build(); // Return NOT FOUND status if there's an error
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable int userId) {
        List<Order> orders = orderService.getUserOrders(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable int userId, @PathVariable int orderId) {
        try {
            Order order = orderService.getOrderById(userId, orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
