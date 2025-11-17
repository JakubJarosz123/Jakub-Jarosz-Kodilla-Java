package com.kodilla.stream.userActivity;

import java.util.Map;

public class Report {
    private int totalPoints;
    private int totalPointsWithBonuses;
    private int activeUserCount;
    private String mostActiveUserName;
    private Map<String, Integer> pointsByType;

    public Report(int totalPoints, int totalPointsWithBonuses, int activeUserCount, String mostActiveUserName, Map<String, Integer> pointsByType) {
        this.totalPoints = totalPoints;
        this.totalPointsWithBonuses = totalPointsWithBonuses;
        this.activeUserCount = activeUserCount;
        this.mostActiveUserName = mostActiveUserName;
        this.pointsByType = pointsByType;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPointsWithBonuses() {
        return totalPointsWithBonuses;
    }

    public void setTotalPointsWithBonuses(int totalPointsWithBonuses) {
        this.totalPointsWithBonuses = totalPointsWithBonuses;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(int activeUserCount) {
        this.activeUserCount = activeUserCount;
    }

    public String getMostActiveUserName() {
        return mostActiveUserName;
    }

    public void setMostActiveUserName(String mostActiveUserName) {
        this.mostActiveUserName = mostActiveUserName;
    }

    public Map<String, Integer> getPointsByType() {
        return pointsByType;
    }

    public void setPointsByType(Map<String, Integer> pointsByType) {
        this.pointsByType = pointsByType;
    }

    public void print() {
        System.out.println("=======================");
        System.out.println("ACTIVITY REPORT");
        System.out.println("=======================");
        System.out.println("Total points: " + totalPoints);
        System.out.println("Total points with bonuses: " + totalPointsWithBonuses);
        System.out.println("Active users: " + activeUserCount);
        System.out.println("Most active user: " + mostActiveUserName);
        System.out.println("\nPoints by type: " + pointsByType);
        System.out.println("=======================");
    }
}
