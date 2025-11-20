package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.List;

public interface FlightRepository {
    boolean addFlight(Flight flight);
    boolean removeFlight(Flight flight);
    List<Flight> showFlights();
}
