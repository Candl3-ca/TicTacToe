package com.task3.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ComputerPlayerTest {

    @Test
    void testGetNameFromFile() {
        // Create a mock list of computer names
        List<String> mockComputerNames = Arrays.asList("Alpha", "Beta", "Gamma");

        // Mock the Files.readAllLines() method using a lambda expression
        ComputerPlayer.fileName = "mock_filename.txt"; // Set a mock file name
        ComputerPlayer computerPlayer = new ComputerPlayer('O') {

            public List<String> readAllLines(Path path) throws IOException {
                return mockComputerNames;
            }
        };

        String name = computerPlayer.getNameFromFile();

        assertTrue(mockComputerNames.contains(name));
    }

    @Test
    void testMakeMove() {
        char[][] board = {
                {'X', 'O', '\0'},
                {'O', '\0', 'X'},
                {'\0', 'X', 'O'}
        };

        ComputerPlayer computerPlayer = new ComputerPlayer('O') {
            public List<String> readAllLines(Path path) throws IOException {
                return null;
            }
        };
        int[] move = computerPlayer.makeMove(board);

        assertNotNull(move);
        assertTrue(move[0] >= 0 && move[0] < 3);
        assertTrue(move[1] >= 0 && move[1] < 3);
        assertTrue(board[move[0]][move[1]] == '\0');
    }
}
