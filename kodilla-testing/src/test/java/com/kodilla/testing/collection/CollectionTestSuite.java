package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.*;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test Case: end\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "testOddNumbersExterminatorEmptyList"
    )

    @Test
    void testCaseExterminateEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = exterminator.exterminate(emptyList);
        //Then
        Assertions.assertTrue(result.isEmpty(), "Empty list should be empty");
    }

    @DisplayName(
            "testOddNumbersExterminatorNormalList"
    )

    @Test
    void testCaseExterminateNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> normalList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //When
        List<Integer> result = exterminator.exterminate(normalList);
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 8, 10);
        //Then
        Assertions.assertEquals(expectedList, result, "NormalList should contain expected list");
    }

}
