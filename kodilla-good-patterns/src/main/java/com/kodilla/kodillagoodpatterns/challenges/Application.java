package com.kodilla.kodillagoodpatterns.challenges;

import java.awt.image.ImageProducer;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String movies = movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .reduce("", (a, b) -> a + " ! " + b);

        System.out.println(movies);
    }
}
