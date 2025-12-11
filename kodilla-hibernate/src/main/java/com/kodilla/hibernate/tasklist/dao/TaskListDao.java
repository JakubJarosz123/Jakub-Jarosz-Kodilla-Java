package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TasksList;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TasksList, Integer> {

    List<TasksList> findByListName(String listName);
}
