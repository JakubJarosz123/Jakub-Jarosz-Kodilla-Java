package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.HashSet;
import java.util.Set;

public class InMemoryFlightPlanner implements FlightPlanner {
    private final Set<Flights> flights = new HashSet<>();

    @Override
    public boolean addFlight(Flights flights) {
        return this.flights.add(flights);
    }

    @Override
    public boolean removeFlight(Flights flights) {
        return this.flights.remove(flights);
    }

    @Override
    public Set<Flights> showAllFlights() {
        return this.flights;
    }
}
