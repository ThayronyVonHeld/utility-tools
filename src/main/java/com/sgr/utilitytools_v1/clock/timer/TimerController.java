package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;

public class TimerController {
    @FXML private Arc bgArc;
    @FXML private Label timeLabel;

    private final TimerService service = TimerService.getInstance();

    @FXML
    public void initialize() {
        // Atualiza a cada 10ms para o arco se mover suavemente
        ClockService.getInstance().tickProperty().addListener((obs, old, newVal) -> {
            updateLabel();
        });
        updateLabel();
    }

    private void updateLabel() {
        int remaining = service.getRemainingSeconds();

        // Formata o texto
        int h = remaining / 3600;
        int m = (remaining % 3600) / 60;
        int s = remaining % 60;
        timeLabel.setText(String.format("%02d:%02d:%02d", h, m, s));

        // Animação suave do arco
        if (service.isRunning()) {
            bgArc.setLength(360 * service.getPreciseProgress());
        } else {
            double progress = service.getTotalSeconds() > 0 ?
                    (double) remaining / service.getTotalSeconds() : 0;
            bgArc.setLength(360 * progress);
        }
    }

    @FXML private void handlePlay() { service.start(); }
    @FXML private void handleStop() { service.pause(); }
    @FXML private void handleReset() { service.reset(); updateLabel(); }
}