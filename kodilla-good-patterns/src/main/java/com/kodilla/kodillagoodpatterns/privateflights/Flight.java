package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.Objects;

public class Flight {
    private String departure;
    private String arrival;
    private String via;

    public Flight(String departure, String arrival, String via) {
        this.departure = departure;
        this.arrival = arrival;
        this.via = via;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getVia() {
        return via;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) && Objects.equals(arrival, flight.arrival) && Objects.equals(via, flight.via);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival, via);
    }

    @Override
    public String toString() {
        return "Flight: " +
                "departure= " + departure +
                ", arrival= " + arrival +
                ", via= " + via;
    }
}
