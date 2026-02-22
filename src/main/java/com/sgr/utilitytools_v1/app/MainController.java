package com.sgr.utilitytools_v1.app;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // começa aberto (porque visualmente já está)
    }

    @FXML
    private HBox sidebarContainer;

    @FXML
    private VBox textMenu;

    @FXML
    private Button btnSeta;

    private boolean menuAberto = true;

    private static final double EXPANDED_WIDTH = 220;
    private static final double COLLAPSED_WIDTH = 60;

    @FXML
    private void menu() {

        double targetWidth = menuAberto ? COLLAPSED_WIDTH : EXPANDED_WIDTH;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(250),
                        new KeyValue(sidebarContainer.prefWidthProperty(), targetWidth)
                )
        );

        timeline.play();

        textMenu.setVisible(!menuAberto);
        textMenu.setManaged(!menuAberto);

        menuAberto = !menuAberto;

        if (menuAberto) {
            btnSeta.setText("<");
        } else {
            btnSeta.setText(">");
        }

    }


    @FXML
    private void exit() {
        System.exit(0);
    }

}