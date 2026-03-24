package com.sgr.utilitytools_v1.clock.stopwatch;

import com.sgr.utilitytools_v1.clock.ClockService;

public class StopwatchService {
    public StopwatchService() {
        ClockService.getInstance().tickProperty().addListener((obs, oldVal, newVal) -> {
            update();
        });
    }
    private final Stopwatch stopwatch = new Stopwatch();

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

    public void reset() {
        stopwatch.setElapsedTime(0);
        stopwatch.setStartTime(System.nanoTime());
        stopwatch.setLap(0);
        stopwatch.setRunning(false);
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

    public int nextLap() {
        int lap = stopwatch.getLap() + 1;
        stopwatch.setLap(lap);
        return lap;
    }
}
