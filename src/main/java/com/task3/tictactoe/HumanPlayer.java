package com.task3.tictactoe;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    // overload
    public HumanPlayer(String name) {
        super(name, 'X');
    }
}
