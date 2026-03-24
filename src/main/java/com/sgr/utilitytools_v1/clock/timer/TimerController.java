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
        // Listener para atualizar a tela sempre que o tempo mudar no service
        service.remainingSecondsProperty().addListener((obs, old, newVal) -> {
            updateUI(newVal.intValue());
        });

        // Update inicial para não começar zerado
        updateUI(service.remainingSecondsProperty().get());
    }

    private void updateUI(int remaining) {
        int h = remaining / 3600;
        int m = (remaining % 3600) / 60;
        int s = remaining % 60;
        timeLabel.setText(String.format("%02d:%02d:%02d", h, m, s));

        if (service.getTotalSeconds() > 0) {
            double progress = (double) remaining / service.getTotalSeconds();
            bgArc.setLength(360 * progress);
        }
    }
}