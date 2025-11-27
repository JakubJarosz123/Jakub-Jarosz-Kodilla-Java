package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String whatToPaint;
    private final String color;
    private boolean executed = false;

    public PaintingTask(final String taskName, final String whatToPaint, final String color) {
        this.taskName = taskName;
        this.whatToPaint = whatToPaint;
        this.color = color;
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
