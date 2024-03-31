package com.example.shopping_app.Service;

import com.example.shopping_app.Exception.OrderNotFoundException;
import com.example.shopping_app.Model.Order;
import com.example.shopping_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserOrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<com.example.shopping_app.Model.Order> getUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderDetails(int userId, int orderId) {
        return (Order) orderRepository.findByUserIdAndOrderId(userId, orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }
}
