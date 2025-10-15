package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> users = new ArrayList<>();

    public Forum() {
        users.add(new ForumUser(1, "John123", 'M', LocalDate.of(2004, 5, 4), 50));
        users.add(new ForumUser(2, "Jordie333", 'F', LocalDate.of(1999, 12, 24), 45));
        users.add(new ForumUser(3, "Amelia122333", 'F', LocalDate.of(2006, 7, 12), 1500));
        users.add(new ForumUser(4, "DaveRoger321", 'M', LocalDate.of(2002, 8, 9), 10));
        users.add(new ForumUser(5, "GreyG123", 'M', LocalDate.of(2010, 5, 30), 120));

    }

    public List<ForumUser> getUserList() {
        return new  ArrayList<>(users);
    }
}
