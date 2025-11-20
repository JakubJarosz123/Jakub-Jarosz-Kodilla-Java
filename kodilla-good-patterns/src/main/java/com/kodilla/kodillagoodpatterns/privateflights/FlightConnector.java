package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightConnector implements FlightRepository {

    private Set<Flight> flights = new HashSet<>();

    @Override
    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    @Override
    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    @Override
    public List<Flight> showFlights() {
        return new ArrayList<>(flights);
    }
}
