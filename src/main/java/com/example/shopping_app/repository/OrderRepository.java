package com.example.shopping_app.repository;

import com.example.shopping_app.Model.Order; // Fully qualify the Order class
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUserId(int userId); // Use the fully qualified class name

    Optional<Order> findByUserIdAndOrderId(int userId, int orderId); // Use the fully qualified class name
}
