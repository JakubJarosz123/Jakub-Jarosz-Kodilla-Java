package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.List;

public interface FlightService {
    List<Flight> findFlightsFrom(String departure);
    List<Flight> findFlightsTo(String arrival);
    List<Flight> findFlightsVia(String via);
}
