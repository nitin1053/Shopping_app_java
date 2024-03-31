# Shopping App API

This project implements a RESTful API for a shopping application. The API provides endpoints for managing inventory, coupons, orders, and payments.

## Technologies Used

- Java
- Spring Boot
- MongoDB
- Postman (for testing)

## Setup

1. Clone the repository:


2. Navigate to the project directory:


3. Build and run the project using Maven:


4. The API will be available at `http://localhost:8080`.

## Endpoints

### 1. Inventory

- **GET /inventory**

    Retrieves the current inventory details.
    
    Example URL: `http://localhost:8080/inventory`
    
- **POST /inventory/order**

    Updates the inventory by placing an order for a certain quantity.
    
    Example URL: `http://localhost:8080/inventory/order`

### 2. Coupons

- **GET /coupons**

    Retrieves the available coupons along with their discount percentages.
    
    Example URL: `http://localhost:8080/coupons`

### 3. Orders

- **POST /orders/{userId}/order?qty=10&coupon=OFF5**

    Places a new order for the specified user with a given quantity and coupon code.
    
    Example URL: `http://localhost:8080/orders/{userId}/order?qty=10&coupon=OFF5`
    
- **POST /orders/{userId}/{orderId}/pay?amount=950**

    Makes a payment for the specified order and user with the given amount.
    
    Example URL: `http://localhost:8080/orders/{userId}/{orderId}/pay?amount=950`
    
- **GET /user-orders/{userId}**

    Retrieves all orders placed by the specified user.
    
    Example URL: `http://localhost:8080/user-orders/{userId}`
    
- **GET /user-orders/{userId}/{orderId}**

    Retrieves details of a specific order placed by the specified user.
    
    Example URL: `http://localhost:8080/user-orders/{userId}/{orderId}`

Thank you.

