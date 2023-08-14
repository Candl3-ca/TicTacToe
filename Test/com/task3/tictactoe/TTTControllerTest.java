package com.task3.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TTTControllerTest extends ApplicationTest {

    private TTTController controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = new TTTController();
        Scene scene = new Scene(controller.getLabel(), 320, 320);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void testUpdateLabelHuman() {
        controller.updateLabelHuman("Alice");
        Label label = controller.getLabel();

        assertEquals("Alice has won!", label.getText());
        assertEquals("#00ff00", label.getStyle());
        assertEquals("Comic Sans MS", label.getFont().getFamily());
    }

    @Test
    void testUpdateLabelComputer() {
        controller.updateLabelComputer("Computer");
        Label label = controller.getLabel();

        assertEquals("Computer has won!", label.getText());
        assertEquals("#ff0000", label.getStyle());
        assertEquals("Comic Sans MS", label.getFont().getFamily());
    }

    @Test
    void testUpdateLabelDraw() {
        controller.updateLabelDraw();
        Label label = controller.getLabel();

        assertEquals("It's a draw", label.getText());
        assertEquals("#fff300", label.getStyle());
        assertEquals("Comic Sans MS", label.getFont().getFamily());
    }
}
