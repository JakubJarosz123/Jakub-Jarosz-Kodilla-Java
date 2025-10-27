package com.kodilla.rps;

import java.util.Random;

public class Round {
    private int playerMove;
    private int computerMove;
    private String roundResult;

    public Round(int playerMove) {
        this.playerMove = playerMove;
    }

    //Returns name of users move
    public String getMoveName(int move) {
        switch (move) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid";
        }
    }

    //Generates computers move
    public void generateComputerMove() {
        Random random = new Random();
        computerMove = random.nextInt(3) + 1;
    }

    //Returns result of round
    public String getResult() {
        return roundResult;
    }

    //Compares user and computer moves
    public void compareMoves() {
        if (playerMove == computerMove) {
            roundResult = "It's a draw!";
        } else if (
                (playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2))
        {
            roundResult = "Player wins!";
        } else {
            roundResult = "Computer wins!";
        }
    }

    //Prints the info of the round
    public void roundInfo() {
        System.out.println("\n========== Round Summary ==========");
        System.out.println("Player move: " + getMoveName(playerMove));
        System.out.println("Computer move: " + getMoveName(computerMove));
        System.out.println("Result: " + roundResult);
    }

    //Returns if player is the winner
    public boolean isPlayerWinner() {
        return "Player wins!".equals(roundResult);
    }

    //Returns if computer is the winner
    public boolean isComputerWinner() {
        return "Computer wins!".equals(roundResult);
    }
}
