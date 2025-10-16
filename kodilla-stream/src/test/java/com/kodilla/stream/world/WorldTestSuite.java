package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void getPeopleQuantity() {
        //Given
        //Add countries to Country
        Country poland = new Country("Poland", new BigDecimal("35000000"));
        Country china = new Country("China", new BigDecimal("1500000000"));
        Country france = new Country("France", new BigDecimal("60000000"));
        Country uk = new Country("UK", new BigDecimal("55000000"));
        Country india = new Country("India", new BigDecimal("2000000000"));

        //Add countries to Continents
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(france);
        europe.addCountry(uk);
        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        //Add continents to World
        World w = new World();
        w.addContinent(europe);
        w.addContinent(asia);

        //When
        BigDecimal peopleQuantityInWorld = w.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("3650000000");
        assertEquals(expectedPeopleQuantity, peopleQuantityInWorld);
    }
}
