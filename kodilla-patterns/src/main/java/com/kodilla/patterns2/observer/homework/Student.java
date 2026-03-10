package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements HomeworkObservable {

    private final List<HomeworkObserver> observers;
    private final List<String> tasks;
    private String studentName;

    public Student(String studentName) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(HomeworkObserver homeworkObserver) {
        observers.add(homeworkObserver);
    }

    @Override
    public void notifyObserver() {
        for (HomeworkObserver homeworkObserver : observers) {
            homeworkObserver.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver homeworkObserver) {
        observers.remove(homeworkObserver);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}
