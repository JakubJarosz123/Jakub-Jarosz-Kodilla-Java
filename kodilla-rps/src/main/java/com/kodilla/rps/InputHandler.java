package com.kodilla.rps;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    //Reads input of player name
    public String getString(String s) {
        String input = "";
        while(true) {
            System.out.print(s);
            input = scanner.nextLine().trim();
            if(!input.isEmpty()) {
                return input;
            }else {
                System.out.println("Input cannot be empty. Try again.");
            }
        }
    }

    //Reads input on nr of rounds
    public int getInt(String s) {
        System.out.print(s);
        while(true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    //Reads move of player
    public String getMove() {
        while(true) {
            System.out.print("\nEnter your move (1) / (2) / (3) / (x) / (n): ");
            String move = scanner.nextLine().trim().toLowerCase();

            if (move.matches("[123xn]")) {
                return move;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    //Confirmation when exiting or starting a new game
    public boolean confirm(String q) {
        while(true) {
            System.out.print(q + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if(input.equals("y")) {
                return true;
            } else if(input.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter with (y) or (n).");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
