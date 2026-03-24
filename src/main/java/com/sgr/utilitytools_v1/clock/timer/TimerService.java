package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockService;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TimerService {

    private final Timer timer = new Timer();
    private static TimerService instance;

    public static TimerService getInstance() {
        if (instance == null) {
            instance = new TimerService();
        }
        return instance;
    }

    public TimerService() {
        ClockService.getInstance().tickProperty().addListener((obs, oldVal, newVal) -> {
            update();
        });
    }

    public void setTime(int seconds) {
        timer.setTotalSeconds(seconds);
        timer.setRemainingSeconds(seconds);
    }

    public void start() {
        if (timer.isRunning()) return;
        timer.setRunning(true);
    }

    public void pause() {
        timer.setRunning(false);
    }

    public void reset() {
        timer.setRemainingSeconds(timer.getTotalSeconds());
        timer.setRunning(false);
    }

    private void update() {
        if (!timer.isRunning()) return;

        int remaining = timer.getRemainingSeconds() - 1;

        if (remaining <= 0) {
            timer.setRemainingSeconds(0);
            timer.setRunning(false);
            onFinish();
        } else {
            timer.setRemainingSeconds(remaining);
        }
    }

    private void onFinish() {
        System.out.println("⏰ Timer finalizado!");
        // tocar som depois
    }

    public int getRemainingSeconds() {
        return timer.getRemainingSeconds();
    }

    public int getTotalSeconds() {
        return timer.getTotalSeconds();
    }

    public boolean isRunning() {
        return timer.isRunning();
    }
}