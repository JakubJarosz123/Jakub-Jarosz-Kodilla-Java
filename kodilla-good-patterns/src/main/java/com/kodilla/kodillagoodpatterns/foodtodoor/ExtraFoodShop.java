package com.kodilla.kodillagoodpatterns.foodtodoor;

public class ExtraFoodShop implements OrderInformation{
    @Override
    public String info() {
        return "Extra Food Shop specializes in fresh fruit and vegetables.";
    }

    @Override
    public Order process(String product, int quantity) {
        boolean success = Math.random() > 0.5;
        String message = "ExtraFoodShop has delivered " + quantity + " " + product + ".";
        return new Order(success, message);
    }
}
