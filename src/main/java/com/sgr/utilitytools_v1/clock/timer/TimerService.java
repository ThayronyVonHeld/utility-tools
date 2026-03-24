package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TimerService {
    private static TimerService instance;
    private final IntegerProperty remainingSeconds = new SimpleIntegerProperty(0);
    private int totalSeconds = 0;
    private boolean running = false;
    private int tickCounter = 0;

    private TimerService() {
        ClockService.getInstance().tickProperty().addListener((obs, old, newVal) -> update());
    }

    public static TimerService getInstance() {
        if (instance == null) instance = new TimerService();
        return instance;
    }

    public void setInitialTime(int seconds) {
        this.totalSeconds = seconds;
        this.remainingSeconds.set(seconds);
        this.running = false;
    }

    public void start() { if (remainingSeconds.get() > 0) running = true; }
    public void pause() { running = false; }

    private void update() {
        if (!running) return;
        tickCounter++;
        if (tickCounter >= 100) { // Sincroniza 10ms -> 1s
            tickCounter = 0;
            if (remainingSeconds.get() > 0) {
                remainingSeconds.set(remainingSeconds.get() - 1);
            } else {
                running = false;
            }
        }
    }

    public IntegerProperty remainingSecondsProperty() { return remainingSeconds; }
    public int getTotalSeconds() { return totalSeconds; }
    public boolean isRunning() { return running; }
}