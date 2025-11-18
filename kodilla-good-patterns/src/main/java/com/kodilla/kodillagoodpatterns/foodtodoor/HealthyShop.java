package com.kodilla.kodillagoodpatterns.foodtodoor;

public class HealthyShop implements OrderInformation {
    @Override
    public String info() {
        return "Healthy Shop: healthy products and great foods.";
    }
    @Override
    public Order process(String product, int quantity) {
        boolean success = true;
        String message = "Healthy Shop has delivered " + quantity + " " + product + ".";
        return new Order(success, message);
    }
}
