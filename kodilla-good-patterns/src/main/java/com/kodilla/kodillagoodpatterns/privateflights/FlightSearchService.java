package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.List;

public interface FlightSearchService {
    List<Flights> searchFlightsFrom(String city);
    List<Flights> searchFlightsTo(String city);
    List<Connection> findConnectingFlights(String from, String to);
}
