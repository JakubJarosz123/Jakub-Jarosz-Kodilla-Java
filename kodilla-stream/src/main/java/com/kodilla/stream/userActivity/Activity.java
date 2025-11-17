package com.kodilla.stream.userActivity;

public class Activity {
    private String userID;
    private String type;
    private int points;

    public Activity(String userID, String type, int points) {
        this.userID = userID;
        this.type = type;
        this.points = points;
    }

    public String getUserID() {
        return userID;
    }

    public String getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Activity: " + "userID= " + userID + ", type= " + type + ", points= " + points;
    }
}
