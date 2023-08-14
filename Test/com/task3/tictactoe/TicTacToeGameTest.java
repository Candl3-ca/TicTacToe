package com.task3.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {

    private HumanPlayer player1;
    private ComputerPlayer computerPlayer;
    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        player1 = new HumanPlayer("Alice", 'X');
        computerPlayer = new ComputerPlayer('O');
        game = new TicTacToeGame(player1, computerPlayer);
    }

    @Test
    void testInitialGameState() {
        char[][] initialBoard = game.getBoard();
        for (char[] row : initialBoard) {
            for (char cell : row) {
                assertEquals(0, cell);
            }
        }

        assertTrue(game.isBoardFull());
        assertFalse(game.hasWon());
    }

    @Test
    void testIsValidMove() {
        assertTrue(game.isValidMove(0, 0));
        assertTrue(game.isValidMove(1, 1));
        assertTrue(game.isValidMove(2, 2));
        assertFalse(game.isValidMove(-1, 1));
        assertFalse(game.isValidMove(3, 2));
        assertFalse(game.isValidMove(1, -1));
        assertFalse(game.isValidMove(1, 3));
        assertFalse(game.isValidMove(0, 0)); // Already occupied
    }

    @Test
    void testMakeMove() {
        int row = 0;
        int col = 0;

        game.makeMove(row, col);
        char[][] board = game.getBoard();

        assertEquals(player1.getSymbol(), board[row][col]);
        assertTrue(game.isValidMove(row, col)); // Should still be valid
    }

    @Test
    void testHasWon() {
        char[][] board = game.getBoard();

        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';

        assertTrue(game.hasWon());
    }

    @Test
    void testIsBoardFull() {
        char[][] board = game.getBoard();

        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        board[1][0] = 'O';
        board[1][1] = 'X';
        board[1][2] = 'O';
        board[2][0] = 'O';
        board[2][1] = 'X';
        board[2][2] = 'O';

        assertTrue(game.isBoardFull());
    }
}
