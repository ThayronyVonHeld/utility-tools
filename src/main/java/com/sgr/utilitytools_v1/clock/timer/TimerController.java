package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;

public class TimerController {
    @FXML
    private Arc bgArc;
    @FXML
    private Label timeLabel;

    private final TimerService service = TimerService.getInstance();

    @FXML
    public void initialize() {

        ClockService.getInstance().tickProperty().addListener((obs, oldVal, newVal) -> {
            updateUI();
        });

        updateUI();
    }

    private void updateUI() {
        timeLabel.setText(formatTime(service.getRemainingSeconds()));
        updateArc();
    }

    private void updateArc() {
        int total = service.getTotalSeconds();
        int remaining = service.getRemainingSeconds();

        if (total == 0) return;

        double progress = (double) remaining / total;
        double targetLength = 360 * progress;

        bgArc.setLength(targetLength);

    }
    @FXML
    private void plaTimer() {
        service.start();
    }

    @FXML
    private void StopTimer() {
        service.pause();
    }

    @FXML
    private void reset() {
        service.reset();
    }

    private String formatTime(int totalSeconds) {
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }
}