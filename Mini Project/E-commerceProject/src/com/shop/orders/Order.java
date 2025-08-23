package com.shop.orders;

import com.shop.products.Product;
import com.shop.users.User;

public class Order {
    private String orderId;
    private User user;
    private Product product;

    public Order(String orderId, User user, Product product) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + user.getName());
        System.out.println("Product: " + product.getName() + " - $" + product.getPrice());
    }
}
