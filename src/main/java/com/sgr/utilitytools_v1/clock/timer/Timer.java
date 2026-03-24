package com.sgr.utilitytools_v1.clock.timer;

public class Timer {

    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;

    public int getTotalSeconds() { return totalSeconds; }
    public void setTotalSeconds(int totalSeconds) { this.totalSeconds = totalSeconds; }

    public int getRemainingSeconds() { return remainingSeconds; }
    public void setRemainingSeconds(int remainingSeconds) { this.remainingSeconds = remainingSeconds; }

    public boolean isRunning() { return running; }
    public void setRunning(boolean running) { this.running = running; }
}