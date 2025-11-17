package com.kodilla.stream.examples;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Person> children;
    private Address address;

    public Person(String name, int age, List<Person> children, Address address) {
        this.name = name;
        this.age = age;
        this.children = children;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name= " + name +
                ", Age= " + age +
                ", Children= " + children +
                ", " + address;
    }
}
