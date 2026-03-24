package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TimerService {
    private static TimerService instance;
    private final Timer timer = new Timer();

    // Propriedade para a UI observar a contagem regressiva
    private final IntegerProperty remainingSeconds = new SimpleIntegerProperty(0);
    private int tickCounter = 0;

    private TimerService() {
        // Ouve o pulso de 10ms do ClockService
        ClockService.getInstance().tickProperty().addListener((obs, old, newVal) -> update());
    }

    public static TimerService getInstance() {
        if (instance == null) instance = new TimerService();
        return instance;
    }

    public void setTime(int h, int m, int s) {
        int total = (h * 3600) + (m * 60) + s;
        timer.setTotalSeconds(total);
        timer.setRemainingSeconds(total);
        remainingSeconds.set(total);
    }

    public void start() {
        if (remainingSeconds.get() > 0) timer.setRunning(true);
    }

    public void pause() { timer.setRunning(false); }

    private void update() {
        if (!timer.isRunning()) return;

        tickCounter++;
        if (tickCounter >= 100) { // 100 ticks de 10ms = 1 segundo
            tickCounter = 0;
            if (remainingSeconds.get() > 0) {
                remainingSeconds.set(remainingSeconds.get() - 1);
                timer.setRemainingSeconds(remainingSeconds.get());
            } else {
                timer.setRunning(false);
                // Futuro: Disparar som de alarme aqui
            }
        }
    }

    public IntegerProperty remainingSecondsProperty() { return remainingSeconds; }
    public int getTotalSeconds() { return timer.getTotalSeconds(); }
    public boolean isRunning() { return timer.isRunning(); }
}