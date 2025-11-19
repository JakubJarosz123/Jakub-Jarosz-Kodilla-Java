package com.kodilla.kodillagoodpatterns.privateflights;

public class Connection {
    private Flights firstLeg;
    private Flights secondLeg;

    public Connection(Flights firstLeg, Flights secondLeg) {
        this.firstLeg = firstLeg;
        this.secondLeg = secondLeg;
    }

    public Flights getFirstLeg() {
        return firstLeg;
    }

    public Flights getSecondLeg() {
        return secondLeg;
    }

    @Override
    public String toString() {
        return firstLeg + " " + secondLeg;
    }
}
