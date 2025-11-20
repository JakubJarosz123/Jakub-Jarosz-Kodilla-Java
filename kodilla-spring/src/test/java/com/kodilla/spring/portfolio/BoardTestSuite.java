package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().getTasks().add("To do list");
        board.getInProgressList().getTasks().add("In progress list");
        board.getDoneList().getTasks().add("Done list");
        //Then
        assertEquals("To do list", board.getToDoList().getTasks().get(0));
        assertEquals("In progress list", board.getInProgressList().getTasks().get(0));
        assertEquals("Done list", board.getDoneList().getTasks().get(0));
    }
}
