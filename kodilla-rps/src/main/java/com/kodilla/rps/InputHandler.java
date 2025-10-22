package com.kodilla.rps;

import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public String getString(String s) {
        String input = "";
        while(true) {
            System.out.println(s);
            input = scanner.nextLine().trim();
            if(!input.isEmpty()) {
                return input;
            }else {
                System.out.println("Input cannot be empty. Try again.");
            }
        }
    }

    public int getPositiveInt(String prompt) {
        String input;
        return 0;
    }

    public String getMove(String prompt) {
        return null;
    }

    public boolean confirm(String question) {
        return false;
    }
}
