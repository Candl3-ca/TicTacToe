package com.task3.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void testConstructor() {
        char symbol = 'X';
        String name = "Alice";
        Player player = new Player(name, symbol);

        assertEquals(name, player.getName());
        assertEquals(symbol, player.getSymbol());
    }

    @Test
    void testGetterMethods() {
        char symbol = 'O';
        String name = "Bob";
        Player player = new Player(name, symbol);

        assertEquals(name, player.getName());
        assertEquals(symbol, player.getSymbol());
    }

    @Test
    void testInvalidSymbol() {
        char invalidSymbol = 'A';
        String name = "InvalidPlayer";

        assertThrows(AssertionError.class, () -> {
            new Player(name, invalidSymbol);
        });
    }

    @Test
    void testNameNotNull() {
        char symbol = 'X';

        assertThrows(AssertionError.class, () -> {
            new Player(null, symbol);
        });
    }
}
