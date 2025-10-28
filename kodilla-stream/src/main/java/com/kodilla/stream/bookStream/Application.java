package com.kodilla.stream.bookStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Java programming", List.of("Adam Nowak", "Ewa Kowalska")),
                new Book("Stream Mastery", List.of("Ewa Kowalska", "Jan Kowal")),
                new Book("Functional Thinking", List.of("Adam Nowak", "Piotr Zalewski"))
        );

        List<String> uniqueAuthors = books.stream()
                .flatMap(b -> b.getAuthors().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Unique Authors: ");
        uniqueAuthors.forEach(System.out::println);

        int sumLettersInSurname = uniqueAuthors.stream()
                .map(l -> l.split(" ")[1])
                .map(String::length)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal nr of letters in surname: " + sumLettersInSurname);
    }
}
