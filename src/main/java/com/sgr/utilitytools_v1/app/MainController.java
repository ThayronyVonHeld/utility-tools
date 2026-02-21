package com.sgr.utilitytools_v1.app;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private AnchorPane pane2; // área dos textos

    private boolean menuAberto = true;

    private static final double MENU_WIDTH = 180;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // começa aberto (porque visualmente já está)
        pane2.setTranslateX(0);
    }

    @FXML
    private void menu() {

        TranslateTransition transition = new TranslateTransition(Duration.millis(250), pane2);

        if (menuAberto) {
            // FECHAR (retrai os textos)
            transition.setToX(-MENU_WIDTH);
        } else {
            // ABRIR
            transition.setToX(0);
        }

        transition.play();
        menuAberto = !menuAberto;
    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}