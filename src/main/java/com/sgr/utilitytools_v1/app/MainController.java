package com.sgr.utilitytools_v1.app;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import com.sgr.utilitytools_v1.navigation.Navigator;

public class MainController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    public void initialize() {
        Navigator.setContentArea(contentArea);
        Navigator.loadDashboard(); // tela inicial
    }

    @FXML
    private void loadDashboard() {
        Navigator.loadDashboard();
    }

    @FXML
    private void loadAlarm() {
        Navigator.loadDashboard();
    }
}
