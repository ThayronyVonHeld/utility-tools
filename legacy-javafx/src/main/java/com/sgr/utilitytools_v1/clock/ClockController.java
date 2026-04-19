package com.sgr.utilitytools_v1.clock;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;


public class ClockController implements Initializable {

    @FXML private StackPane clockStackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClockNavigator.loadClockView(
                clockStackPane,
                "/com/sgr/utilitytools_v1/clock/alarm/alarmview.fxml"
        );
    }

    @FXML
    private void loadAlarm() {
        ClockNavigator.loadClockView(
                clockStackPane,
                "/com/sgr/utilitytools_v1/clock/alarm/alarmview.fxml"
        );
    }

    @FXML
    private void loadStopwatch() {
        ClockNavigator.loadClockView(
                clockStackPane,
                "/com/sgr/utilitytools_v1/clock/stopwatch/stopwatch.fxml"
        );
    }

    @FXML
    private void loadTimer() {
        ClockNavigator.loadClockView(
                clockStackPane,
                "/com/sgr/utilitytools_v1/clock/timer/Timer.fxml"
        );
    }

}
