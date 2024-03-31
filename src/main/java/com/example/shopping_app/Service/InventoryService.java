package com.example.shopping_app.Service;

import com.example.shopping_app.Configuration.ApplicationProperties;
import com.example.shopping_app.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private ApplicationProperties applicationProperties;

    public Product getProductDetails() {
        String productId = "1"; // Assuming there's only one product
        String productName = "Product Name"; // Replace with actual product name
        int productPrice = Integer.parseInt(applicationProperties.getProductPrice());
        int availableQuantity = Integer.parseInt(applicationProperties.getProductAvailableQuantity());

        return new Product(productId, productName, productPrice, availableQuantity);
    }
}
