package com.kodilla.hibernate.taskslist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TasksList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TasksListDaoTestSuite {

    @Autowired
    private TaskListDao tasksListDao;
    private static final String LISTNAME = "People";

    @Test
    void testFindByListName() {
        //Given
        TasksList tasksList = new TasksList(LISTNAME, "Nr of people using the internet now");
        tasksListDao.save(tasksList);
        String listname = tasksList.getListName();
        //When
        List<TasksList> list = tasksListDao.findByListName(listname);
        //Then
        assertEquals(listname, list.get(0).getListName());
        //CleanUp
        int id = list.get(0).getId();
        tasksListDao.deleteById(id);
    }
}
