package com.kodilla.patterns.factory;

public final class ShapeFactory {

    public static final String CIRCLE = "Circle";
    public static final String SQUARE = "Square";
    public static final String RECTANGLE = "Rectangle";

    public final Shape makeShape(final String shapeClass) {
        return switch(shapeClass) {
            case CIRCLE -> new Circle("The rounded circle", 4.50);
            case SQUARE -> new Square("The angular square", 7.0);
            case RECTANGLE -> new Rectangle("The long rectangle", 15.0 , 2.50);
            default -> null;
        };
    }
}
