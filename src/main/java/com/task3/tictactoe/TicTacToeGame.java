package com.task3.tictactoe;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private char[][] board;
    private Player currentPlayer;

    public TicTacToeGame(Player player1, ComputerPlayer computerPlayer) {
        this.player1 = player1;
        this.player2 = computerPlayer;
        board = new char[3][3];
        currentPlayer = player1;
    }


    public char[][] getBoard() {
        return board.clone();
    }


    boolean hasWon() {
        // if 3 are the same in a row, column, or diagonal, then the player wins
        return (board[0][0] == currentPlayer.getSymbol() && board[0][1] == currentPlayer.getSymbol() && board[0][2] == currentPlayer.getSymbol())
                || (board[1][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[1][2] == currentPlayer.getSymbol())
                || (board[2][0] == currentPlayer.getSymbol() && board[2][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol())
                || (board[0][0] == currentPlayer.getSymbol() && board[1][0] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol())
                || (board[0][1] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][1] == currentPlayer.getSymbol())
                || (board[0][2] == currentPlayer.getSymbol() && board[1][2] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol())
                || (board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol())
                || (board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol());

    }


    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0;
    }


    public void makeMove(int row, int col) {
        assert row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0;
        board[row][col] = currentPlayer.getSymbol();
    }

    public void nextPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = player1;
        }
    }

}
