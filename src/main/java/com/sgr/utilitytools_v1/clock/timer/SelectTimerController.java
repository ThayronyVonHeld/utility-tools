package com.sgr.utilitytools_v1.clock.timer;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SelectTimerController {
    @FXML private Label lblHoras, lblMinutos, lblSegundos;
    private int h = 0, m = 0, s = 0;

    @FXML
    private void btnHmais() { h = (h < 23) ? h + 1 : 0; updateLabels(); }
    @FXML
    private void btnMmais() { m = (m < 59) ? m + 1 : 0; updateLabels(); }
    @FXML
    private void btnSmais() { s = (s < 59) ? s + 1 : 0; updateLabels(); }
    // ... implementar os métodos de "menos" seguindo a mesma lógica ...

    private void updateLabels() {
        lblHoras.setText(String.format("%02d", h));
        lblMinutos.setText(String.format("%02d", m));
        lblSegundos.setText(String.format("%02d", s));
    }

    @FXML
    private void playCronometro() {
        // Salva no Service Global
        TimerService.getInstance().setTime(h, m, s);
        TimerService.getInstance().start();

        // Navega para a tela de visualização (ajuste o caminho conforme seu projeto)
        Navigator.loadView("/com/sgr/utilitytools_v1/clock/timer/timer_display.fxml");
    }
}