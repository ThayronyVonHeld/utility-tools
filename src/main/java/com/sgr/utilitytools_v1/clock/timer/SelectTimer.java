package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.clock.ClockNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SelectTimer {

    @FXML private Label lblHoras;
    @FXML private Label lblMinutos;
    @FXML private Label lblSegundos;
    @FXML private StackPane paneSelectTime;

    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;

    @FXML
    private void btnHmais(){
        if(horas < 10){
            horas++;
        } else {
            horas = 0;
        }
        lblHoras.setText((String.format("%02d", horas)));
    }

    @FXML
    private void btnHmenos(){
        if (horas > 0) {
            horas--;
        } else {
            horas = 10;
        }
        lblHoras.setText((String.format("%02d", horas)));
    }

    @FXML
    private void btnMmais(){
        if(minutos < 59){
            minutos++;
        } else {
            minutos = 0;
        }
        lblMinutos.setText((String.format("%02d", minutos)));
    }

    @FXML
    private void btnMmenos(){
        if (minutos > 0) {
            minutos--;
        } else {
            minutos = 59;
        }
        lblMinutos.setText((String.format("%02d", minutos)));
    }

    @FXML
    private void btnSmais(){
        if(segundos < 59){
            segundos++;
        } else{
            segundos = 0;
        }
        lblSegundos.setText((String.format("%02d", segundos)));
    }

    @FXML
    private void btnSmenos(){
        if (segundos > 0) {
            segundos--;
        } else {
            segundos = 59;
        }
        lblSegundos.setText((String.format("%02d", segundos)));
    }

    int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;

    @FXML
    private void playTimer() { // Nome que apareceu no seu log de erro

        int total = (horas * 3600) + (minutos * 60) + segundos;

        TimerService.getInstance().setInitialTime(total);
        TimerService.getInstance().start();

        ClockNavigator.loadClockView(paneSelectTime, "/com/sgr/utilitytools_v1/clock/timer/timer.fxml");
    }
}