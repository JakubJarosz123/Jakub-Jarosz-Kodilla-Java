package com.kodilla.rps;

import java.io.InputStreamReader;

public class RpsRunner {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        boolean end  = false;

        System.out.println("============================================== Rock, Paper, Scissors ============================================");

        while (!end) {
            String playersName = input.getString("\nEnter your name: ");
            int roundsToWin = input.getInt("Enter the nr of rounds to win: ");

            int playerWins = 0;
            int computerWins = 0;

            System.out.println("\n----- Game Controls -----");
            System.out.println("Press (1) for Rock");
            System.out.println("Press (2) for Paper ");
            System.out.println("Press (3) for Scissors");
            System.out.println("Press (x) to end game");
            System.out.println("Press (n) to start a new game");

            System.out.println("\nThe game is starting ...");

            boolean active = true;

            while (active) {
                String move = input.getMove();

                if (move.equals("x")) {
                    if (input.confirm("Are you sure you want to exit the game?")) {
                        active = false;
                        end = true;
                    }
                    continue;
                }

                if (move.equals("n")) {
                    if (input.confirm("Are you sure you want to start a new game?")) {
                        System.out.println("Starting new game ...");
                        active = false;
                    }
                    continue;
                }

                int moveInt =  Integer.parseInt(move);

                Round round1 = new Round(moveInt);
                round1.generateComputerMove();
                round1.compareMoves();
                round1.roundInfo();

                if (round1.isPlayerWinner()) playerWins++;
                if (round1.isComputerWinner()) computerWins++;

                System.out.println("Score: ");
                System.out.println(playersName + ": [ " + playerWins + " ]");
                System.out.println("Computer: [ " + computerWins + " ]");

                if (playerWins == roundsToWin ||  computerWins == roundsToWin) {
                    System.out.println("\n  ===== GAME OVER =====");
                    if (playerWins > computerWins) {
                        System.out.println("Congratulations! You win!");
                    } else {
                        System.out.println("Computer won :( Better luck next time!");
                    }
                }
            }
        }
        input.close();
    }
}
