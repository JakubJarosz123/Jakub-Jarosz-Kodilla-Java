package com.kodilla.stream.portfolio;

import java.time.LocalDate;

public class Task {
    private final String title;
    private final String description;
    private final User assingedUser;
    private final User creator;
    private final LocalDate created;
    private final LocalDate deadline;

    public Task(final String title, final String description, final User assingedUser,
                final User creator, final LocalDate created, final LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.assingedUser = assingedUser;
        this.creator = creator;
        this.created = created;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssingedUser() {
        return assingedUser;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assingedUser=" + assingedUser +
                ", creator=" + creator +
                ", created=" + created +
                ", deadline=" + deadline +
                '}';
    }
}
