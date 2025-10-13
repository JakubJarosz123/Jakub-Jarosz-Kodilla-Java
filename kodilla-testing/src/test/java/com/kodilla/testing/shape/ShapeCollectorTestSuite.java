package com.kodilla.testing.shape;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Beginning of tests");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Ending of tests");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Starting test...");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Ending test...");
    }

    @DisplayName("Test to add figure")
    @Test
    void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape circle = new Circle(12);
        shapeCollector.addFigure(circle);
        //Then
        assertEquals(circle, shapeCollector.getFigure(0));
    }

    @DisplayName("Test to remove figure")
    @Test
    void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape square = new Square(3);
        shapeCollector.addFigure(square);
        boolean result = shapeCollector.removeFigure(square);
        //Then
        assertTrue (result);
        assertEquals(0, shapeCollector.getShapes().size());
    }

    @DisplayName("Test to get figure")
    @Test
    void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape triangle = new Triangle(15, 10);
        shapeCollector.addFigure(triangle);
        Shape getfigure = shapeCollector.getFigure(0);
        //Then
        assertEquals(triangle, getfigure);
    }

    @DisplayName("Test to show all figures")
    @Test
    void testShowAllFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(new Circle(10));
        shapeCollector.addFigure(new Triangle(4, 8));
        shapeCollector.addFigure(new Square(18));
        String result = shapeCollector.showFigures();
        //Then
        assertEquals("Circle, Triangle, Square", result);
    }
}
