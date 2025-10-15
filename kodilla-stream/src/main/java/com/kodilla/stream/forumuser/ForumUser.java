package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int userID;
    private final String userName;
    private final char gender;
    private final LocalDate birthDate;
    private final int nrOfPosts;


    public ForumUser(int userID, String userName, char gender, LocalDate birthDate, int nrOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.birthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());
        this.nrOfPosts = nrOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNrOfPosts() {
        return nrOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", nrOfPosts=" + nrOfPosts +
                '}';
    }
}
