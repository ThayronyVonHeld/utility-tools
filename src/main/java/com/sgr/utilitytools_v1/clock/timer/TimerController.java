package com.sgr.utilitytools_v1.clock.timer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;

public class TimerController {
    @FXML private Arc bgArc;
    @FXML private Label timeLabel;
    private final TimerService service = TimerService.getInstance();

    @FXML
    public void initialize() {
        // Faz o bind da Label diretamente com o Service
        service.remainingSecondsProperty().addListener((obs, old, newVal) -> {
            updateUI(newVal.intValue());
        });

        // Atualização inicial
        updateUI(service.remainingSecondsProperty().get());
    }

    private void updateUI(int remaining) {
        int h = remaining / 3600;
        int m = (remaining % 3600) / 60;
        int s = remaining % 60;
        timeLabel.setText(String.format("%02d:%02d:%02d", h, m, s));

        // Atualiza o arco
        double progress = (double) remaining / service.getTotalSeconds();
        bgArc.setLength(360 * progress);
    }

    @FXML private void handlePlay() { service.start(); }
    @FXML private void handlePause() { service.pause(); }
}