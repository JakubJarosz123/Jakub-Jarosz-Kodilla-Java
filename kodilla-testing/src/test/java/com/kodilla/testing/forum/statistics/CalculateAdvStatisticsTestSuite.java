package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Calculate Advanced Statistics")
@ExtendWith(MockitoExtension.class)
public class CalculateAdvStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Ending of tests.");
    }

    @BeforeEach
    void beforeEach() {
        forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Starting test...");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Ending test...");
    }

    @DisplayName("Test when nr of posts = 0")
    @Test
    void testNrOfPosts0() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>(List.of("user1", "user2", "user3", "user4", "user5")));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNrOfUsers());
        assertEquals(0, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(0, forumStatistics.getAvgPostsPerUsers());
        assertEquals(10, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfPosts1000() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>(List.of("user1", "user2", "user3", "user4", "user5")));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNrOfUsers());
        assertEquals(1000, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(200, forumStatistics.getAvgPostsPerUsers());
        assertEquals(10, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(0.05, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfComments0() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>(List.of("user1", "user2", "user3", "user4", "user5")));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCounts()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNrOfUsers());
        assertEquals(50, forumStatistics.getNrOfPosts());
        assertEquals(0, forumStatistics.getNrOfComments());
        assertEquals(10, forumStatistics.getAvgPostsPerUsers());
        assertEquals(0, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfCommentsLowerThanPosts() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>(List.of("user1", "user2", "user3", "user4", "user5")));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNrOfUsers());
        assertEquals(100, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(20, forumStatistics.getAvgPostsPerUsers());
        assertEquals(10, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfCommentsHigherThanPosts() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>(List.of("user1", "user2", "user3", "user4", "user5")));
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNrOfUsers());
        assertEquals(10, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(2, forumStatistics.getAvgPostsPerUsers());
        assertEquals(10, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfUsers0() {
        //Given
        when(statisticsMock.userNames()).thenReturn(List.of());
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getNrOfUsers());
        assertEquals(10, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(0, forumStatistics.getAvgPostsPerUsers());
        assertEquals(0, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testNrOfUsers100() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<String>(){{
            for (int i = 0; i < 100; i++) {
                add("user" + i);
            }
        }});
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCounts()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getNrOfUsers());
        assertEquals(10, forumStatistics.getNrOfPosts());
        assertEquals(50, forumStatistics.getNrOfComments());
        assertEquals(0.1, forumStatistics.getAvgPostsPerUsers());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerUsers());
        assertEquals(5, forumStatistics.getAvgCommentsPerPost());
    }
}