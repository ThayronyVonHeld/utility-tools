package com.sgr.utilitytools_v1.clock.timer;


public class Timer {
    private int totalSeconds;
    private int remainingSeconds;
    private boolean running;
    private int segundos;
    private int minutos;
    private int horas;

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getTotalSeconds() { return totalSeconds; }
    public void setTotalSeconds(int totalSeconds) { this.totalSeconds = totalSeconds; }
    public int getRemainingSeconds() { return remainingSeconds; }
    public void setRemainingSeconds(int remainingSeconds) { this.remainingSeconds = remainingSeconds; }
    public boolean isRunning() { return running; }
    public void setRunning(boolean running) { this.running = running; }
}