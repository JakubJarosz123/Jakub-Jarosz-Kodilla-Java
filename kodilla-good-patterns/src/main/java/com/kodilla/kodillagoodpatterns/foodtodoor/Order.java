package com.kodilla.kodillagoodpatterns.foodtodoor;

public class Order {
    private boolean success;
    private String message;

    public Order(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
