package com.sgr.utilitytools_v1.clock;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ClockNavigator {

    public static void loadClockView(StackPane pane, String fxml) {
        if (pane == null) {
            System.err.println("Erro: O StackPane de destino está nulo!");
            return;
        }
        try {
            Parent root = FXMLLoader.load(ClockNavigator.class.getResource(fxml));
            pane.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
