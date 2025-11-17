package com.kodilla.kodillagoodpatterns.challenges;

public interface OrderRepository {
    void createOrder(User user, Product product, int quantity);
}
