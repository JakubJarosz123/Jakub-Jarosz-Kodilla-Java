package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigMacTestSuite {

    @Test
    void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("brioche")
                .burgers(2)
                .sauce("bbq")
                .ingredients("tomato")
                .ingredients("onion")
                .ingredients("lettuce")
                .ingredients("bacon")
                .ingredients("jalapeno pepper")
                .build();
        //When
        String whatBun = bigMac.getBun();
        int howManyBurgers = bigMac.getBurgers();
        String whatSauces = bigMac.getSauce();
        boolean notIncludedIngredient = bigMac.getIngredients().contains("onion rings");
        int howManyIngrediants = bigMac.getIngredients().size();
        //Then
        assertEquals("brioche",  whatBun);
        assertEquals(2,  howManyBurgers);
        assertEquals("bbq",  whatSauces);
        assertFalse(notIncludedIngredient, "onion rings");
        assertEquals(5,  howManyIngrediants);
    }
}
