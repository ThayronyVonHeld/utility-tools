package com.sgr.utilitytools_v1.app;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private VBox sidebarContainer;
    @FXML private Button btnSeta;
    @FXML private StackPane mainPane;

    private boolean menuOpen = true;

    private static final double EXPANDED_WIDTH = 220;
    private static final double COLLAPSED_WIDTH = 60;

    private final Map<Button, String> buttonTexts = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Navigator.setMainPane(mainPane);
        Navigator.loadView("/com/sgr/utilitytools_v1/dashboard/dashboard.fxml");

        for (Node node : sidebarContainer.getChildren()) {
            if (node instanceof Button btn) {
                buttonTexts.put(btn, btn.getText());
            }
        }
    }

    @FXML private void menu() {

        double targetWidth = menuOpen ? COLLAPSED_WIDTH : EXPANDED_WIDTH;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(250),
                        new KeyValue(sidebarContainer.prefWidthProperty(), targetWidth)
                )
        );

        timeline.play();

        for (Node node : sidebarContainer.getChildren()) {
            if (node instanceof Button btn) {

                if (menuOpen) {
                    btn.setText(""); // recolhe
                    btn.setGraphicTextGap(0); // evita espaço estranho
                } else {
                    btn.setText(buttonTexts.get(btn)); // expande
                    btn.setGraphicTextGap(20);
                }
            }
        }

        menuOpen = !menuOpen;

        btnSeta.setText(menuOpen ? "<" : ">");
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

        try {

            Desktop.getDesktop().browse(new URI("https://www.youtube.com/"));
        } catch (Exception e) {
            e.printStackTrace();
        }


}

    @FXML
    private void openIntranet(){

        try {

            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/thayrony-von-held-b14ba7256/"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void exit() {
        System.exit(0);
    }

}