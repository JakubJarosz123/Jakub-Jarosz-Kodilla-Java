package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlightSearchService implements FlightSearchService {
    private final FlightPlanner flightPlanner;

    public StreamFlightSearchService(FlightPlanner flightPlanner) {
        this.flightPlanner = flightPlanner;
    }

    @Override
    public List<Flights> searchFlightsFrom(String city) {
        return flightPlanner.showAllFlights().stream()
                .filter(f -> f.getFrom().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flights> searchFlightsTo(String city) {
        return flightPlanner.showAllFlights().stream()
                .filter(f -> f.getTo().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Connection> findConnectingFlights(String from, String to) {
        Set<Flights> allFlights = flightPlanner.showAllFlights();

        List<Flights> start = allFlights.stream()
                .filter(f -> f.getFrom().equalsIgnoreCase(from))
                .collect(Collectors.toList());

        List<Flights> ends = start.stream()
                .filter(f -> f.getFrom().equalsIgnoreCase(to))
                .collect(Collectors.toList());

        Stream<Connection> connections = start.stream()
                .flatMap(f -> ends.stream())
                .filter(s -> f.getTo().equalsIgnoreCase(s.getFrom()))
                .map( e -> new Connection(f, s));

        return connections;
    }
}
