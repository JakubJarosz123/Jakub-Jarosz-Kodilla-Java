package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findFlightsFrom(String departure) {
        return flightRepository.showFlights().stream()
                .filter(f -> f.getDeparture().equalsIgnoreCase(departure))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsTo(String arrival) {
        return flightRepository.showFlights().stream()
                .filter(f -> f.getArrival().equalsIgnoreCase(arrival))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsVia(String via) {
        return flightRepository.showFlights().stream()
                .filter(f -> via.equalsIgnoreCase(f.getVia()))
                .collect(Collectors.toList());
    }
}
