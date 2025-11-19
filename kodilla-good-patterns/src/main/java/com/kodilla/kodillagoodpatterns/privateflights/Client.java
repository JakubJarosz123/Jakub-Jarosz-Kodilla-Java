package com.kodilla.kodillagoodpatterns.privateflights;

public class Client {
    private String name;
    private String email;
    private Flights flights;

    public Client(String name, String email, Flights flights) {
        this.name = name;
        this.email = email;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Flights getFlights() {
        return flights;
    }
}
