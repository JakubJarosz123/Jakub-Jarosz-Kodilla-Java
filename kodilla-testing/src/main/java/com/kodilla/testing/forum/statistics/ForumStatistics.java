package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private Statistics statisticsMock;
    private double nrOfUsers;
    private double nrOfPosts;
    private double nrOfComments;
    private double avgPostsPerUsers;
    private double avgCommentsPerUsers;
    private double avgCommentsPerPost;

    public ForumStatistics(Statistics statisticsMock) {
        this.statisticsMock = statisticsMock;
    }

    public void calculateAdvStatistics(Statistics statisticsMock) {
        nrOfUsers = statisticsMock.userNames().size();
        nrOfPosts = statisticsMock.postsCount();
        nrOfComments = statisticsMock.commentsCounts();
        if (nrOfUsers > 0) {
            avgPostsPerUsers = nrOfPosts / nrOfUsers;
            avgCommentsPerUsers = nrOfComments / nrOfUsers;
        }else {
            avgPostsPerUsers = 0;
            avgCommentsPerUsers = 0;
        }
        if (nrOfPosts > 0) {
            avgCommentsPerPost = nrOfComments / nrOfPosts;
        }else {
            avgCommentsPerPost = 0;
        }
    }

    public double getNrOfUsers() {
        return nrOfUsers;
    }
    public double getNrOfPosts() { return nrOfPosts; }
    public double getNrOfComments() { return nrOfComments; }
    public double getAvgPostsPerUsers() { return avgPostsPerUsers; }
    public double getAvgCommentsPerUsers() { return avgCommentsPerUsers; }
    public double getAvgCommentsPerPost() { return avgCommentsPerPost; }

    public void showStatistics() {
        return;
    }
}
