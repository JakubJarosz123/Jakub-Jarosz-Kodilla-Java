package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end\n");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "When created SimpleUser with realame, " +
            "then getRealName should return real user name"
    )

    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser","John Doe");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("John Doe", result);
    }
    @DisplayName(
            "When created SimpleUser with name, " +
            "then getUsername should return correct user name"
    )

    @Test
    void testCaseUsername(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Doe");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
