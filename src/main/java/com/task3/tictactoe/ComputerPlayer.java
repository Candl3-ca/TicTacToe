package com.task3.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    static String fileName = "..\\TicTacToe\\src\\main\\java\\com\\task3\\tictactoe\\computer_name.txt";


    public ComputerPlayer(char symbol) {
        super(getNameFromFile(), symbol);
    }

    // overload
    public ComputerPlayer() {
        super(getNameFromFile(), 'O');
    }


    public static String getNameFromFile(){
        String randomComputerName = "";
        try {
            // Read all lines from the file into a list
            Path filePath = Paths.get(fileName);
            List<String> computerNames = Files.readAllLines(filePath);

            // Generate a random index
            Random random = new Random();
            int randomIndex = random.nextInt(computerNames.size());

            // Get the random computer name
            randomComputerName = computerNames.get(randomIndex);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        return randomComputerName;
    }

    // Method to get the computer's next move
    public int[] makeMove(char[][] board) {
        assert board.length == 3 && board[0].length == 3;
        // return a random empty cell
        int[] move = new int[2];
        do {
            move[0] = (int) (Math.random() * 3);
            move[1] = (int) (Math.random() * 3);
        } while (board[move[0]][move[1]] != '\0');
        return move;
    }
}
