package com.kodilla.kodillagoodpatterns.foodtodoor;

public class GlutenFreeShop implements OrderInformation{
    @Override
    public String info() {
        return "GlutenFreeShop: products without gluten.";
    }

    @Override
    public Order process(String product, int quantity) {
        boolean success = false;
        String message = "GlutenFreeShop has delivered " + quantity + " " + product + ".";
        return new Order(success, message);
    }
}
