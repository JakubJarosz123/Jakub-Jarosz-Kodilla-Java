package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Moscow", "Berlin");
        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finished");
        }
    }
}
