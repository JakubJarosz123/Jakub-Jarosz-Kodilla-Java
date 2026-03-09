package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = order.getCost();
        String description = order.getDescription();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Margarita Pizza", description);
    }

    @Test
    public void testPepperoniPizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new PepperoniOrderDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        String description = order.getDescription();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
        assertEquals("Margarita Pizza with pepperoni", description);
    }

    @Test
    public void testPineapplePizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new PineappleOrderDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        String description = order.getDescription();
        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Margarita Pizza with pineapple", description);
    }

    @Test
    public void testExtraCheesePizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseOrderDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        String description = order.getDescription();
        //Then
        assertEquals(new BigDecimal(17), calculatedCost);
        assertEquals("Margarita Pizza with extra cheese", description);
    }

    @Test
    public void testCustomPizzaOrder() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new PepperoniOrderDecorator(order);
        order = new PepperoniOrderDecorator(order);
        order = new ExtraCheeseOrderDecorator(order);
        order = new ExtraCheeseOrderDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        String description = order.getDescription();
        //Then
        assertEquals(new BigDecimal(29), calculatedCost);
        assertEquals("Margarita Pizza with pepperoni with pepperoni with extra cheese with extra cheese", description);
    }
}
