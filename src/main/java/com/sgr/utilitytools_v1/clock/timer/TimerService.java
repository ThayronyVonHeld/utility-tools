package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TimerService {
    private static TimerService instance;
    private final Timer timer = new Timer();
    private final IntegerProperty remainingSecondsProp = new SimpleIntegerProperty(0);
    private int tickCounter = 0;

    private TimerService() {
        ClockService.getInstance().tickProperty().addListener((obs, old, newVal) -> update());
    }

    public static TimerService getInstance() {
        if (instance == null) instance = new TimerService();
        return instance;
    }

    public void setInitialTime(int totalSeconds) {
        timer.setTotalSeconds(totalSeconds);
        timer.setRemainingSeconds(totalSeconds);
        remainingSecondsProp.set(totalSeconds);
        timer.setRunning(false);
        tickCounter = 0;
    }

    public void start() {
        if (remainingSecondsProp.get() > 0) timer.setRunning(true);
    }

    public void pause() {
        timer.setRunning(false);
    }

    public void reset() {
        pause();
        timer.setRemainingSeconds(timer.getTotalSeconds());
        remainingSecondsProp.set(timer.getTotalSeconds());
        tickCounter = 0;
    }

    private void update() {
        if (!timer.isRunning()) return;

        tickCounter++;
        if (tickCounter >= 100) { // 100 ticks de 10ms = 1 segundo
            tickCounter = 0;
            if (remainingSecondsProp.get() > 0) {
                remainingSecondsProp.set(remainingSecondsProp.get() - 1);
            } else {
                timer.setRunning(false);
            }
        }
    }

    // Métodos que o Controller precisa:
    public IntegerProperty remainingSecondsProperty() { return remainingSecondsProp; }
    public int getRemainingSeconds() { return remainingSecondsProp.get(); }
    public int getTotalSeconds() { return timer.getTotalSeconds(); }
    public boolean isRunning() { return timer.isRunning(); }

    // Para a animação suave do arco
    public double getPreciseProgress() {
        if (timer.getTotalSeconds() <= 0) return 0;
        double totalTicks = timer.getTotalSeconds() * 100.0;
        double currentTicks = (remainingSecondsProp.get() * 100.0) - tickCounter;
        return currentTicks / totalTicks;
    }
}