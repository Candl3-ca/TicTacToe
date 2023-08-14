package com.task3.tictactoe;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerTest extends ApplicationTest {

    private HelloController controller;

    @Start
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 320, 320);
        stage.setScene(scene);
        stage.show();

        controller = fxmlLoader.getController();
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> {
            controller.welcomeText.setText(""); // Clear text before each test
        });
    }

    @Test
    void testOnPlayButtonClicked() {
        clickOn("#playButton");
        sleep(100); // Wait a bit for the UI to update

        assertEquals("Welcome to Tic Tac Toe!", controller.welcomeText.getText());
    }
}
