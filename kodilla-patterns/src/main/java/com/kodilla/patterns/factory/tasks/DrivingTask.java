package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private final String taskName;
    private final String using;
    private final String where;
    private boolean executed = false;

    public DrivingTask(final String taskName, final String using, final String where) {
        this.taskName = taskName;
        this.using = using;
        this.where = where;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        executed = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
