package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String,Boolean> flightMap = new HashMap<>();

        flightMap.put("Warsaw",true);
        flightMap.put("London",true);
        flightMap.put("Paris",true);
        flightMap.put("Moscow",false);
        flightMap.put("Munich",true);
        flightMap.put("Johannesburg",false);

        String arrival = flight.getArrivalAirport();

        if(!flightMap.containsKey(arrival)){
            throw new RouteNotFoundException("Route not found");
        }
        return flightMap.get(arrival);
    }
}
