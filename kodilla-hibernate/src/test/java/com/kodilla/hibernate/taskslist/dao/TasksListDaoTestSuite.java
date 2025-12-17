package com.kodilla.hibernate.taskslist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TasksList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TasksList tasksList = new TasksList(LISTNAME, "ToDo tasks");
        tasksList.getTasks().add(task);
        tasksList.getTasks().add(task2);
        task.setTasksList(tasksList);
        task2.setTasksList(tasksList);
        //When
        tasksListDao.save(tasksList);
        int id = tasksList.getId();
        //Then
        assertNotEquals(0, id);
        //CleanUp
        //taskListDao.deleteById(id);
    }
}
