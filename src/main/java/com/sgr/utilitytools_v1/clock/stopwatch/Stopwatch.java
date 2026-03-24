package com.sgr.utilitytools_v1.clock.stopwatch;

public class Stopwatch {

    private long startTime;
    private long elapsedTime = 0;
    private boolean running = false;
    private int lap = 0;

    public long getStartTime() { return startTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }

    public long getElapsedTime() { return elapsedTime; }
    public void setElapsedTime(long elapsedTime) { this.elapsedTime = elapsedTime; }

    public boolean isRunning() { return running; }
    public void setRunning(boolean running) { this.running = running; }

    public int getLap() { return lap; }
    public void setLap(int lap) { this.lap = lap; }
}