package com.task3.tictactoe;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import com.task3.tictactoe.HelloApplication;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloApplicationTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication helloApp = new HelloApplication();
        helloApp.start(stage);
    }

    @Test
    void testPlayButtonExists() {
        verifyThat("#playButton", hasText("Play"));
    }
}
