package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.Set;

public interface FlightPlanner {
    boolean addFlight(Flights flights);
    boolean removeFlight(Flights flights);
    Set<Flights> showAllFlights();
}
