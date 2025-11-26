package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testToString() {
        //Given
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(i -> listToDo.getTasks().add(new Task("To Do Task number " + i)));

        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(i -> listInProgress.getTasks().add(new Task("In Progress Task number " + i)));

        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach( i -> listDone.getTasks().add(new Task("Done Task number " + i)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(clonedBoard);
        //When
        board.getLists().remove(listToDo);
        //Then
        assertEquals(2, board.getLists().size());
        assertEquals(3, clonedBoard.getLists().size());
    }
}
