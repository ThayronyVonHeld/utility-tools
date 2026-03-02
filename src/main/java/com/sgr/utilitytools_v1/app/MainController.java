package com.sgr.utilitytools_v1.app;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Navigator.setMainPane(mainPane);
        Navigator.loadView("/com/sgr/utilitytools_v1/dashboard/dashboard.fxml");
    }

    @FXML private HBox sidebarContainer;
    @FXML private VBox textMenu;
    @FXML private Button btnSeta;
    @FXML private StackPane mainPane;

    private boolean menuOpen = true;

    private static final double EXPANDED_WIDTH = 220;
    private static final double COLLAPSED_WIDTH = 60;

    @FXML
    private void menu() {

        double targetWidth = menuOpen ? COLLAPSED_WIDTH : EXPANDED_WIDTH;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(250),
                        new KeyValue(sidebarContainer.prefWidthProperty(), targetWidth)
                )
        );

        timeline.play();

        textMenu.setVisible(!menuOpen);
        textMenu.setManaged(!menuOpen);

        menuOpen = !menuOpen;

        if (menuOpen) {
            btnSeta.setText("<");
        } else {
            btnSeta.setText(">");
        }

    }

    @FXML
    private void openDashboard() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/dashboard/dashboard.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openSafe() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/passwordsafe/passwordsafe.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openDocuments() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/documents/documents.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openPhoneContacts() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/phonescontacts/phonescontacts.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openClock() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/clock/clock.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openCalendar() {
        try {
            Navigator.loadView("/com/sgr/utilitytools_v1/calendar/calendar.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openTimeSheet(){

}

    @FXML
    private void openIntranet(){

    }


    @FXML
    private void exit() {
        System.exit(0);
    }

}