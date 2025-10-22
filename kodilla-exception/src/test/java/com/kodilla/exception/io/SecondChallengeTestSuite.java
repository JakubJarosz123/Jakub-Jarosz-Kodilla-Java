package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testReturnDoneForValidValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2.0));
    }

    @Test
    void testShouldThrowExceptionWhenXIsTooLow() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 2.0));
    }

    @Test
    void testShouldThrowExceptionWhenXIsTooHigh() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 2.0));
    }

    @Test
    void testShouldThrowExceptionWhenYIs1_5() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5));
    }
}
