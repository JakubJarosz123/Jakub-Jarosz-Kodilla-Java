package com.kodilla.kodillagoodpatterns.foodtodoor;

public interface OrderInformation {
    String info();
    Order process(String product, int quantity);
}
