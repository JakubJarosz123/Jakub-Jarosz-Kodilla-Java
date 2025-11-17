package com.kodilla.kodillagoodpatterns.challenges;

public class SystemOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Product product, int quantity) {
        System.out.println("\nOrder created in database: " + quantity + " x " + product.getProductName() + " for " + user.getName());
    }
}
