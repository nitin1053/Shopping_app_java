package com.example.shopping_app.Service;

import com.example.shopping_app.Exception.InvalidCouponException;
import com.example.shopping_app.Exception.InvalidQuantityException;
import com.example.shopping_app.Exception.OrderNotFoundException;
import com.example.shopping_app.Model.Order;
import com.example.shopping_app.Model.Product;
import com.example.shopping_app.Model.User;
import com.example.shopping_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private UserService userService;

    public Order placeOrder(int userId, int quantity, String coupon) {
        Product product = inventoryService.getProductDetails();
        if (quantity < 1 || quantity > product.getAvailableQuantity()) {
            throw new InvalidQuantityException("Invalid quantity");
        }

        Map<String, Integer> availableCoupons = couponService.getCoupons(); // Assuming the method to get available coupons is named getCoupons()
        if (!availableCoupons.containsKey(coupon)) {
            throw new InvalidCouponException("Invalid coupon");
        }

        int price = product.getPrice();
        int discountPercentage = availableCoupons.get(coupon);
        int discountedPrice = price - (price * discountPercentage / 100);
        int amount = discountedPrice * quantity;

        Order order = new Order();
        User user = userService.getUserById(userId);
        order.setUser(user); // Assuming the setUser method exists in the Order class
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setAmount(amount);
        order.setCoupon(coupon);

        orderRepository.save(order);

        return order;
    }

    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(int userId, int orderId) {
        return (Order) orderRepository.findByUserIdAndOrderId(userId, orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }
}
