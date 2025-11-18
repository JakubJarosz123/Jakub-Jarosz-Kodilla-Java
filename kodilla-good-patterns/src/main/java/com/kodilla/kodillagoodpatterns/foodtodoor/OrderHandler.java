package com.kodilla.kodillagoodpatterns.foodtodoor;

public class OrderHandler {
    public void placeOrder(OrderInformation orderInformation, String product, int quantity) {
        System.out.println(orderInformation.info());
        Order order = orderInformation.process(product, quantity);
        if (order.isSuccess()) {
            System.out.println("Order placed successfully: " + order.getMessage());
        } else {
            System.out.println("Order failed: " + order.getMessage());
        }
    }
}
