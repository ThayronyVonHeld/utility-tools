package com.sgr.utilitytools_v1.clock.stopwatch;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StopwatchService {

    private static StopwatchService instance;
    private final Stopwatch stopwatch = new Stopwatch();
    private final ObservableList<String> laps = FXCollections.observableArrayList();

    private StopwatchService() {
        ClockService.getInstance().tickProperty().addListener((obs, oldVal, newVal) -> {
            update();
        });
    }

    public static StopwatchService getInstance() {
        if (instance == null) {
            instance = new StopwatchService();
        }
        return instance;
    }

    public void start() {
        if (stopwatch.isRunning()) return;

        stopwatch.setStartTime(System.nanoTime() - stopwatch.getElapsedTime());
        stopwatch.setRunning(true);
    }

    public void pause() {
        if (!stopwatch.isRunning()) return;

        stopwatch.setElapsedTime(System.nanoTime() - stopwatch.getStartTime());
        stopwatch.setRunning(false);
    }

    public ObservableList<String> getLaps() {
        return laps;
    }

    public int nextLap() {
        int lap = stopwatch.getLap() + 1;
        stopwatch.setLap(lap);
        laps.add(String.format("Lap %-3d | %s", lap, formatTime(getElapsedTime())));
        return lap;
    }

    public void reset() {
        stopwatch.setElapsedTime(0);
        stopwatch.setStartTime(System.nanoTime());
        stopwatch.setLap(0);
        stopwatch.setRunning(false);
        laps.clear();
    }

    public void update() {
        if (stopwatch.isRunning()) {
            long now = System.nanoTime();
            stopwatch.setElapsedTime(now - stopwatch.getStartTime());
        }
    }

    public long getElapsedTime() {
        return stopwatch.getElapsedTime();
    }

    public boolean isRunning() {
        return stopwatch.isRunning();
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
