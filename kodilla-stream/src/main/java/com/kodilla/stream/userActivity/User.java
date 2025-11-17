package com.kodilla.stream.userActivity;

public class User {
    private String id;
    private String name;
    private boolean active;

    public User(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "User: " + "id= " + id + ", name= " + name + ", active= " + active;
    }
}
