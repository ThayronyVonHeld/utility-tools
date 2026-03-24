package com.sgr.utilitytools_v1.clock;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClockController {

    @FXML private StackPane clockStackPane;

    public void initialize(URL location, ResourceBundle resources) {
        Navigator.setMainPane(clockStackPane);
        Navigator.loadView("/com/sgr/utilitytools_v1/clock/alarm/alarm.fxml");
    }


}
