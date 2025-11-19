package com.kodilla.kodillagoodpatterns.privateflights;

public class EmailService implements InformationService{
    @Override
    public void information(Client client){
        System.out.println("Flight for: " + client.getName() + ", to " + client.getFlights() + " was successfully registered!");
    }
}
