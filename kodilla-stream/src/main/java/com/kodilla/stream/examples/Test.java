package com.kodilla.stream.examples;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Person stefan = new Person("Stefan", 29, null
                , new Address("Maków", "Kasztanowa 1", "96-124"));
        Person brajan = new Person("Brajan", 5, null
                , new Address("Maków", "Brzosty 1", "96-124"));
        Person dzesika = new Person("Dzesika", 6, null
                , new Address("Maków", "Brzosty 1", "96-124"));
        Person janusz = new Person("Janusz", 36, Collections.singletonList(brajan)
                , new Address("Maków", "Kasztanowa 1", "96-124"));
        Person dariusz = new Person("Dariusz", 39, Collections.singletonList(dzesika)
                , new Address("Skierniewice", "Tuwima 3", "96-100"));
        Person grazyna = new Person("Grazyna", 31, Arrays.asList(dzesika, brajan)
                , new Address("Maków", "Kasztanowa 1", "96-124"));
        Person mariola = new Person("Mariola", 22, Collections.EMPTY_LIST
                , new Address("Koluszki", "Dworcowa 1", "96-666"));

        List<Person> people = new ArrayList<>();
        people.add(stefan);
        people.add(brajan);
        people.add(dzesika);
        people.add(janusz);
        people.add(dariusz);
        people.add(grazyna);
        people.add(mariola);

        List<String> cities = people.stream()
                .map(p -> p.getAddress().getCity())
                        .collect(Collectors.toList());
        System.out.println("Cities: ");
        cities.forEach(System.out::println);


        List<String> citiesWORep = people.stream()
                .map(p -> p.getAddress().getCity())
                .distinct()
                        .collect(Collectors.toList());
        System.out.println("\nCities (without repeating): ");
        citiesWORep.forEach(System.out::println);

        List<String> citiesWithPeopleAgedBetween30And40 = people.stream()
                .filter(p -> p.getAge() >= 30 && p.getAge() <= 40)
                .map(p -> p.getAddress().getCity())
                .collect(Collectors.toList());
        System.out.println("\nCities with people aged from 30-40: ");
        citiesWithPeopleAgedBetween30And40.forEach(System.out::println);

        List<String> citiesWithPeopleAgedBetween30And40WithChildren = people.stream()
                .filter(p -> p.getAge() >= 30 && p.getAge() <= 40)
                .filter(p -> p.getChildren() != null)
                .map(p -> p.getAddress().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nCities with people aged from 30-40 and have children (wihtout repeating): ");
        citiesWithPeopleAgedBetween30And40WithChildren.forEach(System.out::println);

        List<String> namesOfChildren = people.stream()
                .filter(p -> p.getAge() >= 30 && p.getAge() <= 40)
                .filter(p -> p.getChildren() != null)
                .flatMap(p -> p.getChildren().stream())
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("\nNames of children: ");
        namesOfChildren.forEach(System.out::println);

        HashMap<String, Integer> map = new HashMap<>();
        people.stream()
                .filter(p -> p.getChildren() != null)
                .forEach(i -> map.put(i.getName(), i.getChildren().size()));
        System.out.println("\nMap of names and nr of children: ");
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        Person child = people.stream()
                .filter(p -> p.getChildren() != null)
                .findAny().get().getChildren().stream().findAny().get();
        System.out.println("\nChild: ");
        System.out.println(child.toString());

    }
}
