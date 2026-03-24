package com.sgr.utilitytools_v1.clock.stopwatch;

import com.sgr.utilitytools_v1.clock.ClockService;
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

    private final StopwatchService service = new StopwatchService();
    private ChangeListener<Number> tickListener;

    @FXML
    public void initialize() {

        painel.setVisible(false);
        painel.setManaged(false);
        lapReset.setDisable(true);

        tickListener = (obs, oldVal, newVal) -> {
            lblTimer.setText(formatTime(service.getElapsedTime()));
        };

        ClockService.getInstance().tickProperty().addListener(tickListener);
    }

    @FXML
    private void startStopwatch() {

        lapReset.setDisable(false);

        if (service.isRunning()) {
            service.pause();
            startPause.setText("Play");
            lapReset.setText("Reset");
        } else {
            service.start();
            startPause.setText("Pause");
            lapReset.setText("Lap");
        }
    }

    @FXML
    public void lapReset() {

        if (service.isRunning()) {

            int lap = service.nextLap();

            listLap.getItems().add(
                    String.format("Lap %-3d | %s", lap, formatTime(service.getElapsedTime()))
            );

            painel.setVisible(true);
            painel.setManaged(true);

        } else {

            service.reset();

            lblTimer.setText(formatTime(0));
            listLap.getItems().clear();
            painel.setVisible(false);
            painel.setManaged(false);
            lapReset.setText("Lap");
            lapReset.setDisable(true);
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