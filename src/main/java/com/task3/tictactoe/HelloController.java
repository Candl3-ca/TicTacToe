package com.task3.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class HelloController {

    @FXML
    Label welcomeText;

    @FXML
    protected void onPlayButtonClicked() {
        welcomeText.setText("Welcome to Tic Tac Toe!");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerVsComp.fxml"));
            Parent root = loader.load();

            Scene gameScene = new Scene(root);
            Stage stage = (Stage) welcomeText.getScene().getWindow();
            stage.setScene(gameScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
