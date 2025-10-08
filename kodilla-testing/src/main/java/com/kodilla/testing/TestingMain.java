package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("Test OK\n");
        }else {
            System.out.println("Test FAILED\n");
        }

        //tu umieść kolejny test ->
        System.out.println("Test - pierwszy test jednostkowy:\n");

        Calculator calculator = new Calculator();

        System.out.println(calculator.add(5, 10));
        System.out.println(calculator.sub(15, 10));
    }
}
