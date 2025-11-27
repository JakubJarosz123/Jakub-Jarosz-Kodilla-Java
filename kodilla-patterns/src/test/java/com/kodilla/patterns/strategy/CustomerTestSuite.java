package com.kodilla.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies() {
        //Given
        Customer steve = new IndividualCustomer("Steve Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        String stevenShouldBuy = steve.predict();
        System.out.println("Steve should:  " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should:  " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should:  " + kodillaShouldBuy);

        //Then
        assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //Given
        Customer steve = new IndividualCustomer("Steven Links");

        //When
        String steveShouldBuy = steve.predict();
        System.out.println("Steve should: " + steveShouldBuy);
        steve.setBuyingStrategy(new AggressivePredictor());
        steveShouldBuy = steve.predict();
        System.out.println("Steve now should: " + steveShouldBuy);

        //Then
        assertEquals("[Aggressive predictor] Buy stock of XYZ", steveShouldBuy);
    }
}
