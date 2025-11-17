package com.kodilla.kodillagoodpatterns.challenges;

public class EmailService implements InformationService{
    @Override
    public void inform(User user) {
        System.out.println("\nEmail sent to: " + user.getName());
    }
}
