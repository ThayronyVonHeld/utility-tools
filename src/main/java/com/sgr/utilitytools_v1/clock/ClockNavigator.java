package com.sgr.utilitytools_v1.clock;

import com.sgr.utilitytools_v1.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ClockNavigator {

    private static StackPane mainClockPane;

    public static void setMainPane(StackPane pane) {
        mainClockPane = pane;
    }
    public static void loadClockView(String fxml) {
        try {
            Parent root = FXMLLoader.load(
                    Navigator.class.getResource(fxml)
            );
            mainClockPane.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
