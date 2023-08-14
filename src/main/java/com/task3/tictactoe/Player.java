package com.task3.tictactoe;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        assert name != null;
        assert  symbol == 'X' || symbol == 'O';
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
