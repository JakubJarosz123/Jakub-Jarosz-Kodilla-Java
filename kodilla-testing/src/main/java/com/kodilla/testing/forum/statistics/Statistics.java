package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {

    //list of users names
    List<String> userNames();

    //total quantity of forum posts
    int postsCount();

    //total quantity of forum comments
    int commentsCounts();
}
