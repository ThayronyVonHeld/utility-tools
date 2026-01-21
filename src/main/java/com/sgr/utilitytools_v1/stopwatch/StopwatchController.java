package com.sgr.utilitytools_v1.stopwatch;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;

public class StopwatchController {

    @FXML private Label timeLabel;
    @FXML private Arc bgArc;

    private StopwatchService service;

    @FXML
    public void initialize() {
        Stopwatch stopwatch = new Stopwatch(300); // 5 minutos
        service = new StopwatchService(stopwatch);

        service.setOnTick(this::updateUI);
        service.setOnFinish(() -> timeLabel.setText("00:00:00"));
    }

    @FXML
    private void play() {
        service.start();
    }

    @FXML
    private void stop() {
        service.stop();
    }

    private void updateUI() {
        int seconds = service.getStopwatch().getRemainingSeconds();

        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;

        timeLabel.setText(String.format("%02d:%02d:%02d", h, m, s));

        double progress = (double) seconds / service.getStopwatch().getTotalSeconds();
        bgArc.setLength(360 * progress);
    }
}
