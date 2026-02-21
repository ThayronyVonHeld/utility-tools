package com.sgr.utilitytools_v1.app;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private AnchorPane sidebarContainer;

    private boolean menuAberto = true;

    private static final double EXPANDED_WIDTH = 202;
    private static final double COLLAPSED_WIDTH = 60;

    @FXML
    private AnchorPane pane2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // começa aberto (porque visualmente já está)
    }

    @FXML
    private void menu() {

        double targetWidth = menuAberto ? COLLAPSED_WIDTH : EXPANDED_WIDTH;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(250),
                        new KeyValue(sidebarContainer.prefWidthProperty(), targetWidth)
                )
        );

        timeline.play();
        menuAberto = !menuAberto;

        FadeTransition fade = new FadeTransition(Duration.millis(300), pane2);
        fade.setToValue(!menuAberto ? 0 : 1);
        fade.play();
    }


    @FXML
    private void exit() {
        System.exit(0);
    }

}