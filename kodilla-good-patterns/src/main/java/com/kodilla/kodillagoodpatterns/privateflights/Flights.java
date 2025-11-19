package com.kodilla.kodillagoodpatterns.privateflights;

import java.util.Objects;

public class Flights {
    private final String from;
    private final String to;

    public Flights(final String from, final String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return Objects.equals(from, flights.from) && Objects.equals(to, flights.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "Flights: " + "from = " + from + ", to = " + to;
    }
}