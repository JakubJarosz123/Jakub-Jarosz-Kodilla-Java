package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING =  "DRIVING";

    public Task makeTask(final String taskClass) {
        return switch(taskClass) {
            case SHOPPING -> new ShoppingTask("Shopping for 10 vegetables", "Vegetables", 10);
            case PAINTING -> new PaintingTask("Painting Mona Lisa", "Mona Lisa", "Blue");
            case DRIVING -> new DrivingTask("Driving Car in Poland", "Car", "Poland");
            default -> throw new IllegalArgumentException("Invalid task class: " + taskClass);
        };
    }
}
