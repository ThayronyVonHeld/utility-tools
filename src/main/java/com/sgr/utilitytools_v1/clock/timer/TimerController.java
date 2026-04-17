package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockNavigator;
import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;

public class TimerController {
    @FXML private Arc bgArc;
    @FXML private Label timeLabel;
    @FXML private AnchorPane SelectTimerTeste;
    @FXML private AnchorPane PaneARC;
    @FXML private Label lblHoras;
    @FXML private Label lblMinutos;
    @FXML private Label lblSegundos;
    @FXML private StackPane paneSelectTime;

    private final TimerService service = TimerService.getInstance();

    @FXML
    public void initialize() {

        ClockService.getInstance().tickProperty().addListener((obs, old, newVal) -> {
            updateLabel();
        });
        updateLabel();
        SelectTimerTeste.setVisible(false);

    }

    private void updateLabel() {
        int remaining = service.getRemainingSeconds();

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


    // Aqui começa o Select

    @FXML
    private void OpenSelectTimer(){
        SelectTimerTeste.setVisible(true);
        PaneARC.opacityProperty().setValue(0.25);

    }

    @FXML
    private void btnHmais() {
        int horas = service.getHoras();
        if (horas < 10) {
            horas++;
            service.setH(horas);
        } else {
            horas = 0;
            service.setH(horas);
        }
        lblHoras.setText((String.format("%02d", horas)));

    }

    @FXML
    private void btnHmenos() {
        int horas = service.getHoras();
        if (horas > 0) {
            horas--;
            service.setH(horas);
        } else {
            horas = 10;
            service.setH(horas);
        }
        lblHoras.setText((String.format("%02d", horas)));

    }

    @FXML
    private void btnMmais() {
       int minutos = service.getMinutos();
        if (minutos < 59) {
            minutos++;
            service.setM(minutos);
        } else {
            minutos = 0;
            service.setM(minutos);
        }
        lblMinutos.setText((String.format("%02d", minutos)));

        }

    @FXML
    private void btnMmenos() {
        int minutos = service.getMinutos();
        if (minutos > 0) {
            minutos--;
            service.setM(minutos);
        } else {
            minutos = 59;
            service.setM(minutos);
        }
        lblMinutos.setText((String.format("%02d", minutos)));
    }

    @FXML
    private void btnSmais() {
        int segundos = service.getSegundos();
        if (segundos < 59) {
            segundos++;
            service.setS(segundos);
        } else {
            segundos = 0;
            service.setS(segundos);
        }
        lblSegundos.setText((String.format("%02d", segundos)));
    }

    @FXML
    private void btnSmenos() {
      int segundos = service.getSegundos();
        if (segundos > 0) {
            segundos--;
            service.setS(segundos);

        } else {
            segundos = 59;
            service.setS(segundos);
        }
        lblSegundos.setText((String.format("%02d", segundos)));
    }

    @FXML
    private void playTimer() {
        int total = (service.getHoras() * 3600) + (service.getMinutos() * 60) + service.getSegundos();
        TimerService.getInstance().setInitialTime(total);
        TimerService.getInstance().start();
        SelectTimerTeste.setVisible(false);
        PaneARC.opacityProperty().setValue(1);

    }
}

