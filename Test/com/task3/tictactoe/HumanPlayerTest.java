package com.task3.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HumanPlayerTest {

    @Test
    void testConstructor() {
        char symbol = 'X';
        String name = "Alice";
        HumanPlayer humanPlayer = new HumanPlayer(name, symbol);

        assertEquals(name, humanPlayer.getName());
        assertEquals(symbol, humanPlayer.getSymbol());
    }

    @Test
    void testInheritance() {
        char symbol = 'O';
        String name = "Bob";
        HumanPlayer humanPlayer = new HumanPlayer(name, symbol);

        assertTrue(humanPlayer instanceof Player);
    }
}
