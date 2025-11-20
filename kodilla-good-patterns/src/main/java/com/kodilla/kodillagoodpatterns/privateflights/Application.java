package com.kodilla.kodillagoodpatterns.privateflights;

public class Application {
    public static void main(String[] args) {
        FlightRepository repo = new FlightConnector();
        FlightService service = new FlightServiceImpl(repo);

        repo.addFlight(new Flight("Gdańsk", "Wrocław", null));
        repo.addFlight(new Flight("Gdańsk", "Warszawa", "Poznań"));
        repo.addFlight(new Flight("Łódź", "Wrocław", null));

        System.out.println("Flights from Gdańsk: ");
        service.findFlightsFrom("Gdańsk").forEach(System.out::println);

        System.out.println("\nFlights to Wrocław: ");
        service.findFlightsTo("Wrocław").forEach(System.out::println);

        System.out.println("\nFlights via Poznań: ");
        service.findFlightsVia("Poznań").forEach(System.out::println);
    }
}
