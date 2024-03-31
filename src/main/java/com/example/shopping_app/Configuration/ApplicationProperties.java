package com.example.shopping_app.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String productPrice;
    private String productAvailableQuantity;

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAvailableQuantity() {
        return productAvailableQuantity;
    }

    public void setProductAvailableQuantity(String productAvailableQuantity) {
        this.productAvailableQuantity = productAvailableQuantity;
    }
}

