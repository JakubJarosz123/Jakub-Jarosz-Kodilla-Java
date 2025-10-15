package com.kodilla.stream;

import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Forum;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfForum = forum.getUserList().stream()
                .filter(m -> m.getGender() == 'M')
                .filter(m -> m.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(m -> m.getNrOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, m -> m));

        theResultMapOfForum.forEach((userID, user) -> System.out.println(userID + ": " + user));
    }
}
