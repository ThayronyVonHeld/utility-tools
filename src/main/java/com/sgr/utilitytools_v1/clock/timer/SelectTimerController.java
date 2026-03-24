package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SelectTimerController {

    private final TimerService service = TimerService.getInstance();

    @FXML private StackPane paneSelectTime;

    private int horas = 0;
    private int minutos = 1;
    private int segundos = 0;

    @FXML
    private void playCronometro() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/SGR/UtilityTools/timer/timer.fxml")
            );

            Parent root = loader.load();

            int totalSegundos = (horas * 3600) + (minutos * 60) + segundos;

            // 🔥 estado vai pro service
            service.setTime(totalSegundos);
            service.start();

            // 🔥 troca tela
            paneSelectTime.getChildren().setAll(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}