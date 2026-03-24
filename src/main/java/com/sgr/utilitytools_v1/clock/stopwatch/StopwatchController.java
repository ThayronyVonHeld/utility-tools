package com.sgr.utilitytools_v1.clock.stopwatch;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class StopwatchController {

    @FXML private Label lblTimer;
    @FXML private Button startPause;
    @FXML private Button lapReset;
    @FXML private ListView<String> listLap;
    @FXML private HBox painel;

    private final StopwatchService service = StopwatchService.getInstance();
    private ChangeListener<Number> tickListener;

    @FXML
    public void initialize() {

        listLap.setItems(service.getLaps()); // Vincula os itens da lista

        StopwatchService service = StopwatchService.getInstance();

        painel.visibleProperty().bind(Bindings.isEmpty(service.getLaps()).not());
        painel.managedProperty().bind(painel.visibleProperty()); // Vincula a visibilidade do painel

        updateButton(service.isRunning());
        lblTimer.setText(formatTime(service.getElapsedTime())); // Sincroniza o estado visual inicial

        tickListener = (obs, oldVal, newVal) -> {
            lblTimer.setText(formatTime(service.getElapsedTime())); // Listener para o tempo
        };
        ClockService.getInstance().tickProperty().addListener(tickListener);
    }


    @FXML
    private void btnStartStop() {
        if (service.isRunning()) {
            service.pause();
        } else {
            service.start();
        }
        updateButton(service.isRunning());
    }

    @FXML
    public void btnLapReset() {
        if (service.isRunning()) {
            service.nextLap();
        } else {
            service.reset();
            lblTimer.setText(formatTime(0));
        }
        // ESSENCIAL: Atualiza o estado dos botões após a mudança
        updateButton(service.isRunning());
    }

    private void updateButton(boolean isRunning) {
        if (isRunning) {
            startPause.setText("Pause");
            lapReset.setText("Lap");
            lapReset.setDisable(false);
        } else {
            startPause.setText("Play");

            if (service.getElapsedTime() > 0) {
                lapReset.setText("Reset");
                lapReset.setDisable(false);
            } else {
                lapReset.setText("Lap");
                lapReset.setDisable(true);
            }
        }
    }

    private String formatTime(long elapsedNano) {
        long millis = elapsedNano / 1_000_000;

        long h = millis / 3600000;
        long m = (millis % 3600000) / 60000;
        long s = (millis % 60000) / 1000;
        long ms = millis % 1000;

        return String.format("%02d:%02d:%02d.%03d", h, m, s, ms);
    }
}