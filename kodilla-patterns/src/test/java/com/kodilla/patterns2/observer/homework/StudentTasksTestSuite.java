package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTasksTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Student johnSmith = new Student("John");
        Student ewaJones = new Student("Ewa");
        Student wayneMcdonald = new Student("Wayne");

        Mentor rossHugh = new Mentor("Ross");
        Mentor natalieSmith = new Mentor("Natalie");

        johnSmith.registerObserver(rossHugh);
        ewaJones.registerObserver(rossHugh);
        wayneMcdonald.registerObserver(natalieSmith);
        //When
        johnSmith.addTask("Task 1");
        johnSmith.addTask("Task 2");
        ewaJones.addTask("Task 1");
        ewaJones.addTask("Task 2");
        ewaJones.addTask("Task 3");
        wayneMcdonald.addTask("Task 1");
        //Then
        assertEquals(5, rossHugh.getUpdateCount());
        assertEquals(1, natalieSmith.getUpdateCount());
    }
}
