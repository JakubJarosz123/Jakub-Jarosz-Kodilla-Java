package com.kodilla.kodillagoodpatterns.challenges;

public class SimpleOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product, int quantity) {
        System.out.println("Ordered: \n" + "Product: " + product.getProductName() + "\nAmount: " + quantity + "\nFor: " + user.getName());
        return true;
    }
}
