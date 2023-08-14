package com.task3.tictactoe;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;

public class TTTController {
    ComputerPlayer computerPlayer;
    HumanPlayer humanPlayer;
    TicTacToeGame game;

    // Initialize the buttons array
    @FXML
    Button btn00 = new Button();
    @FXML
    Button btn01 = new Button();
    @FXML
    Button btn02 = new Button();
    @FXML
    Button btn10 = new Button();
    @FXML
    Button btn11 = new Button();
    @FXML
    Button btn12 = new Button();
    @FXML
    Button btn20 = new Button();
    @FXML
    Button btn21 = new Button();
    @FXML
    Button btn22 = new Button();

    @FXML
    private Label label;

    @FXML
    private Button[][] buttons;


    public void initialize() {
        int forRandomSymbol = (int) (Math.random() * 2);
        if (forRandomSymbol == 0) {
            computerPlayer = new ComputerPlayer();
            humanPlayer = new HumanPlayer("X-man");
        } else {
            computerPlayer = new ComputerPlayer('X');
            humanPlayer = new HumanPlayer("Oracle", 'O');
        }
        game = new TicTacToeGame(humanPlayer, computerPlayer);


        buttons = new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };
    }


    @FXML
    public void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);
        System.out.println(row + "  " + col);

        if (game.isValidMove(row, col)) {
            // update the board
            game.makeMove(row, col);
            clickedButton.setText(String.valueOf(game.getBoard()[row][col]));
            // check if the player has won
            if (game.hasWon()) {
                updateLabelHuman(humanPlayer.getName());
            } else if (game.isBoardFull()) {
                updateLabelDraw();
            }else {
                game.nextPlayer();
                // computer plays / makes a move
                int[] move = computerPlayer.makeMove(game.getBoard());
                game.makeMove(move[0], move[1]);
                buttons[move[1]][move[0]].setText(String.valueOf(game.getBoard()[move[0]][move[1]]));
                // check if the computer has won
                if (game.hasWon()) {
                    updateLabelComputer(computerPlayer.getName());
                }
            }
            game.nextPlayer();
        } else {
            System.out.println("Invalid move. Try again.");
            System.out.println(game.getBoard()[row][col]);
        }
    }

    private void checkForWin() {
        for (int i = 0; i < 3; i++) {
            // check rows
            if (!btn00.getText().isEmpty() && btn00.getText().equals(btn01.getText()) && btn00.getText().equals(btn02.getText())) {
                System.out.println(btn00.getText() + " wins!");
            } else if (!btn10.getText().isEmpty() && btn10.getText().equals(btn11.getText()) && btn10.getText().equals(btn12.getText())) {
                System.out.println(btn10.getText() + " wins!");
            } else if (!btn20.getText().isEmpty() && btn20.getText().equals(btn21.getText()) && btn20.getText().equals(btn22.getText())) {
                System.out.println(btn20.getText() + " wins!");
            }

            // check columns
            if (!btn00.getText().isEmpty() && btn00.getText().equals(btn10.getText()) && btn00.getText().equals(btn20.getText())) {
                System.out.println(btn00.getText() + " wins!");
            } else if (!btn01.getText().isEmpty() && btn01.getText().equals(btn11.getText()) && btn01.getText().equals(btn21.getText())) {
                System.out.println(btn01.getText() + " wins!");
            } else if (!btn02.getText().isEmpty() && btn02.getText().equals(btn12.getText()) && btn02.getText().equals(btn22.getText())) {
                System.out.println(btn02.getText() + " wins!");
            }

            // check diagonals
            if (!btn00.getText().isEmpty() && btn00.getText().equals(btn11.getText()) && btn00.getText().equals(btn22.getText())) {
                System.out.println(btn00.getText() + " wins!");
            } else if (!btn02.getText().isEmpty() && btn02.getText().equals(btn11.getText()) && btn02.getText().equals(btn20.getText())) {
                System.out.println(btn02.getText() + " wins!");
            }

            // check draw
            if (!btn00.getText().isEmpty() && !btn01.getText().isEmpty() && !btn02.getText().isEmpty() && !btn10.getText().isEmpty() && !btn11.getText().isEmpty() && !btn12.getText().isEmpty() && !btn20.getText().isEmpty() && !btn21.getText().isEmpty() && !btn22.getText().isEmpty()) {
                System.out.println("It's a draw!");
            }
        }
    }

    @FXML
    private void updateLabel(String text, String backgroundColor, String fontFamily) {
        label.setText(text);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: " + backgroundColor + "; -fx-font-family: '" + fontFamily + "'");
    }


    @FXML
    void updateLabelHuman(String name) {
        updateLabel(name + " has won!", "#00ff00", "Comic Sans MS");
    }

    @FXML
    void updateLabelComputer(String name) {
        updateLabel(name + " has won!", "#ff0000", "Comic Sans MS");
    }

    @FXML
    void updateLabelDraw() {
        updateLabel("It's a draw", "#fff300", "Comic Sans MS");
    }

    public Label getLabel() {
        return label;
    }
}
