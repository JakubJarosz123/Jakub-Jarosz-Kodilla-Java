package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testloadFromDb() {
        //Given
        //When
        library.loadFromDb();
        //Then
        //doNothing
    }

    @Test
    void testSaveToDb() {
        //Given
        //When
        library.saveToDb();
        //Then
        //doNothing
    }
}
