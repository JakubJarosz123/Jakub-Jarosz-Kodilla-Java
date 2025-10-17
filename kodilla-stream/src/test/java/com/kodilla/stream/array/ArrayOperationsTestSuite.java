package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] table = {1, 2, 3, 4, 5};
        //When
        double result = ArrayOperations.getAverage(table);
        //Then
        assertEquals(3.0,  result, 0.01);
    }
}
