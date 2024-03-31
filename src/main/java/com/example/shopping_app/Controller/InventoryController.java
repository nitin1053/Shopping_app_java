package com.example.shopping_app.Controller;

import com.example.shopping_app.Model.Product;
import com.example.shopping_app.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Product> getInventory() {
        Product product = inventoryService.getProductDetails();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
