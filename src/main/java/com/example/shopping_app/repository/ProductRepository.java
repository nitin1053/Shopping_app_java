package com.example.shopping_app.repository;

import com.example.shopping_app.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // You can add custom query methods here if needed
}