package com.sgr.utilitytools_v1.stopwatch;

public class Stopwatch {

    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;

    public Stopwatch(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.remainingSeconds = totalSeconds;
        this.running = false;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void decrement() {
        if (remainingSeconds > 0) {
            remainingSeconds--;
        }
    }

    public boolean isFinished() {
        return remainingSeconds <= 0;
    }
}
